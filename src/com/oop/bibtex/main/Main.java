package com.oop.bibtex.main;

import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import com.oop.bibtex.main.exceptions.IncompleteOptionsException;
import com.oop.bibtex.main.parserComponents.Converter;
import com.oop.bibtex.main.parserComponents.FileParser;
import javafx.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Main {

    //-p --path -t --types -a --authors -s --symbol
    private static ArrayList<String> options = new ArrayList<>();
    static {
        options.add("-s");
        options.add("--symbol");
        options.add("-p");
        options.add("--path");
        options.add("-t");
        options.add("--types");
        options.add("-a");
        options.add("--authors");
    }

    public static void main(String[] args) {

        FileParser fileParser = new FileParser();
        Converter converter = new Converter();

        Character symbol = null;
        String path = null;
        ArrayList<String> types = new ArrayList<>();
        ArrayList<String> authors = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-s":
                case "--symbol":
                    assert i+1 < args.length;
                    symbol = args[i+1].charAt(0);
                    break;
                case "-p":
                case "--path":
                    assert i+1 < args.length;
                    path = args[i+1];
                    break;
                case "-t":
                case "--types":
                    for (;i < args.length-1; i++) {
                        if (!options.contains(args[i+1])) {
                            types.add(args[i+1].toUpperCase());
                        }
                    }
                    break;
                case "-a":
                case "--authors":
                    for (;i < args.length-1; i++) {
                        if (!options.contains(args[i+1])) {
                            authors.add(args[i+1].replace(",", " "));
                        }
                    }
                    break;
            }

        }

        try {

            //Intermediate form
            if (path == null) throw new IncompleteOptionsException("path");
            Pair<Map<String, Map<Attributes, String>>, Map<String, String>> bibTeXIntermediateForm =
                    fileParser.parse(path);

            //Objective form
            BibTeXFile bibTeXFile = converter.convert(bibTeXIntermediateForm);

            //Passing execution parameters
            if (symbol == null) throw new IncompleteOptionsException("symbol");
            BasicFileVisitor basicFileVisitor = new BasicFileVisitor(symbol, types, authors);

            //Printing on screen
            bibTeXFile.accept(basicFileVisitor);

        } catch (IOException | IncompleteFieldsException | IncompleteOptionsException e) {
            e.printStackTrace();
        }

    }
}
