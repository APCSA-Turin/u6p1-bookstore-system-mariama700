package com.example.project;

import java.util.Scanner;

public class Interface {
    private int option = -1;
    private BookStore bookStore;
    private Scanner scan = new Scanner(System.in);

    public Interface(BookStore bookStore) {
        this.bookStore = bookStore;
    }

    public void run() {
        while (option != 0) {
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

            option = scan.nextInt();
            scan.nextLine(); // Clear the input buffer

            if (option == 0) {
                System.out.println("Thank you for visiting!");
            } else if (option == 1) {
                addBook();
            } else if (option == 2) {
                upgradeBookQuantity();
            } else if (option == 3) {
                searchBook();
            } else if (option == 4) {
                showAllBooks();
            } else if (option == 5) {
                registerStudent();
            } else if (option == 6) {
                showAllRegisteredStudents();
            } else if (option == 7) {
                checkOutBook();
            } else if (option == 8) {
                checkInBook();
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scan.close();
    }

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
        bookStore.addBook(bookAdded);
        System.out.println("Book added successfully!\n");
    }

    private void upgradeBookQuantity() {
        System.out.print("Enter the title of the book to upgrade: ");
        String title = scan.nextLine();
        Book[] books = bookStore.getBooks();

        for (Book book : books) {
            if (book != null && book.getTitle().equalsIgnoreCase(title)) {
                System.out.print("Enter the quantity to add: ");
                int quantity = scan.nextInt();
                book.setQuantity(book.getQuantity() + quantity);
                System.out.println("Quantity updated successfully! New quantity: " + book.getQuantity());
                return;
            }
        }

        System.out.println("Book not found.\n");
    }

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

    private void showAllBooks() {
        Book[] books = bookStore.getBooks();
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book != null) {
                System.out.println(book.bookInfo());
            }
        }
        System.out.println();
    }

    private void registerStudent() {
        System.out.print("Enter student's full name: ");
        String name = scan.nextLine();
        System.out.print("Enter student ID: ");
        String id = scan.nextLine();

        User newUser = new User(name, id);
        bookStore.addUser(newUser);
        System.out.println("Student registered successfully!\n");
    }

    private void showAllRegisteredStudents() {
        User[] users = bookStore.getUsers();
        System.out.println("Registered Students:");
        for (User user : users) {
            if (user != null) {
                System.out.println(user.userInfo());
            }
        }
        System.out.println();
    }

    private void checkOutBook() {
        System.out.print("Enter your student ID: ");
        String studentId = scan.nextLine();
        User[] users = bookStore.getUsers();

        User user = null;
        for (User u : users) {
            if (u != null && u.getId().equals(studentId)) {
                user = u;
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
                    book.setQuantity(book.getQuantity() - 1);
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

    private void checkInBook() {
        System.out.print("Enter your student ID: ");
        String studentId = scan.nextLine();
        User[] users = bookStore.getUsers();

        User user = null;
        for (User u : users) {
            if (u != null && u.getId().equals(studentId)) {
                user = u;
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
                book.setQuantity(book.getQuantity() + 1);
                System.out.println("Book checked in successfully: " + book.getTitle());
                return;
            }
        }

        System.out.println("Book not found in the library.\n");
    }
}