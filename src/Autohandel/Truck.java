package Autohandel;

public class Truck extends Vehicle {
    final Integer space;

    public Truck(Double value, String brand, Integer mileage, String color, Enum.Segment segment, Integer space) {
        super(value, brand, mileage, color, segment);
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
                ", segment=" + segment +
                '}';
    }
}

