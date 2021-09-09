import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import basket.ProductBasket;
import myInterface.IPayment;
import myInterface.IProductBasket;
import myInterface.Product;
import myInterface.Shop;
import org.apache.commons.lang.time.DateUtils;
import payment.Payment;
import product.BakeryBuilder;
import product.FruitBuilder;
import product.VegetablesBuilder;
import product.WaterBuilder;
import shop.ShopBuilder;
import workSchedule.WorkSchedule;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        WorkSchedule workSchedule = new WorkSchedule()
                .setWorkScheduleInDayOfWeek(1, "с 9:00 до 21:00")
                .setWorkScheduleInDayOfWeek(2, "с 9:00 до 21:00")
                .setWorkScheduleInDayOfWeek(3, "с 9:00 до 00:00");

        Product breads = new BakeryBuilder()
                .setNameProduct("Батон")
                .setPrice(15)
                .setExpirationDate(DateUtils.addDays(new Date(), 1))
                .build();

        Product oranges = new FruitBuilder()
                .setNameProduct("Апельсины")
                .setPrice(150)
                .setWeight(2)
                .build();

        Product cucumbers = new VegetablesBuilder()
                .setNameProduct("Огурцы")
                .setPrice(100)
                .setWeight(5)
                .build();

        Product cocaCola = new WaterBuilder()
                .setNameProduct("CocaCola")
                .setPrice(60)
                .setVolume(0.5)
                .build();

        Shop kuzya = new ShopBuilder()
                .setName("Кузя")
                .setSpecification("Продуктовый")
                .setWorkSchedule(workSchedule)
                .setAssortments(breads)
                .setAssortments(oranges)
                .setAssortments(cucumbers)
                .setAssortments(cocaCola)
                .build();


        IProductBasket productBasket = new ProductBasket(kuzya.getAssortment());
        IPayment payment = new Payment();

        kuzya.showAssortment();

        do {
            System.out.println("Для того чтоб добавить товар в корзину, введите номер товара и его количество. для " +
                    "окончания наполнения корзины введите 'end'");
            String s = scanner.nextLine();
            if (s.equals("end")) {
                break;
            } else {
                String[] productAndCount = s.split(" ");
                int product = Integer.parseInt(productAndCount[0]) - 1;
                int count = Integer.parseInt(productAndCount[1]);
                productBasket.addProduct(product, count);
            }
        } while (true);

        productBasket.displayProductInBasket();

        System.out.printf("К оплате %.2f₽\n", productBasket.totalCostOfProducts());

        int cash;
        double change;
        do {
            String req;
            do {
                System.out.print("Будете что нить убирать из корзины? yes/no ");
                req = scanner.nextLine();
                if (req.equals("yes")) {
                    System.out.println("Введите удаляемую позицию и ее количество: ");
                    String s = scanner.nextLine();
                    String[] productAndCount = s.split(" ");
                    int product = Integer.parseInt(productAndCount[0])-1;
                    int count = Integer.parseInt(productAndCount[1]);
                    productBasket.removeProductFromBasket(product, count);
                    System.out.printf("К оплате %.2f₽\n", productBasket.totalCostOfProducts());
                }
            } while (req.equals("yes"));
            System.out.print("Передать на оплату: ");
            cash = Integer.parseInt(scanner.nextLine());
            change = payment.paymentForProductBasket(productBasket, cash);

        } while (change == -1);

        System.out.printf("Ваша сдача %.2f\n",change);
    }

}
