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

    public FileParser() {

    }

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

                            Map<Attributes, String> localMap1 = new HashMap<>();

                            String[] arr = key.split("=");
                            localMap1.put(Attributes.STRINGVALUE, arr[1]);

                            intermediateForm.put(arr[0].trim(), localMap1);
                            keyToTypeForm.put(arr[0].trim(), "STRING");

                            break;
                        case "PREAMBLE": break;
                        case "COMMENT": break;
                        default:

                            Map<Attributes, String> localMap = new HashMap<>();

                            while ((line = reader.readLine()) != null && !line.equals("}")) {

                                Pattern attributesPattern = Pattern.compile("\\s*([a-zA-Z]*)\\s?[=]\\s?([^,]*),?");

                                Matcher attributesMatcher = attributesPattern.matcher(line);
                                boolean attributesMatches = attributesMatcher.matches();

                                if (attributesMatches) {
                                    String attribute = attributesMatcher.group(1);
                                    String attributeValue = attributesMatcher.group(2);

                                    Attributes attr = Attributes.valueOf(attribute.toUpperCase());

                                    if (attributeValue.contains("\"") || attributeValue.contains("{")) {
                                        localMap.put(attr, attributeValue.substring(1, attributeValue.length()-1));
                                    } else {
                                        localMap.put(attr, attributeValue);
                                    }
                                }

                            }

                            intermediateForm.put(key, localMap);

                            break;
                    }

                }

            }

        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        return new Pair(intermediateForm, keyToTypeForm);
    }

}

class Converter {

    BibTeXFile convert(Pair<Map<String, Map<Attributes, String>>, Map<String, String>> intermediateForm) throws IncompleteFieldsException {

        BibTeXFile bibTeXFile = new BibTeXFile();

        Map<String, Map<Attributes, String>> keyToAttributes = intermediateForm.getKey();
        Map<String, String> keyToType = intermediateForm.getValue();

        for (String key : intermediateForm.getKey().keySet()) {

            Map<Attributes, String> toPass = new HashMap<>();

            String crossRefKey = keyToAttributes.get(key).get(Attributes.CROSSREF);

            if (crossRefKey != null) {

                Map<Attributes, String> crossRefAttributes = keyToAttributes.get(crossRefKey.toLowerCase());

                toPass.putAll(crossRefAttributes);
            }

            toPass.putAll(keyToAttributes.get(key));


            switch (keyToType.get(key).toUpperCase()) {
                case "ARTICLE":
                    BibTeXEntity article = ArticleFactory.createEntity(toPass);
                    bibTeXFile.put(key, article);
                    break;
                case "BOOK":
                    BibTeXEntity book = BookFactory.createEntity(toPass);
                    bibTeXFile.put(key, book);
                    break;
                case "BOOKLET":
                    BibTeXEntity booklet = BookletFactory.createEntity(toPass);
                    bibTeXFile.put(key, booklet);
                    break;
                case "CONFERENCE":
                    BibTeXEntity conference = ConferenceFactory.createEntity(toPass);
                    bibTeXFile.put(key, conference);
                    break;
                case "INBOOK":
                    BibTeXEntity inBook = InBookFactory.createEntity(toPass);
                    bibTeXFile.put(key, inBook);
                    break;
                case "INCOLLECTION":
                    BibTeXEntity inCollection = InCollectionFactory.createEntity(toPass);
                    bibTeXFile.put(key, inCollection);
                    break;
                case "INPROCEEDINGS":
                    BibTeXEntity inProceedings = InProceedingsFactory.createEntity(toPass);
                    bibTeXFile.put(key, inProceedings);
                    break;
                case "MANUAL":
                    BibTeXEntity manual = ManualFactory.createEntity(toPass);
                    bibTeXFile.put(key, manual);
                    break;
                case "MASTERTHESIS":
                    BibTeXEntity masterThesis = MasterThesisFactory.createEntity(toPass);
                    bibTeXFile.put(key, masterThesis);
                    break;
                case "MISC":
                    BibTeXEntity misc = MiscFactory.createEntity(toPass);
                    bibTeXFile.put(key, misc);
                    break;
                case "PHDTHESIS":
                    BibTeXEntity phdThesis = PhdThesisFactory.createEntity(toPass);
                    bibTeXFile.put(key, phdThesis);
                    break;
                case "PROCEEDINGS":
                    BibTeXEntity proceedings = ProceedingsFactory.createEntity(toPass);
                    bibTeXFile.put(key, proceedings);
                    break;
                case "TECHREPORT":
                    TechReport techReport = TechReportFactory.createEntity(toPass);
                    bibTeXFile.put(key, techReport);
                    break;
                case "UNPUBLISHED":
                    BibTeXEntity unpublished = UnpublishedFactory.createEntity(toPass);
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