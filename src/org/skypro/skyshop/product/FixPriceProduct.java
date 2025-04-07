package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int fixPrice = 4500;

    public FixPriceProduct(String nameProduct) {
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
        return super.toString() + '\'' +
                " : фиксированная цена " + fixPrice + " рублей!!!";
    }
}
