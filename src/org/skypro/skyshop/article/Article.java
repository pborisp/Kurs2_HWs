package org.skypro.skyshop.article;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public final class Article implements Searchable {
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
    public String getSearchTerm() {
        return "Название статьи: " + nameArticle;
    }

    @Override
    public String getTypeContent() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(nameArticle, article.nameArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nameArticle);
    }
}
