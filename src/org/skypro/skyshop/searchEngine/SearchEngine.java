package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.Searchable;

public class SearchEngine {
    private Searchable[] searchables;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public String[] search(String searchTerm) {
        int count = 0;
        String[] searchRezult = new String[5];
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null && searchables[i].searchTerm().contains(searchTerm)) {
                searchRezult[count] = searchables[i].getStringRepresentation(searchTerm);
                count++;
                if (count == searchRezult.length) {
                    return searchRezult;
                }
            }
        }
        return searchRezult;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i]  = searchable;
                return;
            }
        }
    }
}
