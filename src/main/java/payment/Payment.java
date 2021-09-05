package payment;

import myInterface.IPayment;
import myInterface.IProductBasket;

public class Payment implements IPayment {
    @Override
    public double paymentForProductBasket(IProductBasket productBasket, double cash) {
        double totalCast = productBasket.totalCostOfProducts();
        if (totalCast > cash) {
            System.out.printf("Не хватает денег на оплату, торговой корзины. Общая стоимость корзины %.2f, а вы дали " +
                    "%.2f\n", totalCast, cash);
            return -1;
        }
        double change = cash - totalCast;
        //добавил для прикола
        if (change==1){
            System.out.println("У нас нет сдачи в 1 рубль, возьмите жвачкой)))");
        }
        return change;
    }

}
