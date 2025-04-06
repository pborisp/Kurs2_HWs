package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;

public class SearchEngine implements Searchable {
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

    public Searchable findSearchMaxRepeat(String subString) {
        Searchable rezult = null;
        int maxCount = 1;
        int count = 0;
        for (int i = 0; i < searchables.length; i++) {
            if (count > maxCount) {
                maxCount = count;
                if (i < 1) {
                    rezult = searchables[i];
                } else {
                    rezult = searchables[i - 1];
                }
            }
            count = 0;
            int index = 0;
            if (searchables[i] != null) {
                int indexStr = searchables[i].searchTerm().indexOf(subString, index);
                while (indexStr != -1) {
                    count++;
                    index = indexStr + subString.length();
                    indexStr = searchables[i].searchTerm().indexOf(subString, index);
                }
            }
        }
        return rezult;
    }

    public void add(Searchable searchable) {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }
        }
    }

    @Override
    public String searchTerm() {
        return "";
    }

    @Override
    public String typeContent() {
        return "";
    }
}
