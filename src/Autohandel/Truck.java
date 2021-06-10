package Autohandel;

public class Truck extends Vehicle {
    final Integer space;

    public Truck(Double value, String brand, Integer mileage, String color,Integer space) {
        super(value, brand, mileage, color);
        this.space = space;
    }
}

