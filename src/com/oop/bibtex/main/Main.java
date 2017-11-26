package com.oop.bibtex.main;

import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import javafx.util.Pair;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        FileParser fileParser = new FileParser();
        Converter converter = new Converter();

        try {

            //Intermediate form
            Pair<Map<String, Map<Attributes, String>>, Map<String, String>> bibTeXIntermediateForm =
                    fileParser.parse("/home/mateusz/Pulpit/xampl.bib");

            //Objective form
            BibTeXFile bibTeXFile = converter.convert(bibTeXIntermediateForm);

            //Passing execution parameters
            BasicFileVisitor basicFileVisitor = new BasicFileVisitor('+');

            //Printing on screen
            bibTeXFile.accept(basicFileVisitor);

        } catch (IOException | IncompleteFieldsException e) {
            //TODO handle exception
            System.out.println(e);
        }

    }
}
