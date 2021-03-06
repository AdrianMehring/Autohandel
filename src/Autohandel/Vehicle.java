package Autohandel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Vehicle {
    long value;
    final String brand;
    final Integer mileage;
    final String color;
    Enum.ConditionOfTheCar condition;
    Enum.Segment segment;
    Enum.Elements elements;
    long repairCost;
    long sumOfRepairCost;
    long sumOfWash;
    ArrayList<String > History = new ArrayList<>();
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
        this.sumOfRepairCost = 0;
        this.sumOfWash =60;
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
            if(randomVehicles ==2){ //90% ceny normalnej
                value*=0.9;
            }
            switch (randomVehicles) {
                case 0 -> vehicles.add(new Car(value, brand, mileAge, color, segment,condition,elements, (long) repairCost));
                case 1 -> vehicles.add(new Truck(value, brand, mileAge, color, segment,condition,elements,randomSpace, (long) repairCost));
                case 2 -> vehicles.add((new Motorcycle(value,brand,mileAge,color,segment,condition,elements, (long) repairCost)));
            }
        }
    return vehicles;
    }
    public static boolean SumOfRepairs(Vehicle cars) {
        System.out.println("Koszty naprawy pojazdu "+cars.sumOfRepairCost);
        return true;
    }
    public static boolean SumOfWash(Vehicle cars) {
        System.out.println("Koszty umycia pojazdu "+cars.sumOfWash);
        return true;
    }
    public Boolean repair(Player player, Vehicle cars) {
        Scanner Input = new Scanner(System.in);
        int mechanicsnumber;
        System.out.println("Wybierz mechanika:");
        System.out.println("1. Janusz 100% naprawy ale najdrozsze ceny" + cars.repairCost*1.4);
        System.out.println("2. Marian 90% szans naprawy auta"+ cars.repairCost*1.1);
        System.out.println("3.Adrian 80% szansy naprawy auta oraz 2 % szansy na zepsucie czego??"+ cars.repairCost);
        mechanicsnumber = Input.nextInt();
        switch (mechanicsnumber) {
            case 1->{
                History.add("Naprawiony  za "+cars.repairCost+"U janusza"+cars.elements);
                cars.value +=cars.repairCost;
                sumOfRepairCost += cars.repairCost*1.4;
                cars.repairCost= 0;
                cars.elements = null;
                return true;
            }
            case 2->{
                if(ThreadLocalRandom.current().nextInt(0,100)>=10)
                { History.add("Naprawiony  za "+cars.repairCost+"Mariana");
                cars.value +=cars.repairCost;
                sumOfRepairCost += cars.repairCost*1.1;
                cars.repairCost= 0;
                cars.elements = null;
                return true;}
                else{
                    History.add("Popsuty za "+cars.repairCost+"Mariana"+cars.elements);
                    System.out.println("Mechanik nie da?? rady naprawi??, potrzebna interwencja Janusza");
                    return false;
                }
            }
            case 3-> {

                if (ThreadLocalRandom.current().nextInt(0, 100) >= 20) {

                    cars.value += cars.repairCost;
                    sumOfRepairCost += cars.repairCost;
                    History.add("Naprawiony za "+cars.repairCost+"Adriana"+cars.elements);
                    cars.repairCost = 0;
                    cars.elements = null;

                    return true;
                } else if (ThreadLocalRandom.current().nextInt(0, 100) <= 2) {
                    History.add("Popsuty za "+cars.repairCost+"Adriana");
                    sumOfRepairCost += cars.repairCost;
                    System.out.println("Mechanik nie da?? rady naprawi?? i uszkodzi?? kolejn?? cz??????, potrzebna interwencja Janusza ");
                    return false;

                } else {
                    History.add("Popsuty za "+cars.repairCost+"Adriana");
                    sumOfRepairCost += cars.repairCost;
                    System.out.println("Mechanik nie da?? rady naprawi??, potrzebna interwencja Janusza");
                    return false;
                }
            }
            default -> {
                System.out.println("Podaj poprawny numer mechanika");
                return false;
            }
        }
    }
    public ArrayList<String> getHistory(){
        return this.History;
    }
}

