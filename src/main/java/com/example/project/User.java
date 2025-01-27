package com.example.project;

public class User {
    // Private attributes
    private String name;
    private String id;
    private Book[] books; // Array of Book objects, initially null

    // Constructor with two parameters
    public User(String name, String id) {
        this.name = name;
        this.id = id;
        this.books = new Book[5]; // Initialize with a fixed array size (5 books max)
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Setter for ID
    public void setId(String id) {
        this.id = id;
    }

    // Getter for book by index
    public Book getBook(int index) {
        // Check for valid index before accessing the array
        if (index >= 0 && index < books.length) {
            return books[index]; // Get specific book by index
        } else {
            return null; // Return null if the index is out of bounds
        }
    }

    // Setter for books array
    public void setBooks(Book[] books) {
        // Ensure that books array is not null and has a valid size
        if (books != null && books.length <= 5) {
            this.books = books;
        }
    }

    // Method to return book list information, returns "empty" if no book is assigned
    public String bookListInfo() {
        String result = "";
        for (Book book : books) {
            if (book != null) {
                result += book.bookInfo() + "\n"; // Add book info if it's not null
            } else {
                result += "empty\n"; // Indicate an empty slot if the book is null
            }
        }
        return result;
    }

    // Method to return user information
    public String userInfo() {
        return "Name: " + name + "\n" +
               "Id: " + id + "\n" +
               "Books: \n" +
               bookListInfo(); // Append the book list information
    }
}