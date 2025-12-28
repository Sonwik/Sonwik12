import java.util.ArrayList;

public class FleetApp {
    public static void main(String[] args) {

        Servicable s = new Car("BMW", 2019, 15000, 4);
        s.performService();

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Audi", 2021, 20000, 4));
        vehicles.add(new Bus("MAN", 2017, 35000, 50));

        for (Vehicle v : vehicles) {
            v.performService();
        }
    }
}
