package com.oop.bibtex.main.parserComponents;

import com.oop.bibtex.main.*;
import com.oop.bibtex.main.entries.TechReport;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import com.oop.bibtex.main.factories.*;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    /**
     *
     * Converter converts intermediate form into objective form.
     *
     * @param intermediateForm is pair of map of keys and Entry types and map of keys and collection of attributes
     * @return objective form of file.
     * @see BibTeXFile for more information.
     * @throws IncompleteFieldsException in case of incomplete collection of required fields.
     * @see IncompleteFieldsException
     */
    public BibTeXFile convert(Pair<Map<String, Map<Attributes, String>>, Map<String, String>> intermediateForm) throws IncompleteFieldsException {

        BibTeXFile bibTeXFile = new BibTeXFile();

        Map<String, Map<Attributes, String>> keyToAttributes = intermediateForm.getKey();
        Map<String, String> keyToType = intermediateForm.getValue();

        for (String key : intermediateForm.getKey().keySet()) {

            Map<Attributes, String> bundleForFactory = new HashMap<>();

            String crossRefKey = keyToAttributes.get(key).get(Attributes.CROSSREF);

            if (crossRefKey != null) {

                Map<Attributes, String> crossRefAttributes = keyToAttributes.get(crossRefKey.toLowerCase());

                bundleForFactory.putAll(crossRefAttributes);
            }

            bundleForFactory.putAll(keyToAttributes.get(key));

            switch (keyToType.get(key).toUpperCase()) {
                case "ARTICLE":
                    BibTeXEntity article = ArticleFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, article);
                    break;
                case "BOOK":
                    BibTeXEntity book = BookFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, book);
                    break;
                case "BOOKLET":
                    BibTeXEntity booklet = BookletFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, booklet);
                    break;
                case "CONFERENCE":
                    BibTeXEntity conference = ConferenceFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, conference);
                    break;
                case "INBOOK":
                    BibTeXEntity inBook = InBookFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, inBook);
                    break;
                case "INCOLLECTION":
                    BibTeXEntity inCollection = InCollectionFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, inCollection);
                    break;
                case "INPROCEEDINGS":
                    BibTeXEntity inProceedings = InProceedingsFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, inProceedings);
                    break;
                case "MANUAL":
                    BibTeXEntity manual = ManualFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, manual);
                    break;
                case "MASTERTHESIS":
                    BibTeXEntity masterThesis = MasterThesisFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, masterThesis);
                    break;
                case "MISC":
                    BibTeXEntity misc = MiscFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, misc);
                    break;
                case "PHDTHESIS":
                    BibTeXEntity phdThesis = PhdThesisFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, phdThesis);
                    break;
                case "PROCEEDINGS":
                    BibTeXEntity proceedings = ProceedingsFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, proceedings);
                    break;
                case "TECHREPORT":
                    TechReport techReport = TechReportFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, techReport);
                    break;
                case "UNPUBLISHED":
                    BibTeXEntity unpublished = UnpublishedFactory.createEntity(bundleForFactory, key);
                    bibTeXFile.put(key, unpublished);
                    break;
                case "STRING":
                    bibTeXFile.put(key, new StringEntity(keyToAttributes.get(key).get(Attributes.STRINGVALUE), key));
                default:
                    break;
            }
        }

        return bibTeXFile;
    }

}