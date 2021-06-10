package Autohandel;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Vehicle {
    final Double value;
    final String brand;
    final Integer mileage;
    final String color;
    Enum.Segment segment;

    public final static String[] BRANDS={"Audi","BMW","Mercedes","Fiat","Skoda","Ford"};
    public final static String[] COLORS={"Yellow","Blue","Green","Red","White","Orange"};
    public Vehicle(Double value, String brand, Integer mileage, String color, Enum.Segment segment) {
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
        this.segment = segment;
    }
    public static ArrayList<Vehicle> generateVehicles(int x){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(int i = 0;i<x;i++){
            int randomColor = ThreadLocalRandom.current().nextInt(0,COLORS.length);
            int randomBrands = ThreadLocalRandom.current().nextInt(0,BRANDS.length);
            int mileAge = ThreadLocalRandom.current().nextInt(0,500000);
            int randomSegment = ThreadLocalRandom.current().nextInt(0,Enum.Segment.values().length);
            int randomSpace = ThreadLocalRandom.current().nextInt(500,2000);
            Double value =   ThreadLocalRandom.current().nextDouble(1000.0,20000.0);
            String color = COLORS[randomColor];
            String brand = COLORS[randomBrands];
            Enum.Segment segment = Enum.Segment.values()[randomSegment];
            int randomVehicles = ThreadLocalRandom.current().nextInt(0,Enum.TypeOfCar.values().length);//losowe generowanie typu autka
            switch (randomVehicles) {
                case 0 -> vehicles.add(new Car(value, brand, mileAge, color, segment));
                case 1 -> vehicles.add(new Truck(value, brand, mileAge, color, segment, randomSpace));
            }

        }
    return vehicles;
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
