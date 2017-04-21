package ru.naissur.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@ModelAttribute("link") String link, Model model) {
        try {
            // Если первый раз заходим на страницу, по-умолчанию у нас google.ru
            if ((link == null || link.equals(""))) {
                link = "https://www.google.ru";
            }

            System.out.println("Into GET method: " + link);
            List<String> links = new ArrayList<>();
            URL url = new URL(link);
            Document htmlDocument = Jsoup.parse(url, 15000);
            Elements elements = htmlDocument.getElementsByTag("a");
            elements
                    .stream()
                    .filter(e -> e.attr("href").startsWith("http"))
                    .forEach(e -> links.add(e.attr("href")));
            model.addAttribute("links", links);
        } catch (MalformedURLException e) {
            System.out.println("Invalid URL");
            System.exit(1);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        return "main";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String parseAction(@ModelAttribute("link") String link, Model model) {
        System.out.println(link);
        model.addAttribute("link", link);
        return "redirect:/";
    }
}
