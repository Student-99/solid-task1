package product;

import java.util.Date;

import myInterface.IProductBuilder;
import myInterface.Product;


public class FruitBuilder implements IProductBuilder {
    private String nameProduct;
    private double price;
    private double weight;


    public FruitBuilder setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
        return this;
    }


    public FruitBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public FruitBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public Product build() {
        return new Fruit(nameProduct, price, weight);
    }
}
