package Autohandel;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[]args){

        ArrayList<Vehicle> vehicles = Vehicle.generateVehicles(25);
        ArrayList<Client> clients = Client.generateRandomClients(2);
        Player Adr = new Player(101000);
        long Winningmoney=Adr.money;
        Adr.startingClients(clients.get(0),clients);
        Adr.startingClients(clients.get(1),clients);

        System.out.println("Witam w grze tekstowej Autohandel u Janusza");
        System.out.println("-------------------------------------------");
        System.out.println("-----------------MENU----------------------");
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
        System.out.println("11.Sprawdz swoją liczbę tur i ile do konca zostało");
        System.out.println("-------------------------------------------");
        int numberofturn =0;
        do {

            int wybor = userInput.nextInt();


            switch (wybor) {

                case 1 -> System.out.println(vehicles);

                case 2 -> {
                    numberofturn++;
                    System.out.println("Podaj numer pojazdu który chcesz kupić od 0 do " + (vehicles.size() - 1));
                    int option = userInput.nextInt();
                    System.out.println(Adr.buyVehicles(vehicles.get(option), vehicles));
                    System.out.println("Liczba zagranych tur" + numberofturn);
                }
                case 3 -> System.out.println(Adr.getVehicles());
                case 4 -> {
                    numberofturn++;
                    System.out.println("Podaj numer pojazdu który chcesz naprawić od 0 do " + (Adr.getVehicles().size() - 1));
                    int option = userInput.nextInt();
                    System.out.println(Adr.vehicles.get(option).repair(Adr, Adr.vehicles.get(option)));

                    System.out.println("Liczba zagranych tur" + numberofturn);
                }
                case 5 -> System.out.println((Adr.getClients()));

                case 6 -> {
                    numberofturn++;
                    System.out.println("Podaj numer pojazdu który chcesz sprzedać od 0 do " + (Adr.getVehicles().size() - 1));
                    int option = userInput.nextInt();
                    System.out.println((Adr.sellVehicles(Adr.vehicles.get(option), clients.get(option), Adr.vehicles)));
                    System.out.println("Liczba zagranych tur" + numberofturn);

                }
                case 7 -> System.out.println(Adr.getMoney());
                case 8 -> System.out.println(Adr.getTransactionHistory());
                case 9 -> {

                    System.out.println("Podaj numer pojazdu którego chcesz zobaczyć historię od 0 do " + (Adr.getVehicles().size() - 1));
                    int option = userInput.nextInt();
                    System.out.println(Adr.vehicles.get(option).getHistory());
                }
                case 10 -> {
                    numberofturn++;
                    System.out.println(Adr.buyAds(Client.generateClient()));
                    System.out.println("Liczba zagranych tur" + numberofturn);
                }
                case 11 -> {
                    System.out.println("Liczba zagranych tur " + numberofturn);
                    System.out.println("Do końca pozostało " + (15 - (numberofturn)));
                }
                default -> System.out.println("Zła cyfra");
            }
        }

        while (numberofturn<=15);
        if(numberofturn>=0){
            System.out.println("Koniec");
            if(Adr.money>=Winningmoney)
            {
                System.out.println("Wygrałeś zdobyłeś "+Adr.money);
            }
            else{
                System.out.println("Przegrałeś zdobyłeś "+Adr.money);
            }

        }
    }



}
