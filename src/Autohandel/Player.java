package Autohandel;
import java.util.ArrayList;
import java.util.Scanner;
public class Player {
    long money;
    final long Washing_Price =100;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<String> transactionHistory = new ArrayList<>();
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


    //Pobieranie aut działa
    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }
    //Historia transakcji// działa
    public ArrayList<String> getTransactionHistory(){
        return this.transactionHistory;
    }





}
