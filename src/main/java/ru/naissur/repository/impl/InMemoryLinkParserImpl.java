package ru.naissur.repository.impl;

import org.springframework.stereotype.Repository;
import ru.naissur.repository.LinkParserRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * naissur
 * 21.04.2017
 */
@Repository
public class InMemoryLinkParserImpl implements LinkParserRepository {
    private Map<String, List<String>> repository = new HashMap<>();

    @Override
    public void saveLinks(String address, List<String> links) {
        repository.put(address, links);
    }

    @Override
    public List<String> getLinks(String address) {
        return repository.get(address);
    }
}
