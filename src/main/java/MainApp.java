import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;

/**
 * naissur
 * 12.04.2017
 */
public class MainApp {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.ru/");
        Document htmlDocument = Jsoup.parse(url, 5000);
        Elements elements = htmlDocument.getElementsByTag("a");
        elements
                .stream()
                .filter(e -> e.attr("href").startsWith("http"))
                .forEach(e -> System.out.println(e.attr("href")));
    }
}