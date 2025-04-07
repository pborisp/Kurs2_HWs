package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;

public class SearchEngine implements Searchable {
    private Searchable[] searchables;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    public String[] search(String searchTerm) throws BestResultNotFound{
        int count = 0;
        String[] searchResult = new String[5];
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null && searchables[i].getSearchTerm().contains(searchTerm)) {
                searchResult[count] = searchables[i].getStringRepresentation(searchTerm);
                count++;
                if (count == searchResult.length) {
                    return searchResult;
                }
            }
        }
        return searchResult;
    }

    public Searchable findSearchMaxRepeat(String subString) throws BestResultNotFound {
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
                int indexStr = searchables[i].getSearchTerm().indexOf(subString, index);
                while (indexStr != -1) {
                    count++;
                    index = indexStr + subString.length();
                    indexStr = searchables[i].getSearchTerm().indexOf(subString, index);
                }
            }
        }
        checkResult(rezult, subString);
        return rezult;
    }
    public static void checkResult(Searchable str, String text) {
        try {
            check(str);
        } catch (BestResultNotFound e) {
            System.out.print("По запросу '" + text + "' ничего не найдено ");
        }
    }

    private static void check(Searchable str) throws BestResultNotFound {
        if (str == null) {
            throw new BestResultNotFound();
        }
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
    public String getSearchTerm() {
        return "";
    }

    @Override
    public String getTypeContent() {
        return "";
    }
}
