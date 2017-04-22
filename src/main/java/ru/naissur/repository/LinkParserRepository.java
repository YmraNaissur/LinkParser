package ru.naissur.repository;

import java.util.List;

/**
 * naissur
 * 21.04.2017
 */
public interface LinkParserRepository {
    // сохраняем все ссылки в БД
    void saveLinks(String address, List<String> links);
    // получаем все ссылки из БД
    List<String> getLinks(String address);
}