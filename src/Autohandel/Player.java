package Autohandel;
import java.util.ArrayList;
public class Player {
    final Double money;
    ArrayList<Car> Cars = new ArrayList<>(); //lista autek


    public Player(Double money) {
        this.money = money;
    }
}
