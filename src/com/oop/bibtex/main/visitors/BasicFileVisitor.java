package com.oop.bibtex.main.visitors;

import com.oop.bibtex.main.*;
import com.oop.bibtex.main.entries.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicFileVisitor implements IFileVisitor {

    private Character symbol;
    private ArrayList<String> types;
    private ArrayList<String> authors;

    public BasicFileVisitor(Character symbol, ArrayList<String> types, ArrayList<String> authors) {
        this.symbol = symbol;
        this.types = types;
        this.authors = authors;
    }

    /**
     * Printing Entity in terminal.
     * @param entry is instance of BibTex object that is going to be printed.
     * @param required - static collection of required attributes.
     * @param optional - static collection of optional attributes.
     */
    void basicPrint(Entry entry, Attributes[] required, Attributes[] optional) {

        String toBePrinted;

        for (int i = 0; i < 80; i++)
            System.out.print(symbol);
        System.out.println();

        toBePrinted = "" + symbol;
        System.out.print(toBePrinted);
        printWhitespaces(toBePrinted.length());

        toBePrinted = symbol + " " + entry.getClass().toString().split("\\.")[5].toUpperCase() + ": " + entry.key;
        System.out.print(toBePrinted);
        printWhitespaces(toBePrinted.length());

        toBePrinted = "" + symbol;
        System.out.print(toBePrinted);
        printWhitespaces(toBePrinted.length());

        List<Attributes> requiredAndOptional = new ArrayList<>(Arrays.asList(required));
        requiredAndOptional.addAll(Arrays.asList(optional));

        for (Attributes elem : requiredAndOptional) {
            String value = entry.records.get(elem);
            if (value != null) {
                if (elem == Attributes.AUTHOR) {

                    toBePrinted = symbol + " " + elem + ":";
                    System.out.print(toBePrinted);
                    printWhitespaces(toBePrinted.length());

                    for (String author : value.split("and ")) {
                        toBePrinted = symbol + " " + "    * " + author;
                        System.out.print(toBePrinted);
                        printWhitespaces(toBePrinted.length());
                    }

                } else {
                    toBePrinted = symbol + " " + elem + ": " + value;
                    System.out.print(toBePrinted);
                    printWhitespaces(toBePrinted.length());
                }
            }
        }

        toBePrinted = "" + symbol;
        System.out.print(toBePrinted);
        printWhitespaces(toBePrinted.length());
    }

    /**
     * Prints right bar of frame
     * @param alreadyIn - number of already printed characters.
     */
    private void printWhitespaces(int alreadyIn){
        for (int i = 0; i < 80 - alreadyIn - 1; i++)
            System.out.print(" ");
        System.out.print(symbol + "\n");
    }

    @Override
    public void visit(BibTeXFile bibTeXFile) {

        for (int i = 0; i < 80; i++)
            System.out.print(symbol);
        System.out.println();

    }

    @Override
    public void visit(StringEntity stringEntity) {

    }

    @Override
    public void visit(Comment comment) {

    }

    @Override
    public void visit(Preamble preamble) {

    }

    @Override
    public void visit(Article article) {

        if (types.isEmpty() || types.contains("ARTICLE"))
            if (authors.isEmpty() || new ArrayList<>(Arrays.asList(article.records.get(Attributes.AUTHOR)
                    .split("and "))).containsAll(authors))
                basicPrint(article, Article.requiredFields, Article.optionalFields);

    }

    @Override
    public void visit(Book book) {

        if (types.isEmpty() || types.contains("BOOK"))
            if (authors.isEmpty() || (book.records.get(Attributes.AUTHOR) != null &&
                    new ArrayList<>(Arrays.asList(book.records.get(Attributes.AUTHOR)
                            .split("and "))).containsAll(authors)))
                basicPrint(book, Book.requiredFields, Book.optionalFields);

    }

    @Override
    public void visit(Booklet booklet) {

        if (types.isEmpty() || types.contains("BOOKLET"))
            if (authors.isEmpty() || (booklet.records.get(Attributes.AUTHOR) != null &&
                    new ArrayList<>(Arrays.asList(booklet.records.get(Attributes.AUTHOR)
                            .split("and "))).containsAll(authors)))
                basicPrint(booklet, Booklet.requiredFields, Booklet.optionalFields);

    }

    @Override
    public void visit(Conference conference) {

        if (types.isEmpty() || types.contains("CONFERENCE"))
            if (authors.isEmpty() || new ArrayList<>(Arrays.asList(conference.records.get(Attributes.AUTHOR)
                    .split("and "))).containsAll(authors))
                basicPrint(conference, Conference.requiredFields, Conference.optionalFields);

    }

    @Override
    public void visit(InBook inBook) {

        if (types.isEmpty() || types.contains("INBOOK"))
            if (authors.isEmpty() || new ArrayList<>(Arrays.asList(inBook.records.get(Attributes.AUTHOR)
                    .split("and "))).containsAll(authors))
                basicPrint(inBook, InBook.requiredFields, InBook.optionalFields);

    }

    @Override
    public void visit(InCollection inCollection) {

        if (types.isEmpty() || types.contains("INCOLLECTION"))
            if (authors.isEmpty() || new ArrayList<>(Arrays.asList(inCollection.records.get(Attributes.AUTHOR)
                    .split("and "))).containsAll(authors))
                basicPrint(inCollection, InCollection.requiredFields, InCollection.optionalFields);

    }

    @Override
    public void visit(InProceedings inProceedings) {

        if (types.isEmpty() || types.contains("INPROCEEDINGS"))
            if (authors.isEmpty() || new ArrayList<>(Arrays.asList(inProceedings.records.get(Attributes.AUTHOR)
                    .split("and "))).containsAll(authors))
                basicPrint(inProceedings, InProceedings.requiredFields, InProceedings.optionalFields);

    }

    @Override
    public void visit(Manual manual) {

        if (types.isEmpty() || types.contains("MANUAL"))
            if (authors.isEmpty() || (manual.records.get(Attributes.AUTHOR) != null &&
                    new ArrayList<>(Arrays.asList(manual.records.get(Attributes.AUTHOR)
                            .split("and "))).containsAll(authors)))
                basicPrint(manual, Manual.requiredFields, Manual.optionalFields);

    }

    @Override
    public void visit(MasterThesis masterThesis) {

        if (types.isEmpty() || types.contains("MASTERTHESIS"))
            if (authors.isEmpty() || new ArrayList<>(Arrays.asList(masterThesis.records.get(Attributes.AUTHOR)
                    .split("and "))).containsAll(authors))
                basicPrint(masterThesis, MasterThesis.requiredFields, MasterThesis.optionalFields);

    }

    @Override
    public void visit(Misc misc) {

        if (types.isEmpty() || types.contains("MISC"))
            if (authors.isEmpty() || (misc.records.get(Attributes.AUTHOR) != null &&
                    new ArrayList<>(Arrays.asList(misc.records.get(Attributes.AUTHOR)
                            .split("and "))).containsAll(authors)))
                basicPrint(misc, Misc.requiredFields, Misc.optionalFields);

    }

    @Override
    public void visit(PhdThesis phdThesis) {

        if (types.isEmpty() || types.contains("PHDTHESIS"))
            if (authors.isEmpty() || new ArrayList<>(Arrays.asList(phdThesis.records.get(Attributes.AUTHOR)
                    .split("and "))).containsAll(authors))
                basicPrint(phdThesis, PhdThesis.requiredFields, PhdThesis.optionalFields);

    }

    @Override
    public void visit(Proceedings proceedings) {

        if (types.isEmpty() || types.contains("PROCEEDINGS"))
            if (authors.isEmpty() || (proceedings.records.get(Attributes.AUTHOR) != null &&
                    new ArrayList<>(Arrays.asList(proceedings.records.get(Attributes.AUTHOR)
                            .split("and "))).containsAll(authors)))
                basicPrint(proceedings, Proceedings.requiredFields, Proceedings.optionalFields);

    }

    @Override
    public void visit(TechReport techReport) {

        if (types.isEmpty() || types.contains("TECHREPORT"))
            if (authors.isEmpty() || new ArrayList<>(Arrays.asList(techReport.records.get(Attributes.AUTHOR)
                    .split("and "))).containsAll(authors))
                basicPrint(techReport, TechReport.requiredFields, TechReport.optionalFields);

    }

    @Override
    public void visit(Unpublished unpublished) {

        if (types.isEmpty() || types.contains("UNPUBLISHED"))
            if (authors.isEmpty() || new ArrayList<>(Arrays.asList(unpublished.records.get(Attributes.AUTHOR)
                    .split("and "))).containsAll(authors))
                basicPrint(unpublished, Unpublished.requiredFields, Unpublished.optionalFields);

    }
}
