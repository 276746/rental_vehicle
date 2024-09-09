public class RentVehicle implements Rentable {
    private Vehicle vehicle;
    private boolean isRented;
    private int pricePerDay;

    public RentVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isRented = false;
        this.pricePerDay = RentManager.pricingTable.get(vehicle.getBrand());
    }

    @Override
    public boolean isRentable() {
        return !isRented;
    }

    @Override
    public void rentIt() throws RentManager.RentException {
        if (isRented) throw new RentManager.RentException("The vehicle is already rented");
        isRented = true;
    }

    @Override
    public boolean isReturnable() {
        return false;
    }

    @Override
    public void returnIt() throws RentManager.RentException {
        if (!isRented) throw new RentManager.RentException("The vehicle is not currently rented");
        isRented = false;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public String getLicensePlate() {
        return vehicle.getLicensePlate();
    }
}
