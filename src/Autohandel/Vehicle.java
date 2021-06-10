package Autohandel;

public class Vehicle {
    final Double value;
    final String brand;
    final Integer mileage;
    final String color;
    Enum.Segment segment;

    public Vehicle(Double value, String brand, Integer mileage, String color) {
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
        this.segment = Enum.Segment.budget;//Zrobić losowe pózniej
    }


    @Override
    public String toString() {
        return "Vehicle{" +
                "value=" + value +
                ", brand='" + brand + '\'' +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", segment=" + segment +
                '}';
    }
}
