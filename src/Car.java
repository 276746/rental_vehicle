public class Car extends Vehicle {

    public Car(String propulsion, String brand, int km, String fuel, String licencePlate) {
        super(propulsion, brand, km, fuel, licencePlate);
    }

    @Override
    public void moveFromTo(String start, String end) {
        System.out.println("Moving the car from: " + start + " to " + end);
    }
}
