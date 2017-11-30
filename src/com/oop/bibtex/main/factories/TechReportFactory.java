package com.oop.bibtex.main.factories;

import com.oop.bibtex.main.Attributes;
import com.oop.bibtex.main.entries.TechReport;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;

import java.util.Map;

import static com.oop.bibtex.main.Attributes.*;

public class TechReportFactory implements AbstractEntryFactory {

    public static TechReport createEntity(Map<Attributes, String> records, String key) throws IncompleteFieldsException {

        if (records.get(AUTHOR) != null && records.get(TITLE) != null &&
                records.get(INSTITUTION) != null && records.get(YEAR) != null) {
            return new TechReport(records, key);
        } else {
            throw new IncompleteFieldsException("TechReport");
        }
    }
}
