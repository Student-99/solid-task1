package product;

import myInterface.IProductBuilder;
import myInterface.Product;


public class VegetablesBuilder implements IProductBuilder {
    private String nameProduct;
    private double price;
    private double weight;


    public VegetablesBuilder setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
        return this;
    }


    public VegetablesBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public VegetablesBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public Product build() {
        return new Vegetables(nameProduct, price, weight);
    }
}
