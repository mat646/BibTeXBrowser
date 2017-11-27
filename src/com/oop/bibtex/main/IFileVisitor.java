package com.oop.bibtex.main;

import com.oop.bibtex.main.entries.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface IFileVisitor {

    void visit(BibTeXFile bibTeXFile);

    void visit(StringEntity stringEntity);

    void visit(Comment comment);

    void visit(Preamble preamble);

    void visit(Article article);

    void visit(Book book);

    void visit(Booklet booklet);

    void visit(Conference conference);

    void visit(InBook inBook);

    void visit(InCollection inCollection);

    void visit(InProceedings inProceedings);

    void visit(Manual manual);

    void visit(MasterThesis masterThesis);

    void visit(Misc misc);

    void visit(PhdThesis phdThesis);

    void visit(Proceedings proceedings);

    void visit(TechReport techReport);

    void visit(Unpublished unpublished);

}

class BasicFileVisitor implements IFileVisitor {

    private Character symbol;
    private ArrayList<String> types;
    private ArrayList<String> authors;

    BasicFileVisitor(Character symbol, ArrayList<String> types, ArrayList<String> authors) {
        this.symbol = symbol;
        this.types = types;
        this.authors = authors;
    }

    void basicPrint(Entry entry, Attributes[] required, Attributes[] optional) {

        for (int i = 0; i < 40; i++)
            System.out.print(symbol);

        System.out.println("\n");

        System.out.println(entry.getClass().toString().split("\\.")[5].toUpperCase() + ": " + entry.key + "\n");

        List<Attributes> requiredAndOptional = new ArrayList<>(Arrays.asList(required));
        requiredAndOptional.addAll(Arrays.asList(optional));

        for (Attributes elem : requiredAndOptional) {
            String value = entry.records.get(elem);
            if (value != null) {
                if (elem == Attributes.AUTHOR) {

                    System.out.println(elem + ":");

                    for (String author : value.split("and ")) {
                        System.out.println("\t * " + author);
                    }

                } else {
                    System.out.println(elem + ": " + value);
                }
            }
        }

        System.out.println("\n");
    }

    @Override
    public void visit(BibTeXFile bibTeXFile) {

        System.out.println("End of file.\n");

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


        if (types == null || types.contains("ARTICLE"))
            if (authors == null || authors.contains(article.records.get(Attributes.AUTHOR)))
                basicPrint(article, Article.requiredFields, Article.optionalFields);

    }

    @Override
    public void visit(Book book) {

        basicPrint(book, Book.requiredFields, Book.optionalFields);

    }

    @Override
    public void visit(Booklet booklet) {

        basicPrint(booklet, Booklet.requiredFields, Booklet.optionalFields);

    }

    @Override
    public void visit(Conference conference) {

        basicPrint(conference, Conference.requiredFields, Conference.optionalFields);

    }

    @Override
    public void visit(InBook inBook) {

        basicPrint(inBook, InBook.requiredFields, InBook.optionalFields);

    }

    @Override
    public void visit(InCollection inCollection) {

        basicPrint(inCollection, InCollection.requiredFields, InCollection.optionalFields);

    }

    @Override
    public void visit(InProceedings inProceedings) {

        basicPrint(inProceedings, InProceedings.requiredFields, InProceedings.optionalFields);

    }

    @Override
    public void visit(Manual manual) {

        basicPrint(manual, Manual.requiredFields, Manual.optionalFields);

    }

    @Override
    public void visit(MasterThesis masterThesis) {

        basicPrint(masterThesis, MasterThesis.requiredFields, MasterThesis.optionalFields);

    }

    @Override
    public void visit(Misc misc) {

        basicPrint(misc, Misc.requiredFields, Misc.optionalFields);

    }

    @Override
    public void visit(PhdThesis phdThesis) {

        basicPrint(phdThesis, PhdThesis.requiredFields, PhdThesis.optionalFields);

    }

    @Override
    public void visit(Proceedings proceedings) {

        basicPrint(proceedings, Proceedings.requiredFields, Proceedings.optionalFields);

    }

    @Override
    public void visit(TechReport techReport) {

        basicPrint(techReport, TechReport.requiredFields, TechReport.optionalFields);

    }

    @Override
    public void visit(Unpublished unpublished) {

        basicPrint(unpublished, Unpublished.requiredFields, Unpublished.optionalFields);

    }
}

class FileVisitorWithFilters implements IFileVisitor {

    FileVisitorWithFilters(String[] params) {
    }

    @Override
    public void visit(BibTeXFile bibTeXFile) {

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

    }

    @Override
    public void visit(Book book) {

    }

    @Override
    public void visit(Booklet booklet) {

    }

    @Override
    public void visit(Conference conference) {

    }

    @Override
    public void visit(InBook inBook) {

    }

    @Override
    public void visit(InCollection inCollection) {

    }

    @Override
    public void visit(InProceedings inProceedings) {

    }

    @Override
    public void visit(Manual manual) {

    }

    @Override
    public void visit(MasterThesis masterThesis) {

    }

    @Override
    public void visit(Misc misc) {

    }

    @Override
    public void visit(PhdThesis phdThesis) {

    }

    @Override
    public void visit(Proceedings proceedings) {

    }

    @Override
    public void visit(TechReport techReport) {

    }

    @Override
    public void visit(Unpublished unpublished) {

    }
}
