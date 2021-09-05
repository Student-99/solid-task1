package product;

import java.util.Date;

import myInterface.IProductBuilder;
import myInterface.Product;


public class BakeryBuilder implements IProductBuilder {
    private String nameProduct;
    private double price;
    private Date expirationDate;



    public BakeryBuilder setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
        return this;
    }


    public BakeryBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public BakeryBuilder setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
        return this;
    }

    public Product build(){
        return new Bakery( nameProduct,price,expirationDate);
    }
}
