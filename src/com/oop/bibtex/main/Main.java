package com.oop.bibtex.main;

import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
import javafx.util.Pair;
import java.io.IOException;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        FileParser fileParser = new FileParser();
        Converter converter = new Converter();


        //-p --path -t --types -a authors -s symbol
        GetOpt getOpt = new GetOpt(args, "-p:-t:-a:-s");


        String[] xd = getOpt.getCmdArgs();

        try {

            //Intermediate form
            Pair<Map<String, Map<Attributes, String>>, Map<String, String>> bibTeXIntermediateForm =
                    fileParser.parse("/home/mateusz/Pulpit/xampl.bib");

            //Objective form
            BibTeXFile bibTeXFile = converter.convert(bibTeXIntermediateForm);

            //Passing execution parameters
            BasicFileVisitor basicFileVisitor = new BasicFileVisitor('+', null, null);

            //Printing on screen
            bibTeXFile.accept(basicFileVisitor);

        } catch (IOException | IncompleteFieldsException e) {
            e.printStackTrace();
        }

    }
}
