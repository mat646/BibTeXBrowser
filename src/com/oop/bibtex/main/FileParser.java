package com.oop.bibtex.main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileParser {

    public FileParser() {

    }

    public BibTeXFile parse(String path) throws IOException {

        //TODO parsing syntax with tokenizer
        Tokenizer tokenizer = new Tokenizer();
        Map<String, Map<Attributes, String>> intermediateForm = new HashMap<>();

        //TODO Creating objects with Concrete Factories

        return new BibTeXFile();
    }

}

class Tokenizer {

    Boolean checkSyntax(File file) {
        return false;
    }



}