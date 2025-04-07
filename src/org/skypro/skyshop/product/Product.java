package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;

    public Product(String nameProduct) {
        try {
            definitionNullString(nameProduct);
        } catch (IllegalArgumentException e) {
            System.out.println("Неправильное название продукта или название отсутствует");
        }
        this.nameProduct = nameProduct;
    }


    public void definitionNullString(String nameProduct) {
        if (nameProduct.isBlank()) {
            throw new IllegalArgumentException("Неправильное название продукта или название отсутствует");
        }
    }

    public void definitionPrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть меньше или равна 0");
        }
    }

    public void definitionBasePrice(int basePrice) {
        if (basePrice <= 0) {
            throw new IllegalArgumentException("Цена не может быть меньше или равна 0");
        }
    }

    public void definitionDiscount(int discount) {
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Процент скидки должен быть в диапазоне от 0 до 100 включительно");
        }
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract Boolean isSpecial();

    public abstract int getPrice();

    @Override
    public String getSearchTerm() {
        return nameProduct;
    }

    @Override
    public String getTypeContent() {
        return "PRODUCT";
    }

    @Override
    public String toString() {
        return nameProduct + '\'';
    }
}
