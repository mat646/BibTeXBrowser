package com.oop.bibtex.main.names;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NameParser {

    /**
     * Method that parses authors as BibTex defines (First - longest word starting with upper case,
     * Last - everything else)
     * @param rawNames is string of all authors connected with "and" key word
     * @see <a href="http://maverick.inria.fr/~Xavier.Decoret/resources/xdkbibtex/bibtex_summary.html#names">
     *     BibTex - names</a>
     * @return String after parsing it in BibTex manner connected with "and" key word.
     */
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
