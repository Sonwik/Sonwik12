public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String model, int year, double basePrice, int numberOfDoors) {
        super(model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public double calculateInsuranceFee() {
        return basePrice * 0.05;
    }

    @Override
    public void performService() {
        System.out.println("Car service performed");
    }

    @Override
    public int getServiceIntervalKm() {
        return 10000;
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", 2020, 10000, 4);
        System.out.println(car);
        car.performService();
    }
}
