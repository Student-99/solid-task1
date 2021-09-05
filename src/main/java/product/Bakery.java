package product;

import java.text.SimpleDateFormat;
import java.util.Date;

import myInterface.Product;
import org.jetbrains.annotations.NotNull;

public class Bakery implements Product {
    private String nameProduct;
    private double price;
    private Date expirationDate;

    public Bakery(@NotNull String nameProduct, @NotNull double price, Date expirationDate) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.expirationDate = expirationDate;
    }

    @Override
    public String getNameProduct() {
        return this.nameProduct;
    }

    @Override
    public double getPrise() {
        return this.price;
    }

    public String getExpirationDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(expirationDate);
    }

    @Override
    public String toString() {
        return "Продукт ='" + nameProduct + '\'' +
                        ", Цена ₽ =" + price +
                        ", Годен до =" + getExpirationDate();
    }
}
