package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Stream;

public class ProductBasket {
    private Map<String, List<Product>> productBasket;

    public ProductBasket() {
        this.productBasket = new HashMap<>();
    }

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getNameProduct(), k -> new ArrayList<>()).add(product);
    }

    public void printBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("в корзине пусто");
            System.out.println("Итого: 0 рублей");
            return;
        }

        productBasket.values().stream()
                .flatMap(Collection::stream)
                        .forEach(System.out::println);

        System.out.println("Итого: " + productBasket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum() + " рублей");
        System.out.println("Специальных товаров: " + getSpecialCount() + " шт");
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
    }

    public List<Product> dellProduct(String name) {
        List<Product> listDellProducts = new ArrayList<>();
        if (this.productBasket.containsKey(name)) {
            listDellProducts = this.productBasket.get(name);
            this.productBasket.remove(name);
        }
        return listDellProducts;
    }

    private int getSpecialCount() {
        int count = (int) productBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
        return count;
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
