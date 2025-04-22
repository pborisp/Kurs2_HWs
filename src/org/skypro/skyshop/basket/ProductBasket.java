package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private List<Product> productBasket;

    public ProductBasket() {
        this.productBasket = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productBasket.add(product);
    }

    public void printBasket() {
        if (isNullOrEmpty(productBasket)) {
            System.out.println("в корзине пусто");
            System.out.println("Итого: 0 рублей");
            return;
        }
        int sum = 0;
        int countSpecial = 0;
        for (int i = 0; i < productBasket.size(); i++) {
            if (this.productBasket.get(i) != null) {
                sum += this.productBasket.get(i).getPrice();
            }
            if (this.productBasket.get(i).isSpecial()) {
                countSpecial++;
            }
        }
        System.out.println(this.productBasket);
        System.out.println("Итого: " + sum + " рублей");
        System.out.println("Специальных товаров: " + countSpecial + " шт");
        System.out.println();
    }

    public boolean findProduct(String name) {
        for (int i = 0; i < productBasket.size(); i++) {
            if (this.productBasket.isEmpty() || this.productBasket.get(i).getNameProduct().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
            this.productBasket.clear();
    }

    public List<Product> dellProduct(String name) {
        Iterator<Product> iterator = this.productBasket.iterator();
        List<Product> listDellProducts = new ArrayList<>();
        while (iterator.hasNext()) {
            Product dellProduct = iterator.next();
            if (dellProduct.getNameProduct().equals(name)) {
                iterator.remove();
                listDellProducts.add(dellProduct);
            }
        }
        return listDellProducts;
    }

    public boolean isNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "productBasket=" + productBasket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket basket = (ProductBasket) o;
        return Objects.deepEquals(productBasket, basket.productBasket);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productBasket);
    }
}
