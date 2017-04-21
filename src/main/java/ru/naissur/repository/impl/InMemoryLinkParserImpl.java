package ru.naissur.repository.impl;

import org.springframework.stereotype.Repository;
import ru.naissur.repository.LinkParserRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * naissur
 * 21.04.2017
 */
@Repository
public class InMemoryLinkParserImpl implements LinkParserRepository {
    private List<String> repository = new ArrayList<>();

    @Override
    public void saveLinks(List<String> links) {
        repository.addAll(links);
    }

    @Override
    public List<String> getLinks() {
        return repository;
    }
}
