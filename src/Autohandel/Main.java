package Autohandel;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args){

        ArrayList<Vehicle> vehicles = Vehicle.generateVehicles(8);
        ArrayList<Client> clients = Client.generateClient(7);
        System.out.println(vehicles);
        System.out.println(clients);

    }
}
