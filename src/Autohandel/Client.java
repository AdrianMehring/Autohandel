package Autohandel;

import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;


public class Client {
    String name;
    String surname;
    final Double money;
    Enum.TypeOfCar  favVehicle;
    Enum.FavBrand favBrand;

    public final static String[] NAME={"Andrzej","Adrian","Monika","Mariusz","Piotr","Kacper","Szymon"};
    public final static String[] SURNAME={"Wieczorek","Majewski","Kwiecień","Krupa","Szulc","Lange"};

    public Client(String name,String surname,Double money,Enum.TypeOfCar favVehicle,Enum.FavBrand favBrand) {
        this.name = name;
        this.surname = surname;
        this.money = money;
        this.favVehicle = favVehicle;
        this.favBrand = favBrand;



    }

    public static ArrayList<Client> generateClient(int x){
        ArrayList<Client> clients = new ArrayList<>();
        for(int i = 0;i<x;i++){
            int randomName = ThreadLocalRandom.current().nextInt(0,NAME.length);
            int randomSurname = ThreadLocalRandom.current().nextInt(0,SURNAME.length);
            String name = NAME[randomName];
            String surname = SURNAME[randomSurname];
            int randomfavVehicle = ThreadLocalRandom.current().nextInt(0,Enum.TypeOfCar.values().length);
            int randomfavBrand = ThreadLocalRandom.current().nextInt(0,Enum.FavBrand.values().length);
            Double randomMoneyValue = ThreadLocalRandom.current().nextDouble(5000.0,200000.0);



            Enum.FavBrand favBrand = Enum.FavBrand.values()[randomfavBrand];
            Enum.TypeOfCar favVehicle = Enum.TypeOfCar.values()[randomfavVehicle];
            clients.add(new Client(name,surname,randomMoneyValue,favVehicle,favBrand));


        }
        return clients;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", money=" + money +
                ", favVehicle=" + favVehicle +
                ", favBrand=" + favBrand +
                '}';
    }
}
