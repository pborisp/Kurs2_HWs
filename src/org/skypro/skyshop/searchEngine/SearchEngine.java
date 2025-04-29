package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class SearchEngine implements Searchable {
    private List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void addSerch(Searchable searchable) {
        if (searchable != null) {
            this.searchables.add(searchable);
        }
    }

    public Map<String, Searchable> search(String searchTerm) throws BestResultNotFound {
        Map<String, Searchable> searchResult = new TreeMap<>();
        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i).getSearchTerm().contains(searchTerm)) {
                searchResult.put(searchables.get(i).getSearchTerm(), searchables.get(i));
            }
        }
        return searchResult;
    }

    public Searchable findSearchMaxRepeat(String subString) throws BestResultNotFound {
        Searchable rezult = null;
        int maxCount = 1;
        int count = 0;
        for (int i = 0; i < searchables.size(); i++) {
            if (count > maxCount) {
                maxCount = count;
                if (i < 1) {
                    rezult = searchables.get(i);
                } else {
                    rezult = searchables.get(i - 1);
                }
            }
            count = 0;
            int index = 0;
            int indexStr = searchables.get(i).getSearchTerm().indexOf(subString, index);
            while (indexStr != -1) {
                count++;
                index = indexStr + subString.length();
                indexStr = searchables.get(i).getSearchTerm().indexOf(subString, index);
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


    @Override
    public String getSearchTerm() {
        return "";
    }

    @Override
    public String getTypeContent() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SearchEngine that = (SearchEngine) o;
        return Objects.equals(searchables, that.searchables);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(searchables);
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchables=" + searchables +
                '}';
    }
}
