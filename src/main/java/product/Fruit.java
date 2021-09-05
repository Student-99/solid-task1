package product;

import myInterface.Product;
import org.jetbrains.annotations.NotNull;

public class Fruit implements Product {
    private String nameProduct;
    private double price;
    private double weight;

    public Fruit(@NotNull String nameProduct, @NotNull double price, double weight) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String getNameProduct() {
        return this.nameProduct;
    }

    @Override
    public double getPrise() {
        return this.price;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Продукт ='" + nameProduct + '\'' +
                ", Цена ₽ =" + price +
                ", Вес кг. =" + weight;
    }
}
