package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.searchEngine.SearchEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ap {
    public static void main(String[] args) {

        Product table = new SimpleProduct("Стол", 15000);
        Product chair = new SimpleProduct("Стулллллллллллл", 7000);
        Product tv = new SimpleProduct("телевизор 2025", 75000);
        Product phone = new DiscountedProduct("телефон", 90000, 30);
        Product sofa = new DiscountedProduct("диван", 49000, 25);
        Product lamp = new FixPriceProduct("светильник");
        Product soundbar = new DiscountedProduct("колонка", -17000, 15);
        Product bed = new SimpleProduct(" ", 34000);
        Product test = new SimpleProduct("ст стстстстстстстстсст", 200);



        // объект корзина
        ProductBasket basket = new ProductBasket();

        //добавляем в корзину продукты
        basket.addProduct(table);
        basket.addProduct(lamp);
        basket.addProduct(tv);
        basket.addProduct(sofa);
        basket.addProduct(chair);
        basket.addProduct(tv);
        basket.addProduct(tv);
        System.out.println();

        basket.printBasket();

        // поиск продукта в корзине
        if (basket.findProduct(table.getNameProduct())) {
            System.out.println("Продукт есть в корзине");
        } else {
            System.out.println("Продукта нет в корзине");
        }
        System.out.println();

        //удаление продукта по имени из корзины
        List<Product> listDellProducts = new ArrayList<>();
        listDellProducts = basket.dellProduct("телевизор 2025");
        if (listDellProducts.isEmpty()){
            System.out.println("Список пуст!");
        } else {
            System.out.println(listDellProducts);
        }
        System.out.println();
        //удаление несуществующего продукта по имени из корзины
        listDellProducts = basket.dellProduct("машина");
        if (listDellProducts.isEmpty()){
            System.out.println("Список пуст!");
        } else {
            System.out.println(listDellProducts);
        }
        System.out.println();

        basket.cleanBasket();
        basket.printBasket();
        System.out.println();

        // Реализация поиска
        SearchEngine searchEngine = new SearchEngine();

        //Создание объектов статей
        Article weather = new Article("Погода март 2025 ", " Погода в этом году в марте как в мае!");
        Article set = new Article(" Комплект мебели со стулом", " Комплектом покупать всегда выгоднее: стол + стул + диван");

        //Добавляем в объекты в массив
        searchEngine.addSerch(table);
        searchEngine.addSerch(chair);
        searchEngine.addSerch(tv);
        searchEngine.addSerch(phone);
        searchEngine.addSerch(sofa);
        searchEngine.addSerch(test);
        searchEngine.addSerch(lamp);
        searchEngine.addSerch(weather);
        searchEngine.addSerch(set);


        // Тестирование
        System.out.println("Результаты поиска 1:");
        List<String> s = new ArrayList<>();
        s = searchEngine.search("свет");
        System.out.println(s);

        System.out.println();
        System.out.println("Результаты поиска 2: ");
        System.out.println(searchEngine.search("2025"));

        System.out.println();
        System.out.println("Результаты поиска 3: ");
        System.out.println(searchEngine.search("л"));

        System.out.println();
        System.out.println("Результаты поиска 4: ");
        System.out.println(searchEngine.search("мае"));

        System.out.println();
        System.out.println("Результаты поиска 5: ");
        System.out.println(searchEngine.search("теле"));

        String stringFind = "ст";
        System.out.println();
        System.out.println("Результаты поиска повторов строки: ");
        System.out.println(searchEngine.findSearchMaxRepeat(stringFind));

        stringFind = "е";
        System.out.println();
        System.out.println(searchEngine.findSearchMaxRepeat(stringFind));
        stringFind = "стdc";
        System.out.println();
        System.out.println(searchEngine.findSearchMaxRepeat(stringFind));
        stringFind = "л";
        System.out.println();
        System.out.println(searchEngine.findSearchMaxRepeat(stringFind));
        stringFind = "23423а23";
        System.out.println();
        System.out.println(searchEngine.findSearchMaxRepeat(stringFind));
    }

}