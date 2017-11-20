package com.oop.bibtex.main;

import com.oop.bibtex.main.entries.Article;
import com.oop.bibtex.main.entries.Book;
import com.oop.bibtex.main.entries.Booklet;

public interface AbstractEntryFactory {

    public BibTeXEntity createEntity(String... p);

}

class ArticleFactory implements AbstractEntryFactory {

    @Override
    public BibTeXEntity createEntity(String... p) {

        return new Article();
    }
}

class BookFactory implements AbstractEntryFactory {

    @Override
    public BibTeXEntity createEntity(String... p) {

        return new Book();
    }
}

class BookletFactory implements AbstractEntryFactory {

    @Override
    public BibTeXEntity createEntity(String... p) {

        return new Booklet();
    }
}