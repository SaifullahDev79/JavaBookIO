package book;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

public class BookRetriever{
    private String resourcePath;

    public BookRetriever(String r) {
        this.resourcePath = r;
    }

    public String retrieve() {
        StringBuilder contents = new StringBuilder();

        URI uri = null;
        URL url = null;
        Scanner input = null;

        try {
            uri = new URI(resourcePath);
            url = uri.toURL();

            input = new Scanner(url.openStream());
        } catch (URISyntaxException e) {
            contents.append("URI error");
        } catch (MalformedURLException e) {
            contents.append("URL error");
        } catch (IOException e) {
            contents.append("Unable to read book...");
        } finally {
            if (input != null) input.close();
        }

        return contents.toString();
    }
}
