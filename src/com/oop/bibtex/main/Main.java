package com.oop.bibtex.main;

import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import com.oop.bibtex.main.exceptions.IncompleteOptionsException;
import com.oop.bibtex.main.names.NameParser;
import com.oop.bibtex.main.parserComponents.Converter;
import com.oop.bibtex.main.parserComponents.FileParser;
import com.oop.bibtex.main.visitors.BasicFileVisitor;
import javafx.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author mat646 3.12.2017
 *
 *
 * Exemplary program arguments:
 *
 *      -p test/xampl.bib -s +
 *
 *      -p test/xampl.bib -s + -a L[eslie],A.,Aamport
 *
 *      -p test/xampl.bib -s + -t book -a Donald,E.,Knuth
 *
 *      -p test/xampl.bib -s + -t inproceedings -a Alfred,V.,Oaho Jeffrey,D.,Ullman
 *
 *      -p test/xampl.bib -s + -t book article
 *
 *      -p test/xampl.bib -s + -a {\\"{U}}nderwood,Ulrich
 *
 *      -p test/xampl.bib -s + -a Ulrich,{\\"{U}}nderwood
 *
 *
 */
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

    public static void main(String[] args) throws IOException{

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
                    if (args[i+1].length()==1)
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
                        } else break;
                    }
                    break;
                case "-a":
                case "--authors":
                    for (;i < args.length-1; i++) {
                        if (!options.contains(args[i+1])) {
                            authors.add(NameParser.parseName(args[i+1].replace(",", " ")));
                        } else break;
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
