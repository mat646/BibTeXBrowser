package com.oop.bibtex.main.visitors;

import com.oop.bibtex.main.*;
import com.oop.bibtex.main.entries.*;

/**
 *  Visitor pattern that allows to add functionality to group of classes without changing their implementation.
 */
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
