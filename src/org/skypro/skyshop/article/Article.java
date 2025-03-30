package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

public class Article implements Searchable {
    private String nameArticle;
    private String textArticle;

    public Article(String nameArticle, String textArticle) {
        this.nameArticle = nameArticle;
        this.textArticle = textArticle;
    }

    @Override
    public String toString() {
        return "Название статьи: " + nameArticle + '\n' +
                " Текст статьи: " + textArticle + '\'';
    }

    @Override
    public String searchTerm() {
        return "Название статьи: " + nameArticle + '\'' +
                " Текст статьи: " + textArticle + '\'';
    }

    @Override
    public String typeContent() {
        return " ARTICLE ";
    }
}
