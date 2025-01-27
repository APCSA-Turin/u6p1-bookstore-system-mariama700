package com.example.project;

public class Book{
    // private attribures
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;

    // 1 constructor with 5 arguments that intitialize the attribtues of the class
    public Book(String title, String author, int yearPublished, String isbn, int quantity) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.isbn = isbn;
        this.quantity = quantity;
    }

    // getter method for title
    public String getTitle() {
        return title;
    }

    // setter method for title
    public void setTitle(String title) {
        this.title = title;
    }

    // getter method for author
    public String getAuthor() {
        return author;
    }

    // setter method for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // getter method for year published
    public int getYearPublished() {
        return yearPublished;
    }

    // setter method for year published
    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    // getter method for isbn
    public String getIsbn() {
        return isbn;
    }

    // setter method for isbn
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // getter method for quantity
    public int getQuantity() {
        return quantity;
    }

    // setter method for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // returns "Title: [], Author: [], Year: [], ISBN: [], Quantity: []
    public String bookInfo() {
        String str = "Title: " + title + ", Author: " + author + ", Year: " + yearPublished + ", ISBN: " + isbn + ", Quantity: " + quantity;
        return str;
    }
}