package product;

import myInterface.Product;
import org.jetbrains.annotations.NotNull;

public class Water implements Product {

    private String nameProduct;
    private double price;
    private double volume;

    public Water(@NotNull String nameProduct, @NotNull double price, @NotNull double volume) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public String getNameProduct() {
        return this.nameProduct;
    }

    @Override
    public double getPrise() {
        return this.price;
    }

    public double getVolume() {
        return volume;
    }

    @Override
    public String toString() {
        return "Продукт ='" + nameProduct + '\'' +
                ", Цена ₽ =" + price +
                ", объем л. =" + volume;
    }
}
