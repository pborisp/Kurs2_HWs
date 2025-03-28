package org.skypro.skyshop.product;

public class fixPriceProduct extends Product {
    private static final int fixPrice = 4500;

    public fixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPrice() {
        return fixPrice;
    }

    @Override
    public Boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return nameProduct + '\'' +
                " : фиксированная цена " + fixPrice + " рублей!!!";
    }
}
