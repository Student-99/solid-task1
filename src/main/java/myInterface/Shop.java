package myInterface;

import java.util.List;

import myInterface.Product;
import workSchedule.WorkSchedule;

public interface Shop {


    WorkSchedule getWorkSchedule();

    String getName();

    String getSpecification();

    List<Product> getAssortment();

    void showAssortment();

}
