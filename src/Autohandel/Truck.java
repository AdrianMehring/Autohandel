package Autohandel;

public class Truck extends Vehicle {
    final Integer space;

    public Truck(long value, String brand, Integer mileage, String color, Enum.Segment segment, Enum.ConditionOfTheCar condition, Integer space) {
        super(value, brand, mileage, color, segment, condition);
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
                '}';
    }
}

