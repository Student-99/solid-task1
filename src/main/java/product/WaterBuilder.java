package product;

import myInterface.IProductBuilder;
import myInterface.Product;


public class WaterBuilder implements IProductBuilder {
    private String nameProduct;
    private double price;
    private double volume;


    public WaterBuilder setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
        return this;
    }


    public WaterBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public WaterBuilder setVolume(double volume) {
        this.volume = volume;
        return this;
    }

    public Product build() {
        return new Water(nameProduct, price, volume);
    }
}
