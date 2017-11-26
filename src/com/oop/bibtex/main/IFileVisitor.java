package com.oop.bibtex.main;

import com.oop.bibtex.main.entries.*;

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

    BasicFileVisitor(Character symbol) {
        this.symbol = symbol;
    }

    void basicPrint(Entry entry) {
        for (Attributes elem : Article.requiredFields) {
            String value = entry.records.get(elem);
            if (value != null) {
                System.out.println(elem + ": " + value);
            }
        }

        for (Attributes elem : Article.optionalFields) {
            String value = entry.records.get(elem);
            if (value != null) {
                System.out.println(elem + ": " + value);
            }
        }
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

class FileVisitorWithFilters implements IFileVisitor {

    FileVisitorWithFilters(String[] params){
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
