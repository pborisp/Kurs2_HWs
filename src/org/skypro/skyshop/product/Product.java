package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    protected String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract Boolean isSpecial();

    public abstract int getPrice();

    @Override
    public String searchTerm() {
        return nameProduct;
    }

    @Override
    public String typeContent() {
        return " PRODUCT ";
    }

    @Override
    public String toString() {
        return nameProduct + '\'';
    }
}
