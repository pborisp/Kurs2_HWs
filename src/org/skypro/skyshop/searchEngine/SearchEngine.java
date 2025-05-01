package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.BestResultNotFound;
import org.skypro.skyshop.Searchable;

import java.util.*;

public class SearchEngine{
    private Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public void addSerch(Searchable searchable) {
        if (searchable != null) {
            this.searchables.add(searchable);
        }
    }

    public Set<Searchable> search(String searchTerm) throws BestResultNotFound {
        Set<Searchable> searchResult = new TreeSet<>(new LongStringComparator());
        for (Searchable searchable : searchables) {
            if (searchable.getSearchTerm().contains(searchTerm)) {
                searchResult.add(searchable);
            }
        }
        return searchResult;
    }

    public Searchable findSearchMaxRepeat(String subString) throws BestResultNotFound {
        Searchable rezult = null;
        int maxCount = 1;
        int count = 0;
        for (Searchable searchable : searchables) {
            count = 0;
            int index = 0;
            int indexStr = searchable.getSearchTerm().indexOf(subString, index);
            while (indexStr != -1) {
                count++;
                index = indexStr + subString.length();
                indexStr = searchable.getSearchTerm().indexOf(subString, index);
            }
            if (count > maxCount) {
                maxCount = count;
                rezult = searchable;
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
