package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productBasket;
    int sum;
    int countSpecial;

    public ProductBasket() {
        this.productBasket = new HashMap<>();
        this.sum = 0;
        this.countSpecial = 0;
    }

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getNameProduct(), k -> new ArrayList<>()).add(product);
        this.sum += product.getPrice();
        if (product.isSpecial()) {
            countSpecial++;
        }
    }

    public void printBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("в корзине пусто");
            System.out.println("Итого: 0 рублей");
            return;
        }

        for (Map.Entry<String, List<Product>> product : productBasket.entrySet()) {
            System.out.println(product.getKey() + product.getValue());
        }
        System.out.println("Итого: " + this.sum + " рублей");
        System.out.println("Специальных товаров: " + countSpecial + " шт");
        System.out.println();
    }

    public boolean findProduct(String name) {
        if (this.productBasket.containsKey(name)) {
            return true;
        }
        return false;
    }


    public void cleanBasket() {
        this.productBasket.clear();
        this.sum = 0;
        this.countSpecial = 0;
    }

    public List<Product> dellProduct(String name) {
        List<Product> listDellProducts = new ArrayList<>();
        if (this.productBasket.containsKey(name)) {
            listDellProducts = this.productBasket.get(name);
            this.productBasket.remove(name);
        }
        return listDellProducts;
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
