package com.oop.bibtex.main.parserComponents;

import com.oop.bibtex.main.*;
import com.oop.bibtex.main.names.NameParser;
import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileParser {

    /**
     *
     * @param path to BibTeX file
     * @return intermediate form of file. First element of pair is map of entry keys and attributes.
     * Second element is map of entry keys and entry types.
     * @throws IOException is thrown when FileReader can't open or read file.
     */
    public Pair<Map<String, Map<Attributes, String>>, Map<String, String>> parse(String path) throws IOException {

        Map<String, String> keyToTypeForm = new HashMap<>();
        Map<String, Map<Attributes, String>> intermediateForm = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            String line;
            while ((line = reader.readLine()) != null) {

                Pattern pattern = Pattern.compile("^@([a-zA-Z]*)\\{([^,]*),*");

                Matcher matcher = pattern.matcher(line);
                boolean matches = matcher.matches();
                if (matches) {
                    String type = matcher.group(1);
                    String key = matcher.group(2);

                    keyToTypeForm.put(key, type);

                    switch (type.toUpperCase()) {
                        case "STRING":

                            Map<Attributes, String> valueMap = new HashMap<>();
                            String[] arr = key.split("=");
                            valueMap.put(Attributes.STRINGVALUE, arr[1].substring(1, arr[1].length() - 1));

                            intermediateForm.put(arr[0].trim(), valueMap);
                            keyToTypeForm.put(arr[0].trim(), "STRING");
                            break;
                        case "PREAMBLE":
                            break;
                        case "COMMENT":
                            break;
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


                                    if (attr == Attributes.AUTHOR) {
                                        attributesMap.put(attr, NameParser.parseName(parsedAttributeValue));
                                    } else {
                                        attributesMap.put(attr, parsedAttributeValue);
                                    }
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

    /**
     *
     * @param value is raw stream with character constrains.
     * @param intermediateForm is map of entry keys and their attributes.
     * @return is string with character constrains.
     */
    public String parseAttributeValue(String value, Map<String, Map<Attributes, String>> intermediateForm) {

        String[] elements = value.split("#");

        StringBuilder sb = new StringBuilder();
        for (String element : elements) {
            String elem = element.trim();
            if ((elem.charAt(0) == '"' && elem.charAt(elem.length() - 1) == '"') ||
                    (elem.charAt(0) == '{' && elem.charAt(elem.length() - 1) == '}')) {
                sb.append(elem.substring(1, elem.length() - 1));
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