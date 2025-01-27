package com.example.project;

public class Main {
    public static void main(String[] args) {
      BookStore bookStore = new BookStore();
      Interface interfaceObj = new Interface(bookStore);
      interfaceObj.run();
    }
  }