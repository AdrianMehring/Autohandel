package Autohandel;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args){

        //Vehicle Audi = new Vehicle(2000.0,"Audi",150000,"Black",Enum.Segment.budget);
        //Client Adrian = new Client(20.0,Enum.TypeOfCar.Car,Enum.FavBrand.Audi);
        //System.out.println(Audi);
        //System.out.println(Adrian);
        ArrayList<Vehicle> vehicles = Vehicle.generateVehicles(4);
        System.out.println(vehicles);

    }
}
