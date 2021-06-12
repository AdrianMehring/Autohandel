package Autohandel;

import java.util.ArrayList;

public class Main {
    public static void main(String[]args){

        ArrayList<Vehicle> vehicles = Vehicle.generateVehicles(3);
        ArrayList<Client> clients = Client.generateClient(7);
        System.out.println(vehicles);
        System.out.println(clients);
        Player Adr = new Player(101000);
        System.out.println(vehicles.get(2));
        System.out.println(vehicles.get(2).value);
        System.out.println(vehicles.get(2).repairCost);
        System.out.println(vehicles.get(2).elements);
        System.out.println(vehicles.get(2).condition);
        System.out.println(vehicles.get(2).repair(Adr,vehicles.get(2)));
        System.out.println(vehicles.get(2).repairCost);
        System.out.println(vehicles.get(2).elements);
        System.out.println(vehicles.get(2).value);



        //Przeglądanie bazy pojazdów
        System.out.println(vehicles);
        System.out.println(Adr.getTransactionHistory());
        System.out.println(Adr.money);
        System.out.println(Adr.getVehicles());
        System.out.println(Adr.buyVehicles(vehicles.get(2), vehicles));
        System.out.println(Adr.getVehicles());
        System.out.println(Adr.money);
        System.out.println(Adr.getTransactionHistory());
        System.out.println(vehicles);
        //znikanie kupoionego pojazdu z bazy działa
    }
}
