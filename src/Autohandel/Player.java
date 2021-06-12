package Autohandel;
import java.util.ArrayList;

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
    //kupno pojazdu działa
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


    public Boolean sellVehicles(Vehicle cars,ArrayList<Vehicle> vehicles, Client client){
        double tax = cars.value*0.23;
        double price = cars.value*1.23;//podatek 23 %

        if(client.money>price){
            this.money+=price;
            transactionHistory.add("Sprzedany"+cars+"za"+price);
            System.out.println("Zapłaciłeś"+tax+"Podatku");
            clients.remove(client);
            this.clients.add(client);
            this.clients.add(client);
            return true;
        }

        else{
            System.out.println("Klient nie kupił auta");
            return false;
        }
    }

    //Pobieranie aut działa
    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }
    //Historia transakcji// działa
    public ArrayList<String> getTransactionHistory(){
        return this.transactionHistory;
    }

    //przegląd klientów
    public ArrayList<Client> getClients(){
        return this.clients;
    }




    public  long getMoney()
    {
        return  this.money;
    }



}
