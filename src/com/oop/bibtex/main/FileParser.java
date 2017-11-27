package com.oop.bibtex.main;

import com.oop.bibtex.main.entries.TechReport;
import com.oop.bibtex.main.exceptions.IncompleteFieldsException;
import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    public Pair<Map<String, Map<Attributes, String>>, Map<String, String>> parse(String path) throws IOException {

        Map<String, String> keyToTypeForm = new HashMap<>();
        Map<String, Map<Attributes, String>> intermediateForm = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;
            while ((line = reader.readLine()) != null) {

                Pattern pattern = Pattern.compile("^@([a-zA-Z]*)\\{([^,]*),*");

                Matcher matcher = pattern.matcher(line);
                boolean matches = matcher.matches();
                if (matches) {
                    String type = matcher.group(1);
                    String key  = matcher.group(2);

                    keyToTypeForm.put(key, type);

                    switch (type.toUpperCase()) {
                        case "STRING":

                            Map<Attributes, String> valueMap = new HashMap<>();
                            String[] arr = key.split("=");
                            valueMap.put(Attributes.STRINGVALUE, arr[1]);

                            intermediateForm.put(arr[0].trim(), valueMap);
                            keyToTypeForm.put(arr[0].trim(), "STRING");
                            break;
                        case "PREAMBLE": break;
                        case "COMMENT": break;
                        default:

                            Map<Attributes, String> attributesMap = new HashMap<>();
                            while ((line = reader.readLine()) != null && !line.equals("}")) {

                                Pattern attributesPattern = Pattern.compile("\\s*([a-zA-Z]*)\\s?[=]\\s?([^,]*),?");

                                Matcher attributesMatcher = attributesPattern.matcher(line);
                                boolean attributesMatches = attributesMatcher.matches();
                                if (attributesMatches) {
                                    String attribute = attributesMatcher.group(1);
                                    String attributeValue = attributesMatcher.group(2);

                                    String parsedAttributeValue = parseAttributeValue(attributeValue, intermediateForm);
                                    Attributes attr = Attributes.valueOf(attribute.toUpperCase());

                                    attributesMap.put(attr, parsedAttributeValue);
                                }

                            }

                            intermediateForm.put(key, attributesMap);
                            break;
                    }

                }

            }

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        return new Pair(intermediateForm, keyToTypeForm);
    }

    public String parseAttributeValue(String value, Map<String, Map<Attributes, String>> intermediateForm) {

        String[] elems = value.split("#");

        StringBuilder sb = new StringBuilder();
        for (String eleme : elems) {
            String elem = eleme.trim();
            if ((elem.charAt(0) == '"' && elem.charAt(elem.length()-1) == '"') ||
                    (elem.charAt(0) == '{' && elem.charAt(elem.length()-1) == '}')) {
                sb.append(elem.substring(1, elem.length()-1));
            } else {
                if (intermediateForm.get(elem) != null) {
                    sb.append(intermediateForm.get(elem).get(Attributes.STRINGVALUE));
                } else {
                    sb.append(elem);
                }
            }
        }

        return sb.toString();
    }

}

class Converter {

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