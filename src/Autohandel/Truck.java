package Autohandel;

public class Truck extends Vehicle {
    final Integer space;

    public Truck(long value, String brand, Integer mileage, String color, Enum.Segment segment, Enum.ConditionOfTheCar condition, Enum.Elements elements, Integer space,long repairCost) {
        super(value, brand, mileage, color, segment, condition, elements, repairCost);
        this.space = space;
    }


    @Override
    public String toString() {
        return "Truck{" +
                "space=" + space +
                ", value=" + value +
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

