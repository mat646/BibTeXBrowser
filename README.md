# BibTeXBrowser

Project for "Object Oriented Programming" course on "AGH - University of Science and Technology" in Cracow.


## How it works

BibTeXBrowser opens *.bib files and creates indentical objective form in Java. 
Then, based on given arguments, program prints filtered parts. Document can be filtered by:
- Authors
- Entry types

Exemplary arguments in **Main.java**.

Project shows proper usage of **Visitor** design pattern. It has been used to add 
filtering functionality to Entries classes without modifying them.


Project also shows proper usage of **Abstract Factory** design pattern, which allows to instantiate classes with common interface.



### Concept diagram

Diagram shows relations between abstract concepts. It isn't made in any UML standard. 

![Diagram](https://image.ibb.co/eJbUEb/Bib_Te_X_Browser.jpg)


Project contains JUnit5 tests for factories. 

## Used libraries

- [JUnit5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.0.2)
- Java8

## External links

- [Summary of BibTeX](http://maverick.inria.fr/~Xavier.Decoret/resources/xdkbibtex/bibtex_summary.html)
- [BibTeX on Wikipedia](https://en.wikipedia.org/wiki/BibTeX)
