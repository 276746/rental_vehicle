public abstract class Vehicle {
    private String propulsion;
    private String brand;
    private int km;
    private String fuel;
    private String licensePlate;

    public Vehicle(String propulsion, String brand, int km, String fuel, String licensePlate) {
        this.propulsion = propulsion;
        this.brand = brand;
        this.km = km;
        this.fuel = fuel;
        this.licensePlate = licensePlate;
    }

    public abstract void moveFromTo(String start, String end);

    public void refuel() {
        System.out.println("Filling tank with " + getFuel());
    }

    public String getPropulsion() {
        return propulsion;
    }

    public String getBrand() {
        return brand;
    }

    public int getKm() {
        return km;
    }

    public String getFuel() {
        return fuel;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
