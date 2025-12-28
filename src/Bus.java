public class Bus extends Vehicle {
    private int passengerCapacity;

    public Bus(String model, int year, double basePrice, int passengerCapacity) {
        super(model, year, basePrice);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public double calculateInsuranceFee() {
        return basePrice * 0.08;
    }

    @Override
    public void performService() {
        System.out.println("Bus service performed");
    }

    @Override
    public int getServiceIntervalKm() {
        return 20000;
    }

    public static void main(String[] args) {
        Bus bus = new Bus("Volvo", 2018, 30000, 40);
        System.out.println(bus);
        bus.performService();
    }
}
