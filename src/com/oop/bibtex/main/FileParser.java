package com.oop.bibtex.main;

import java.io.File;
import java.io.IOException;

public class FileParser {

    public FileParser() {

    }

    public BibTeXFile parse(String path) throws IOException {

        //TODO parsing syntax with tokenizer

        //TODO Creating objects with Concrete Factories

        return new BibTeXFile();
    }

}

class Tokenizer {

    Boolean checkSyntax(File file) {
        return false;
    }

}