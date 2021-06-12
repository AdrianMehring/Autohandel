package Autohandel;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[]args){
        ArrayList<Vehicle> vehicles = Vehicle.generateVehicles(30);
        ArrayList<Client> clients = Client.generateRandomClients(2);
        Player Adr = new Player(100000);
        long Winningmoney=Adr.money*21;
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
        System.out.println("12.Suma kosztów  i napraw twojego pojazdu");
        System.out.println("-------------------------------------------");
        int numberofturn =0;
        do {
            int wybor = userInput.nextInt();
            switch (wybor) {
                case 1 -> {
                    System.out.println("----------------BAZA AUT-------------------");
                    System.out.println(vehicles);
                    System.out.println("-------------------------------------------");
                }
                case 2 -> {
                    System.out.println("-------------------------------------------");
                    System.out.println("Podaj numer pojazdu który chcesz kupić od 0 do " + (vehicles.size() - 1));
                    int option = userInput.nextInt();
                    if(option>vehicles.size()-1){
                        System.out.println("Nie ma takiego pojazdu wpisz prawidłowy numer");
                    }
                    else{
                        if(Adr.money < vehicles.get(option).value){

                            System.out.println("Nie stać Cię na auto");
                            System.out.println("Aktualne pieniądze "+Adr.getMoney());
                            System.out.println("Koszt auta "+vehicles.get(option).value);
                            System.out.println("-------------------------------------------");
                        }
                        else{
                            numberofturn++;
                            System.out.println(Adr.buyVehicles(vehicles.get(option), vehicles));
                            System.out.println("Aktualne pieniądze "+Adr.getMoney());
                            System.out.println("Liczba zagranych tur " + numberofturn);
                            System.out.println("-------------------------------------------");
                        }
                    }
                }
                case 3 ->{
                    System.out.println("-------------------------------------------");
                    if(Adr.getVehicles().size()-1==-1){
                        System.out.println("Brak pojazdów");
                    }
                    else{
                        System.out.println("Twoje pojazdy:");
                        System.out.println(Adr.getVehicles());
                    }
                    System.out.println("-------------------------------------------");
                }
                case 4 -> {
                    System.out.println("-------------------------------------------");
                    if(Adr.getVehicles().size()-1==-1){
                        System.out.println("Brak pojazdów do naprawy, najpierw je kup");
                        System.out.println("-------------------------------------------");
                    }
                    else{
                        numberofturn++;
                        System.out.println("Podaj numer pojazdu który chcesz naprawić  od 0 do " + (Adr.getVehicles().size() - 1));
                        int option = userInput.nextInt();
                        if(option>Adr.getVehicles().size()-1){
                            System.out.println("Nie ma takiego pojazdu wpisz prawidłowy numer");
                        }
                        else {
                            if (Adr.money < Adr.vehicles.get(option).value) {
                                System.out.println("Nie stać Cię na mechanika");
                                System.out.println("Najtańszy kosztuje " + Adr.vehicles.get(option).repairCost + " Do naprawy " + Adr.vehicles.get(option).elements);
                                System.out.println("-------------------------------------------");
                            } else {
                                System.out.println(Adr.vehicles.get(option).repair(Adr, Adr.vehicles.get(option)));
                                System.out.println("Aktualne pieniądze " + Adr.getMoney());
                                System.out.println("Liczba zagranych tur" + numberofturn);
                                System.out.println("-------------------------------------------");
                            }
                        }
                    }
                }
                case 5 -> {
                    System.out.println("-------------------------------------------");
                    if(Adr.getClients().size()-1==-1)
                    {
                        System.out.println("Zainwestuj w reklamę");
                        System.out.println("-------------------------------------------");
                    }
                    System.out.println((Adr.getClients()));
                    System.out.println("-------------------------------------------");
                }
                //Zrobić wybrednych klientów
                case 6 -> {
                    System.out.println("-------------------------------------------");
                    if(Adr.getVehicles().size()-1==-1){
                        System.out.println("Aby sprzedać auto, najpierw trzeba je mieć");
                    }
                    else{
                        numberofturn++;
                        System.out.println("Podaj numer pojazdu który chcesz sprzedać od 0 do " + (Adr.getVehicles().size() - 1));
                        int option = userInput.nextInt();
                        if(option>Adr.getVehicles().size()-1){
                            System.out.println("Nie ma takiego pojazdu wpisz prawidłowy numer");
                        }
                        else{
                            System.out.println("Jakiemu klientowi chcesz sprzedać auto");
                            int optionclient = userInput.nextInt();
                            Enum.FavBrand a = clients.get(optionclient).favBrand;
                            Enum.FavBrand a1 = clients.get(optionclient).favBrand1;
                            String b = Adr.vehicles.get(option).brand;

                            Enum.ConditionOfTheCar d = clients.get(optionclient).conditionOfTheCar;
                            Enum.ConditionOfTheCar c = Adr.vehicles.get(option).condition;
                            Enum.ConditionOfTheCar e = Adr.vehicles.get(option).condition = Enum.ConditionOfTheCar.NEW;
                            //klient kupi auto nowe lub jego ulubionej kondycji

                            if( a1.toString()  == b ||a.toString()  == b && d==c ||c == e ){
                                System.out.println("Udało sie");
                                System.out.println("Sprzedałeś auto:"+Adr.vehicles.get(option)+"Klientowi "+clients.get(option));
                                System.out.println((Adr.sellVehicles(Adr.vehicles.get(option), clients.get(option), Adr.vehicles)));
                                System.out.println("Aktualne pieniądze "+Adr.getMoney());
                                System.out.println("Liczba zagranych tur" + numberofturn);
                            }

                            else{
                               System.out.println("Nie udało się");
                                System.out.println("Nie sprzedałeś auta:"+Adr.vehicles.get(option).brand+"Klientowi "+clients.get(option));

                            }
                        }

                        }

                    System.out.println("-------------------------------------------");
                }
                case 7 -> {System.out.println("-------------------------------------------");
                    System.out.println(Adr.getMoney());
                    System.out.println("-------------------------------------------");
                }
                case 8 -> {System.out.println("-------------------------------------------");
                    System.out.println(Adr.getTransactionHistory());
                    System.out.println("-------------------------------------------");
                }
                case 9 -> {System.out.println("-------------------------------------------");
                    System.out.println("Podaj numer pojazdu którego chcesz zobaczyć historię od 0 się zaczynają");
                    int option = userInput.nextInt();
                    if(option>Adr.getVehicles().size()-1){
                        System.out.println("Nie ma takiego pojazdu wpisz prawidłowy numer");
                    }
                    else {

                        if (option > Adr.getVehicles().size() - 1) {
                            System.out.println("Podaj dostępny zakres");
                        } else {
                            System.out.println(Adr.vehicles.get(option).getHistory());
                        }
                    }
                    System.out.println("-------------------------------------------");
                }
                case 10 -> {System.out.println("-------------------------------------------");
                    if(Adr.money<2000){
                        System.out.println("Nie stać Cię na reklamę");
                    }
                    else{
                        numberofturn++;
                        System.out.println(Adr.buyAds(Client.generateClient()));
                        System.out.println("Liczba zagranych tur" + numberofturn);
                        System.out.println("-------------------------------------------");
                    }
                }
                case 11 -> {
                    System.out.println("-------------------------------------------");
                    System.out.println("Liczba zagranych tur " + numberofturn);
                    System.out.println("Do końca pozostało " + (15 - (numberofturn)));
                    System.out.println("-------------------------------------------");
                }
                case 12 ->{
                    System.out.println("-------------------------------------------");
                    if(Adr.getVehicles().size()-1==-1){
                        System.out.println("Brak pojazdów");
                    }
                    else{
                        System.out.println("Podaj numer pojazdu którego chcesz zobaczyć koszty napraw  do " + (Adr.getVehicles().size() - 1));
                        int option = userInput.nextInt();
                        if(option>Adr.getVehicles().size()-1){
                            System.out.println("Podaj dostępny zakres");
                        }
                        else{
                            System.out.println(Vehicle.SumOfRepairs(Adr.vehicles.get(option)));
                            System.out.println(Vehicle.SumOfWash(Adr.vehicles.get(option)));
                        }
                    }
                    System.out.println("-------------------------------------------");
                }
                default -> {
                    System.out.println("-------------------------------------------");
                    System.out.println("Zła cyfra");
                    System.out.println("-------------------------------------------");
                }
            }

            if(Adr.money>=Winningmoney)
            {
                System.out.println("Koniec");
                System.out.println("Wygrałeś zdobyłeś "+Adr.money);
                return;
            }

        }
        while (numberofturn<15);
        System.out.println("Koniec");
        System.out.println("Przegrałeś zdobyłeś "+Adr.money);

    }
}
