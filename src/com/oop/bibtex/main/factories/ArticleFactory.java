package com.oop.bibtex.main.factories;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.BibTeXEntity;
import com.oop.bibtex.main.entries.Article;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;

import java.util.Map;

import static com.oop.bibtex.main.Attributes.*;

public class ArticleFactory implements AbstractEntryFactory {


    /**
     *
     * @param records
     * @param key
     * @return
     * @throws IncompleteFieldsException
     */
    public static BibTeXEntity createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(JOURNAL) != null && records.get(YEAR) != null) {
            return new Article(records, key);
        } else {
            throw new IncompleteFieldsException("Article");
        }
    }
}