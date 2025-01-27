package com.example.project;

public class BookStore {

    // At least 2 attributes
    // 1) Book[] books
    // 2) User[] users (initialized to an empty array of 10 max users)
    private Book[] books;
    private User[] users;

    // Empty constructor
    public BookStore() {
        this.books = new Book[5];
        this.users = new User[10];
    }

    // Getter Methods
    public User[] getUsers() {
        return users;
    }

    public Book[] getBooks() {
        return books;
    }

    // Setter Methods
    public void setUsers(User[] users) {
        this.users = users;
    }

    // Add a user to the store
    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) { // Iterates through the users array to find an empty spot
            if (users[i] == null) {
                users[i] = user;
                break; // if an empty spot is found, change it, then break because there is no need to change multiple values
            }
        }
    }

    public void removeUser(User user) {
        String name = user.getName(); 
        //Compare each user name in the users list
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && users[i].getName().equals(name)) {
                users[i] = null; //if the user matches, set their value to null
            }
        }

        // Creating a list without null entries
        User[] newList = new User[users.length];
        int index = 0;
        for (int i = 0; i < users.length; i++) { // counts the length of the list
            if (users[i] != null) {
                // if the name is not null --> set it to a value in the new list
                newList[index] = users[i];
                // increment by one
                index++;
            }
        }
        users = newList; // setting users array to new list
    }


  /*
     Removes a book from the store's collection by title.
     If there are multiple copies, it decreases the quantity.
     If only one copy is left, the book is removed entirely. 
     */
     
    public void removeBook(Book book) {
        String name = book.getTitle();
        for (int i = 0; i < books.length; i++) {
            //compare the inputted book with each book in the list
            if (books[i] != null && books[i].getTitle().equals(name)) {
                if (books[i].getQuantity() > 1) { //if is found, quantity decrease by one
                    books[i].setQuantity(books[i].getQuantity() - 1);
                } else {
                    //if there is only one copy, then it will be empty
                    books[i] = null;
                }
                break; // break since we don't need to loop again
            }
        }

        // Shift the null books to the end of the list
        for (int i = 0; i < books.length - 1; i++) {
            if (books[i] == null && books[i + 1] != null) {
                books[i] = books[i + 1];
                books[i + 1] = null;
            }
        }

        // Create new list with no null values
        int index = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                index++;
            }
        }

        Book[] newList = new Book[index];
        for (int i = 0; i < index; i++) {
            // set the new list of books w/o null values
            newList[i] = books[i];
        }
        books = newList;
    }

    // Consolidate the users list by removing null values
    public void consolidateUsers() {
        User[] consolidatedList = new User[users.length];
        int index = 0;

        for (int i = 0; i < users.length; i++) { // checks if value is null and if no does not include it in the list
            if (users[i] != null) {
                consolidatedList[index] = users[i];
                index++; // increment 
            }
        }
        this.users = consolidatedList; // setting instance variable to list
    }

    // Add a book to the store
    public void addBook(Book book) {
        for (int i = 0; i < books.length; i++) { // iterates in books to find if there is a null value
            if (books[i] == null) { // if a null value is found insert book there
                books[i] = book;
                break;
            }
        }
    }

    // Insert a book at a specific index
    public void insertBook(Book book, int index) {
        if (index >= 0 && index < books.length) {
            // Shift the books to the right to make space
            for (int i = books.length - 1; i > index; i--) {
                books[i] = books[i - 1];
            }
            books[index] = book;
        }
    }


                            
    // Method to return book information as a string
    public String bookStoreBookInfo() {
        String info = "";
        for (Book book : books) {
            if (book != null) { // checks if book is null so it can't be inputted
                info += book.bookInfo() + "\n";
            }
        }
        return info;
    }

    // Method to return user information as a string
    public String bookStoreUserInfo() {
        String info = "";
        for (User user : users) { // same way at bookStorebookInfo
            if (user != null) {
                info += user.userInfo() + "\n";
            }
        }
        return info;
    }
}