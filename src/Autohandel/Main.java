package Autohandel;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args){

        ArrayList<Vehicle> vehicles = Vehicle.generateVehicles(8);
        ArrayList<Client> clients = Client.generateClient(7);
        System.out.println(vehicles);
        System.out.println(clients);
        Player Adr = new Player(11000);
        System.out.println(vehicles.get(2));
        System.out.println(vehicles.get(2).value);
        System.out.println(vehicles.get(2).repairCost);
        System.out.println(vehicles.get(2).elements);
        System.out.println(vehicles.get(2).condition);
        System.out.println(vehicles.get(2).repair(Adr,vehicles.get(2)));
        System.out.println(vehicles.get(2).repairCost);
        System.out.println(vehicles.get(2).elements);
        System.out.println(vehicles.get(2).value);

    }
}
