package com.oop.bibtex.main;

public enum Months {

    jan, feb, mar, may, jun, jul, aug, sep, oct, nov, dec;

    @Override
    public String toString() {
        switch (this) {
            case jan:
                return "January";
            case feb:
                return "February";
            case mar:
                return "March";
            case may:
                return "May";
            case jun:
                return "June";
            case jul:
                return "July";
            case aug:
                return "August";
            case sep:
                return "September";
            case oct:
                return "October";
            case nov:
                return "November";
            case dec:
                return "December";
            default:
                return "None";
        }
    }
}
