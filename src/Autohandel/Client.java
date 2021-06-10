package Autohandel;

import java.util.Arrays;

public class Client {
    final Double money;
    Enum.TypeOfCar  favVehicle;
    Enum.FavBrand favBrand;


    public Client(Double money,Enum.TypeOfCar favVehicle,Enum.FavBrand favBrand) {
        this.money = money;
        this.favVehicle = favVehicle;
        this.favBrand = favBrand;

    }

    @Override
    public String toString() {
        return "Client{" +
                "money=" + money +
                ", favVehicle=" + favVehicle +
                ", favBrand=" + favBrand +
                '}';
    }
}
