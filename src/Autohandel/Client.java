package Autohandel;

import java.util.Arrays;

public class Client {
    static Integer FAVOURITE_BRANDS_OF_CLIENT=2; //Ilość ulubionych marek danego klienta
    final Double money;
    final String[] bestBrand;

    public Client(Double money) {
        this.money = money;
        this.bestBrand = new String[FAVOURITE_BRANDS_OF_CLIENT];
    }

    @Override
    public String toString() {
        return "Client{" +
                "money=" + money +
                ", bestBrand=" + Arrays.toString(bestBrand) +
                '}';
    }
}
