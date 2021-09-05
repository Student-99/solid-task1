package shop;

import java.util.List;

import myInterface.Product;
import myInterface.Shop;
import workSchedule.WorkSchedule;

public class GroceryStore implements Shop {
    private WorkSchedule workSchedule;
    private String name;
    private String specification;
    private List<Product> assortments;

    public GroceryStore(WorkSchedule workSchedule, String name, String specification, List<Product> assortments) {
        this.workSchedule = workSchedule;
        this.name = name;
        this.specification = specification;
        this.assortments = assortments;
    }

    @Override
    public WorkSchedule getWorkSchedule() {
        return this.workSchedule;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSpecification() {
        return this.specification;
    }

    @Override
    public List<Product> getAssortment() {
        return assortments;
    }

    @Override
    public void showAssortment() {
        System.out.println("Каталог продуктов магазина");
        for (int i = 0; i < assortments.size(); i++) {
            System.out.println(i + 1 + " " + assortments.get(i));
        }
    }
}
