package org.skypro.skyshop;

public interface Searchable {
    String searchTerm();

    String typeContent();

    default String getStringRepresentation(String s) {
        return searchTerm() + " " + typeContent();
    }
}
