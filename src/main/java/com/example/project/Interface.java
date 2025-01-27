package com.example.project;

import java.util.Scanner;

public class Interface {
    private int option = -1; // Stores the user's menu choice
    private BookStore bookStore; // Reference to the bookstore instance
    private Scanner scan = new Scanner(System.in); // Scanner for user input

    // Constructor to initialize the interface with a BookStore object
    public Interface(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    // Main method to run the interface loop
    public void run() {
        while (option != 0) { // Loop until user exits
            // Display menu options
            System.out.println("*************************** Welcome to the GFG Library ***************************");
            System.out.println("                          Select From The Following Options:");
            System.out.println("**********************************************************************************");
            System.out.println("Press 0 to Exit Application.");
            System.out.println("Press 1 to Add a New Book.");
            System.out.println("Press 2 to Upgrade Quantity of a Book.");
            System.out.println("Press 3 to Search a Book.");
            System.out.println("Press 4 to Show All Books.");
            System.out.println("Press 5 to Register a Student.");
            System.out.println("Press 6 to Show All Registered Students.");
            System.out.println("Press 7 to Check Out a Book.");
            System.out.println("Press 8 to Check In a Book.");
            System.out.println("**********************************************************************************");

            option = scan.nextInt(); // Read user input for menu selection
            scan.nextLine(); // Clear the input buffer

            // Handle menu options
            if (option == 0) {
                System.out.println("Thank you for visiting!");
            } else if (option == 1) {
                addBook(); // Add a new book
            } else if (option == 2) {
                upgradeBookQuantity(); // Upgrade book quantity
            } else if (option == 3) {
                searchBook(); // Search for a book
            } else if (option == 4) {
                showAllBooks(); // Display all books
            } else if (option == 5) {
                registerStudent(); // Register a new student
            } else if (option == 6) {
                showAllRegisteredStudents(); // Display all registered students
            } else if (option == 7) {
                checkOutBook(); // Check out a book
            } else if (option == 8) {
                checkInBook(); // Check in a book
            } else {
                System.out.println("Invalid option. Please try again."); // Handle invalid input
            }
        }

        scan.close(); // Close the scanner
    }

    // Adds a new book to the bookstore
    private void addBook() {
        System.out.print("Enter title: ");
        String title = scan.nextLine();
        System.out.print("Enter author: ");
        String author = scan.nextLine();
        System.out.print("Enter year published: ");
        int yearPublished = scan.nextInt();
        scan.nextLine(); // Clear the input buffer
        System.out.print("Enter ISBN: ");
        String isbn = scan.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scan.nextInt();

        Book bookAdded = new Book(title, author, yearPublished, isbn, quantity);
        bookStore.addBook(bookAdded); // Add book to the store
        System.out.println("Book added successfully!\n");
    }

    // Upgrades the quantity of an existing book
    private void upgradeBookQuantity() {
        System.out.print("Enter the title of the book to upgrade: ");
        String title = scan.nextLine();
        Book[] books = bookStore.getBooks();

        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                System.out.print("Enter the quantity to add: ");
                int quantity = scan.nextInt();
                book.setQuantity(book.getQuantity() + quantity); // Update book quantity
                System.out.println("Quantity updated successfully! New quantity: " + book.getQuantity());
                return;
            }
        }

        System.out.println("Book not found.\n");
    }

    // Searches for a book by title, author, or ISBN
    private void searchBook() {
        System.out.print("Enter the title, author, or ISBN to search: ");
        String searchTerm = scan.nextLine();
        Book[] books = bookStore.getBooks();

        for (Book book : books) {
            if (book != null && (book.getTitle().equalsIgnoreCase(searchTerm) || 
                                 book.getAuthor().equalsIgnoreCase(searchTerm) || 
                                 book.getIsbn().equalsIgnoreCase(searchTerm))) {
                System.out.println("Book found: " + book.bookInfo());
                return;
            }
        }

        System.out.println("Book not found.\n");
    }

    // Displays all books in the bookstore
    private void showAllBooks() {
        Book[] books = bookStore.getBooks();
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.bookInfo()); // Display book info
            }
        }
        System.out.println();
    }

    // Registers a new student in the system
    private void registerStudent() {
        System.out.print("Enter student's full name: ");
        String name = scan.nextLine();
        System.out.print("Enter student ID: ");
        String id = scan.nextLine();

        User newUser = new User(name, id);
        bookStore.addUser(newUser); // Add student to the system
        System.out.println("Student registered successfully!\n");
    }

    // Displays all registered students
    private void showAllRegisteredStudents() {
        User[] users = bookStore.getUsers();
        System.out.println("Registered Students:");
        for (User user : users) {
            if (user != null) {
                System.out.println(user.userInfo()); // Display user info
            }
        }
        System.out.println();
    }

    // Checks out a book for a student
    private void checkOutBook() {
        System.out.print("Enter your student ID: ");
        String studentId = scan.nextLine();
        User[] users = bookStore.getUsers();

        User user = null;
        for (User u : users) {
            if (u != null && u.getId().equals(studentId)) {
                user = u; // Find the user
                break;
            }
        }

        if (user == null) {
            System.out.println("Student not registered.\n");
            return;
        }

        System.out.print("Enter the title of the book to check out: ");
        String title = scan.nextLine();
        Book[] books = bookStore.getBooks();

        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                if (book.getQuantity() > 0) {
                    book.setQuantity(book.getQuantity() - 1); // Decrease quantity
                    System.out.println("Book checked out successfully: " + book.getTitle());
                    return;
                } else {
                    System.out.println("Book is out of stock.\n");
                    return;
                }
            }
        }

        System.out.println("Book not found.\n");
    }

    // Checks in a book for a student
    private void checkInBook() {
        System.out.print("Enter your student ID: ");
        String studentId = scan.nextLine();
        User[] users = bookStore.getUsers();

        User user = null;
        for (User u : users) {
            if (u != null && u.getId().equals(studentId)) {
                user = u; // Find the user
                break;
            }
        }

        if (user == null) {
            System.out.println("Student not registered.\n");
            return;
        }

        System.out.print("Enter the title of the book to check in: ");
        String title = scan.nextLine();
        Book[] books = bookStore.getBooks();

        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                book.setQuantity(book.getQuantity() + 1); // Increase quantity
                System.out.println("Book checked in successfully: " + book.getTitle());
                return;
            }
        }

        System.out.println("Book not found in the library.\n");
    }
}
