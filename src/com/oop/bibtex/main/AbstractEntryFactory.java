package com.oop.bibtex.main;

import com.oop.bibtex.main.entries.Article;
import com.oop.bibtex.main.entries.Book;
import com.oop.bibtex.main.entries.Booklet;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import java.util.Map;

public interface AbstractEntryFactory {

    public BibTeXEntity createEntity(Map<Attributes, String> records) throws IncompleteFieldsException;

}

class ArticleFactory implements AbstractEntryFactory {

    @Override
    public BibTeXEntity createEntity(Map<Attributes, String> records) {

        //TODO check required and optional

        return new Article(records);
    }
}

class BookFactory implements AbstractEntryFactory {

    @Override
    public BibTeXEntity createEntity(Map<Attributes, String> records) {

        //TODO check required and optional

        return new Book(records);
    }
}

class BookletFactory implements AbstractEntryFactory {

    @Override
    public BibTeXEntity createEntity(Map<Attributes, String> records) {

        //TODO check required and optional

        return new Booklet(records);
    }
}