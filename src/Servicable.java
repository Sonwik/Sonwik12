public interface Servicable {
    void performService();
    int getServiceIntervalKm();

    static void main(String[] args) {
        System.out.println("Servicable interface works");
    }
}
