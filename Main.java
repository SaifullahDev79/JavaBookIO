package main;

import book.Book;
import book.BookReader;
import book.BookRetriever;
import book.BookWriter;

public class Main {

    public static void main(String[] args) {
    	new java.io.File(rootFolder).mkdirs();
  // ---> DONE      // Requirement: as in class, go to librivox and find the url for the text format 
  // ---> DONE      // Add at least two more books and add to the following array (you will need to populate the title and author fields)
        Book[] books = {
            new Book("Emma", "Jane Austen", "https://www.gutenberg.org/cache/epub/158/pg158.txt"),
            new Book("Sense and Sensibility", "Jane Austen", "https://www.gutenberg.org/cache/epub/161/pg161.txt"),
            new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "https://www.gutenberg.org/cache/epub/1661/pg1661.txt"),
            new Book("Frankenstein", "Mary Shelley", "https://www.gutenberg.org/cache/epub/84/pg84.txt")
        };

        for (int i = 0; i < books.length; i++) {
            Book currentBook = books[i];
            String fileName = rootFolder + "book" + i;

            currentBook.bookText = retrieve(books[i]);

            write(fileName, currentBook);

            Book book = read(fileName);
            System.out.println(book.title + " by " + book.author);
        }
    }

    // !!! do NOT make changes below this line
    private static final String rootFolder = "BOOKS/";

    private static String retrieve(Book book) {
        // Reads the book from the Internet
        BookRetriever retriever = new BookRetriever(book.urlString);
        return retriever.retrieve();
    }

    private static void write(String fileName, Book book) {
        // Writes the book to a local file
        BookWriter writer = new BookWriter();
        writer.writeBookTo(fileName, book);
    }

    private static Book read(String fileName) {
        // Reads the book from a local file
        BookReader reader = new BookReader(fileName);
        return reader.readBookFrom(fileName);
    }
}

