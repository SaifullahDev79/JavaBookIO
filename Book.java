package book;

import java.io.Serializable;

public class Book implements Serializable {
    public String title;
    public String author;
    public String urlString;
    public String bookText;

    public Book(String t, String a, String u) {
        this.title = t;
        this.author = a;
        this.urlString = u;
    }
}
