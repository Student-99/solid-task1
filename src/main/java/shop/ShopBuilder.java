package shop;

import java.util.List;

import myInterface.IShopBuilder;
import myInterface.Product;
import myInterface.Shop;
import workSchedule.WorkSchedule;

public class ShopBuilder implements IShopBuilder {
    private WorkSchedule workSchedule;
    private String name;
    private String specification;
    private List<Product> assortments;

    public ShopBuilder setWorkSchedule(WorkSchedule workSchedule) {
        this.workSchedule = workSchedule;
        return this;
    }

    public ShopBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ShopBuilder setSpecification(String specification) {
        this.specification = specification;
        return this;
    }

    public ShopBuilder setAssortments(Product assortment) {
        this.assortments.add(assortment);
        return this;
    }

    @Override
    public Shop build() {
        return new GroceryStore(workSchedule, name, specification, assortments);
    }
}
