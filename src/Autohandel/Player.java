package Autohandel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class Player {
    long money;
    final long Washing_Price =100;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<String> transactionHistory = new ArrayList<>();
    ArrayList<Client> clients = new ArrayList<>();
    public Player(long money)
    {
        this.money = money;
    }
    public Boolean buyVehicles(Vehicle cars , ArrayList<Vehicle> vehicles)
    {
        double price = cars.value*1.02+Washing_Price;//podatek 2 % i mycie
        if(price>money)
        {
            System.out.println("Nie starczy Ci na auto");
            return false;
        }
        else {
            this.money -=price;
            this.vehicles.add(cars);
            vehicles.remove(cars);
            System.out.println("Jesteś nowym wlascicielem,brawo");
            transactionHistory.add("Zakupiony "+cars +"za"+price);
            return true;
        }
    }
    public Boolean startingClients(Client client, ArrayList<Client> clients)
    {
        this.clients.add(client);
        return true;
    }
    public Boolean sellVehicles(Vehicle cars, Client client,ArrayList<Vehicle> vehicles){
        double tax = cars.value*0.23;
        double price = cars.value*1.23;//podatek 23 %
        if(client.money>price){
            this.money+=price;
            transactionHistory.add("Sprzedany"+cars+"za"+price);
            System.out.println("Zapłaciłeś"+tax+"Podatku");
            vehicles.remove(cars);
            this.clients.remove(client);
            this.clients.add(client);
            this.clients.add(client);
            return true;
        }
        else{
            System.out.println("Klient nie kupił auta");
            return false;
        }
    }
    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }
    public ArrayList<String> getTransactionHistory(){
        return this.transactionHistory;
    }
    public ArrayList<Client> getClients(){
        return this.clients;
    }
    public  long getMoney()
    {
        return  this.money;
    }
    public Boolean buyAds(Client client){
        Scanner Input = new Scanner(System.in);
        int typeofAds;
        System.out.println("Wybierz reklamę:");
        System.out.println("1.Reklama internetowa, tańsza lecz daje tylko 1 klienta");
        System.out.println("2.Reklama w gazecie, daje losową ilość klientów od 1 do 3");
        typeofAds = Input.nextInt();
        switch (typeofAds) {
            case 1 ->{
                double adsPrice = 2000.0;
                this.money -=adsPrice;
                clients.add(Client.generateClient());
                System.out.println("Koszt reklamy"+adsPrice);
                return true;
            }
            case 2 -> {
                int x = ThreadLocalRandom.current().nextInt(1, 3);
                int i = 0;
                double adsPrice = 5000.0;
                this.money -= adsPrice;
                System.out.println("Koszt reklamy" + adsPrice);
                do {
                    clients.add(Client.generateClient());
                    i++;
                }
                while (x > i);
            }
            default -> {
                System.out.println("Podaj poprawny numer ");
                return false;
            }
        }
        return true;
    }
}
