package com.oop.bibtex.main.names;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParser {

    public static String parseName(String rawNames){

        String[] authors = rawNames.split("and ");

        List<String> parsedAuthors = Arrays.stream(authors).map(s -> {
            String[] parts = s.split(" ");
            String longest = "";
            for (String part : parts) {
                if (part.length() > longest.length()) longest = part;
            }

            return longest.trim() + " " + s.replace(longest, "").trim();
        }).collect(Collectors.toList());

        return String.join("and ", parsedAuthors);
    }

}
