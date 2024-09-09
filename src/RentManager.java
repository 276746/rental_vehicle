import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RentManager {
    public static Map<String, Integer> pricingTable = new HashMap<>();
    private final Set<RentVehicle> rentVehicles;
    private final Map<RentVehicle, String> reservations;
    private final Map <RentVehicle, Integer> rentDays;

    public RentManager(List<Vehicle> vehicles) {
        rentVehicles = new HashSet<>();
        reservations = new HashMap<>();
        rentDays = new HashMap<>();
        vehicles.forEach(vehicle -> rentVehicles.add(new RentVehicle(vehicle)));
    }

    public void rentVehicle(String licensePlate, String renter, int daysToRent) {
        RentVehicle vehicle = findVehicle(licensePlate);
        if (rentVehicles.contains(vehicle)) {
            try {
                vehicle.rentIt();
                reservations.put(vehicle, renter);
                rentDays.put(vehicle, daysToRent);

                updateDB(licensePlate, renter, daysToRent);
            } catch (RentException e) {
                System.out.println(e.message);
            }
        }
    }

    public void returnVehicle(RentVehicle vehicle, String renter) {
        if (reservations.containsKey(vehicle) && reservations.get(vehicle).equals(renter)) {
            try {
                vehicle.returnIt();
            } catch (RentException e) {
                System.out.println(e.message);
            }
            reservations.remove(vehicle);
        }
    }

    public int computePrice(String licensePlate) {
        RentVehicle vehicle = findVehicle(licensePlate);

        return vehicle.getPricePerDay() * rentDays.getOrDefault(vehicle, 0);
    }

    private RentVehicle findVehicle(String licensePlate) {
        return rentVehicles
                .stream()
                .filter(vehicle -> vehicle.getLicensePlate().equals(licensePlate))
                .findFirst().orElse(null);
    }

    private void updateDB(String licensePlate, String renter, int days) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("db.txt", true))) {
            writer
                    .append(licensePlate)
                    .append(" | ")
                    .append(renter)
                    .append(" | ")
                    .append(String.valueOf(days))
                    .append("\n");
        } catch (IOException e) {
            System.out.println("Could not write to file");
        }
    }

    public static class RentException extends Throwable {
        private final String message;

        public RentException(String message) {
            this.message = message;
        }
    }
}
