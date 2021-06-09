package Autohandel;

public class Car {
    final Double value;
    final String brand;
    final Integer mileage;
    final String color;
    //segment ?

    public Car(Double value, String brand, Integer mileage, String color) {
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "value=" + value +
                ", brand='" + brand + '\'' +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                '}';
    }
}
