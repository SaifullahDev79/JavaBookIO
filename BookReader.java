package book;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BookReader {
    private String fileName;

    public BookReader(String f) {
        this.fileName = f;
    }

    public Book readBookFrom(String fileName) {
        Book book = null;

        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName))) {
            book = (Book) input.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return book;
    }
}
