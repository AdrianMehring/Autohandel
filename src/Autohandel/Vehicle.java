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
    final long repairCost;

    public final static String[] BRANDS={"Audi","BMW","Mercedes","Fiat","Skoda","Ford"};
    public final static String[] COLORS={"Yellow","Blue","Green","Red","White","Orange"};
    public Vehicle(long value, String brand, Integer mileage, String color, Enum.Segment segment, Enum.ConditionOfTheCar condition, Enum.Elements elements, long repairCost) {
        this.value = value;
        this.brand = brand;
        this.mileage = mileage;
        this.color = color;
        this.segment = segment;
        this.condition = condition;
        this.elements = elements;
        this.repairCost = repairCost;
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
            double repairCost ;
            //Audi,BMW,Mercedes,Fiat,Skoda,Ford

            if(Enum.ConditionOfTheCar.NEW ==condition)
            {
                repairCost = 0;
            }
            else if(Enum.Elements.Gearbox==elements || Enum.Elements.Body==elements){
                repairCost = value*0.5;
            }
            else if(Enum.Elements.Brakes==elements)
            {
                repairCost =  value*0.1;
            }
            else if(Enum.Elements.Suspension==elements)
            {
                repairCost =  value*0.2;
            }
            else{
                repairCost =  value;
            }
            switch (brand) {
                case "BMW", "Audi" -> repairCost *= 1.2;
                case "Mercedes" -> repairCost *= 1.3;
                case "Fiat", "Ford" -> repairCost *= 1.1;
            }



            int randomVehicles = ThreadLocalRandom.current().nextInt(0,Enum.TypeOfCar.values().length);//losowe generowanie typu autka
            switch (randomVehicles) {
                case 0 -> vehicles.add(new Car(value, brand, mileAge, color, segment,condition,elements, (long) repairCost));
                case 1 -> vehicles.add(new Truck(value, brand, mileAge, color, segment,condition,elements,randomSpace, (long) repairCost));
                case 2 -> vehicles.add((new Motorcycle(value,brand,mileAge,color,segment,condition,elements, (long) repairCost)));
            }

        }
    return vehicles;
    }


}
