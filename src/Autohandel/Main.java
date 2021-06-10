package Autohandel;

public class Main {
    public static void main(String[]args){
        System.out.println("XD");

        Vehicle Audi = new Vehicle(2000.0,"Audi",150000,"Black");
        Client Adrian = new Client(20.0,Enum.TypeOfCar.Car,Enum.FavBrand.Audi);
        System.out.println(Audi);
        System.out.println(Adrian);

    }
}
