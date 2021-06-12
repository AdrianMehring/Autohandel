package Autohandel;

import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;


public class Client {
    String name;
    String surname;
    final long money;
    Enum.TypeOfCar  favVehicle;
    Enum.FavBrand favBrand;
    Enum.FavBrand favBrand1;
    Enum.ConditionOfTheCar conditionOfTheCar;
    Integer minimumSpace;
    public final static String[] NAME={"Andrzej","Adrian","Monika","Mariusz","Piotr","Kacper","Szymon"};
    public final static String[] SURNAME={"Wieczorek","Majewski","Kwiecień","Krupa","Szulc","Lange"};
    public Client(String name,String surname,long money,Enum.TypeOfCar favVehicle,Enum.FavBrand favBrand,Enum.FavBrand favBrand1,Enum.ConditionOfTheCar conditionOfTheCar,Integer minimumSpace) {
        this.name = name;
        this.surname = surname;
        this.money = money;
        this.favVehicle = favVehicle;
        this.favBrand = favBrand;
        this.favBrand1 = favBrand1;
        this.conditionOfTheCar = conditionOfTheCar;
        this.minimumSpace = minimumSpace;
    }
    public static ArrayList<Client> generateRandomClients(int x) {
        ArrayList<Client> clients = new ArrayList<>();
        for(int i = 0; i < x; i++) {
            clients.add(generateClient());
        }
        return clients;
    }
    public static Client generateClient(){
            int randomName = ThreadLocalRandom.current().nextInt(0,NAME.length);
            int randomSurname = ThreadLocalRandom.current().nextInt(0,SURNAME.length);
            String name = NAME[randomName];
            String surname = SURNAME[randomSurname];
            int randomfavVehicle = ThreadLocalRandom.current().nextInt(0,Enum.TypeOfCar.values().length);
            int randomfavBrand;
            int randomfavBrand1;
            do{
                randomfavBrand = ThreadLocalRandom.current().nextInt(0,Enum.FavBrand.values().length);
                randomfavBrand1 = ThreadLocalRandom.current().nextInt(0,Enum.FavBrand.values().length);
            }
            while (randomfavBrand == randomfavBrand1);
            //losowa kondycja auta
            int random = ThreadLocalRandom.current().nextInt(0,100);
            Enum.ConditionOfTheCar condition;

            if(random<15) {
                condition = Enum.ConditionOfTheCar.Broken;
            }
            else if(random<40) {
                condition = Enum.ConditionOfTheCar.Faulty_suspension;
            }
            else {
                condition = Enum.ConditionOfTheCar.NEW;
            }
            double randomMoney = ThreadLocalRandom.current().nextDouble(5000.0,200000.0);
            long randomMoneyValue =Math.round(randomMoney);
            Enum.FavBrand favBrand1 = Enum.FavBrand.values()[randomfavBrand1];
            Enum.FavBrand favBrand = Enum.FavBrand.values()[randomfavBrand];
            Enum.TypeOfCar favVehicle = Enum.TypeOfCar.values()[randomfavVehicle];
            Integer minimumSpace;
            if(favVehicle == Enum.TypeOfCar.Truck)
            {
                minimumSpace = ThreadLocalRandom.current().nextInt(500,2001);
            }
            else
            {
                minimumSpace = null;
            }
            return new Client(name,surname,randomMoneyValue,favVehicle,favBrand,favBrand1,condition,minimumSpace);
    }
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", money=" + money +
                ", favVehicle=" + favVehicle +
                ", favBrand=" + favBrand +
                ", favBrand1=" + favBrand1 +
                ", conditionOfTheCar=" + conditionOfTheCar +
                ", minimumSpace=" + minimumSpace +
                '}';
    }
}
