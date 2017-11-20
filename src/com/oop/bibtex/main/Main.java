package com.oop.bibtex.main;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	    //TODO create Parser and initiate parsing (returns OO representation)
        FileParser fileParser = new FileParser();


        try {
            BibTeXFile bibTeXFile = fileParser.parse("/usr/docs/file.bib");

            //TODO create Visitor to pass parameters and print proper values values
            BasicFileVisitor basicFileVisitor = new BasicFileVisitor('|');

            basicFileVisitor.visit(bibTeXFile);

        } catch (IOException e) {
            //TODO handle exception
        }




    }
}
