public abstract class Vehicle implements Servicable {
    protected int id;
    protected static int idGen = 1;
    protected String model;
    protected int year;
    protected double basePrice;

    public Vehicle(String model, int year, double basePrice) {
        this.id = idGen++;
        setModel(model);
        setYear(year);
        setBasePrice(basePrice);
    }

    public void setModel(String model) {
        if (model != null && !model.isEmpty()) this.model = model;
    }

    public void setYear(int year) {
        if (year > 1900 && year <= 2100) this.year = year;
    }

    public void setBasePrice(double basePrice) {
        if (basePrice > 0) this.basePrice = basePrice;
    }

    public int getAge(int currentYear) {
        return currentYear - year;
    }

    public abstract double calculateInsuranceFee();

    @Override
    public String toString() {
        return id + " " + model + " " + year + " " + basePrice;
    }

    public static void main(String[] args) {
        System.out.println("Vehicle class works");
    }
}
