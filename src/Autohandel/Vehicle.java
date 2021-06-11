package Autohandel;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
public class Vehicle {
    final long value;
    final String brand;
    final Integer mileage;
    final String color;
    Enum.ConditionOfTheCar condition;
    Enum.Segment segment;
    Enum.Elements elements;

    public final static String[] BRANDS={"Audi","BMW","Mercedes","Fiat","Skoda","Ford"};
    public final static String[] COLORS={"Yellow","Blue","Green","Red","White","Orange"};
    public Vehicle(long value, String brand, Integer mileage, String color, Enum.Segment segment,Enum.ConditionOfTheCar condition,Enum.Elements elements) {
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
        this.segment = segment;
        this.condition = condition;
        this.elements = elements;
    }

    public static ArrayList<Vehicle> generateVehicles(int x){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        for(int i = 0;i<x;i++){
            int randomColor = ThreadLocalRandom.current().nextInt(0,COLORS.length);
            int randomBrands = ThreadLocalRandom.current().nextInt(0,BRANDS.length);
            int mileAge = ThreadLocalRandom.current().nextInt(0,500000);
            int randomSegment = ThreadLocalRandom.current().nextInt(0,Enum.Segment.values().length);
            int randomSpace = ThreadLocalRandom.current().nextInt(500,2000);
            int randomCondition = ThreadLocalRandom.current().nextInt(0,Enum.ConditionOfTheCar.values().length);
            Enum.ConditionOfTheCar condition = Enum.ConditionOfTheCar.values()[randomCondition];
            double value1 =   ThreadLocalRandom.current().nextDouble(1000.0,20000.0);
            long value =Math.round(value1);
            String color = COLORS[randomColor];
            String brand = BRANDS[randomBrands];
            Enum.Segment segment = Enum.Segment.values()[randomSegment];
            int randomElements = ThreadLocalRandom.current().nextInt(0,Enum.Elements.values().length);
            Enum.Elements elements = Enum.Elements.values()[randomElements];
            if(Enum.ConditionOfTheCar.NEW==condition){
                elements=null;
            }
            int randomVehicles = ThreadLocalRandom.current().nextInt(0,Enum.TypeOfCar.values().length);//losowe generowanie typu autka
            switch (randomVehicles) {
                case 0 -> vehicles.add(new Car(value, brand, mileAge, color, segment,condition,elements));
                case 1 -> vehicles.add(new Truck(value, brand, mileAge, color, segment,condition,elements,randomSpace));
                case 2 -> vehicles.add((new Motorcycle(value,brand,mileAge,color,segment,condition,elements)));
            }

        }
    return vehicles;
    }

}
