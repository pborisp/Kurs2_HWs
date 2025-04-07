package org.skypro.skyshop;

public interface Searchable {
    String getSearchTerm();

    String getTypeContent();

    default String getStringRepresentation(String s) {
        return getSearchTerm() + " " + getTypeContent();
    }
}
