package lab9_Task2;

import java.util.*;

abstract class Publication implements Comparable<Publication> {
    private String title;
    private int numberOfPages;
    private int yearPublished;
    private String author;
    private double price;

    public Publication(String title, int numberOfPages, int yearPublished, String author, double price) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.yearPublished = yearPublished;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public abstract boolean isMagazine();

    public boolean isPublishedLastDecade() {
        return yearPublished >= 2011 && yearPublished <= 2021;
    }

    public boolean isSameTypeAndAuthor(Publication other) {
        return this.isMagazine() == other.isMagazine() && this.author.equals(other.author);
    }

    public double getPrice() {
        return price;
    }

    public int compareTo(Publication other) {
        int titleComparison = this.title.compareTo(other.title);
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Integer.compare(other.yearPublished, this.yearPublished);
    }
}


