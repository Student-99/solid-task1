package myInterface;

public interface IProductBasket {
    void addProduct (int position, int count);
    void displayProductInBasket();
    void removeProductFromBasket(int position, int count);
    double totalCostOfProducts ();
}
