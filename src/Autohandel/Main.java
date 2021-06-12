package Autohandel;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[]args){

        ArrayList<Vehicle> vehicles = Vehicle.generateVehicles(3);
        ArrayList<Client> clients = Client.generateClient(7);
        //System.out.println(vehicles);
        //System.out.println(clients);
        Player Adr = new Player(101000);
        System.out.println((Adr.startingClients(clients.get(1),clients)));
        System.out.println((Adr.startingClients(clients.get(2),clients)));

        //Przeglądanie bazy pojazdów

        Scanner userInput = new Scanner(System.in);
        System.out.println("1.Przeglądaj pojazdy");
        System.out.println("2.Kup samochód");
        System.out.println("3.Przejrzyj posiadane pojazdy");
        System.out.println("4.Napraw posiadane auto");
        System.out.println("5.Przejrzyj klientów");
        System.out.println("6.Sprzedaj samochód ");
        System.out.println("7.Sprawdz stan konta");
        System.out.println("8.Sprawdz historię transakcji");
        System.out.println("9.Sprawdz historię napraw pojazdu");
        System.out.println("10.Kup reklame");
        int numberofturn =0;
        do {

            int wybor = userInput.nextInt();
            numberofturn++;

            switch (wybor){
                //userInput.nextInt tu zrobić
                case 1 ->   System.out.println(vehicles);
                case 2 ->   System.out.println(Adr.buyVehicles(vehicles.get(0), vehicles));
                case 3 ->   System.out.println(Adr.getVehicles());
                case 4 ->   System.out.println(vehicles.get(0).repair(Adr,vehicles.get(0)));
                case 5 ->   System.out.println((Adr.getClients()));
                case 6 ->   System.out.println((Adr.sellVehicles(vehicles.get(0),vehicles, clients.get(0))));
                case 7 ->   System.out.println(Adr.getMoney());
                case 8 ->   System.out.println(Adr.getTransactionHistory());
                case 9 ->   System.out.println(vehicles.get(0).getHistory());
                case 10->   System.out.println(Adr.buyAds(clients.get(4)));
                default ->  System.out.println("Zła cyfra");
            }
        }
        while (numberofturn<=10);

    }
}
