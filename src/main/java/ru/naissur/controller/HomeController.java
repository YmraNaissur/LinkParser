package ru.naissur.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.naissur.repository.LinkParserRepository;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * naissur
 * 13.04.2017
 */

@Controller
public class HomeController {
    private final LinkParserRepository repository;

    @Autowired
    public HomeController(LinkParserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        System.out.println(repository.getLinks());
        model.addAttribute("links", repository.getLinks());
        return "main";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String parseAction(@ModelAttribute("link") String link, Model model) {
        try {
            // Если первый раз заходим на страницу, по-умолчанию у нас google.ru
            if ((link == null || link.equals(""))) {
                link = "https://www.google.ru";
            }

            System.out.println("Into POST method: " + link);
            List<String> links = new ArrayList<>();
            URL url = new URL(link);
            Document htmlDocument = Jsoup.parse(url, 15000);
            Elements elements = htmlDocument.getElementsByTag("a");
            elements
                    .stream()
                    .filter(e -> e.attr("href").startsWith("http"))
                    .forEach(e -> links.add(e.attr("href")));
            repository.saveLinks(links);
            model.addAttribute("links", repository.getLinks());
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
            System.exit(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return "main";
    }
}
