package basket;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import myInterface.IProductBasket;
import myInterface.Product;


public class ProductBasket implements IProductBasket {
    private Map<Integer, Integer> productsInBasket = new HashMap<>();
    private List<Product> products;

    public ProductBasket(List<Product> assortments) {
        products = assortments;
    }

    @Override
    public void addProduct(int position, int count) {
        int currentCount = 0;
        if (productsInBasket.containsKey(position)) {
            currentCount = productsInBasket.get(position);
        }
        productsInBasket.put(position, currentCount + count);
    }

    @Override
    public void displayProductInBasket() {
        System.out.println(String.format("Всего товаров в корзине: %d\n", productsInBasket.size()));
        System.out.println("Список товаров в корзине:");
        StringBuilder basket = new StringBuilder(
                        "Код продукта Наименование товара   Количество  Цена/за.ед  Общая стоимость\n");
        Iterator<Map.Entry<Integer, Integer>> iterator = productsInBasket.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            String nameProduct = products.get(key).getNameProduct();
            double price = products.get(key).getPrise();
            basket.append(String.format("%-13d%-22s%-12d%-12.2f%-15.2f\n",
                    key+1,
                    nameProduct,
                    entry.getValue(),
                    price,
                    entry.getValue()+price));
        }
        System.out.println(basket);
    }

    @Override
    public void removeProductFromBasket(int position, int count) {
        if (!productsInBasket.containsKey(position)){
            System.out.println("Такой товарной позиции в корзине нет.");
            displayProductInBasket();
            return;
        }
        int currentCount = productsInBasket.get(position);
        if (currentCount < count) {
            System.out.println(String.format("В корзине товара меньше чем вы хотите убрать."));
            displayProductInBasket();
            return;
        }
        currentCount -= count;
        if (currentCount != 0) {
            productsInBasket.put(position, currentCount);
            System.out.println(String.format("Из корзины было убрано %d товара %s", count,
                    products.get(position).getNameProduct()));
            displayProductInBasket();
            return;
        }
        productsInBasket.remove(position);
        System.out.println(String.format("Из корзины был полностью убран товар %s",
                products.get(position).getNameProduct()));
        displayProductInBasket();
    }

    @Override
    public double totalCostOfProducts() {
        double totalCostOfProducts = 0;

        Iterator<Map.Entry<Integer, Integer>> iterator = productsInBasket.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            int count = entry.getValue();
            totalCostOfProducts += count * products.get(key).getPrise();
        }
        return totalCostOfProducts;
    }
}
