package Autohandel;

public class Motorcycle extends Vehicle {
    public Motorcycle(long value, String brand, Integer mileage, String color, Enum.Segment segment, Enum.ConditionOfTheCar condition, Enum.Elements elements,long repairCost) {
        super(value, brand, mileage, color, segment, condition, elements, repairCost);
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
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
