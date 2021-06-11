package Autohandel;

public class Car extends Vehicle {

    public Car(long value, String brand, Integer mileage, String color, Enum.Segment segment, Enum.ConditionOfTheCar condition, Enum.Elements elements,long repairCost) {
        super(value, brand, mileage, color, segment, condition, elements, repairCost);
    }


    @Override
    public String toString() {
        return "Car{" +
                "value=" + value +
                ", brand='" + brand + '\'' +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", condition=" + condition +
                ", segment=" + segment +
                ", elements=" + elements +
                ", repairCost=" + repairCost +
                '}';
    }
}
