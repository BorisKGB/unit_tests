package ru.study.seminar1.Shop;

import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    // (?) Может тут необходима только сортировка без возврата чего-либо?
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        if (products != null)
            products.sort(Comparator.comparing(Product::getCost));
        return products;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        if (products != null)
            return products.stream().max(Comparator.comparing(Product::getCost)).orElse(null);
        return null;
    }
}