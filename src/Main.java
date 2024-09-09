import java.util.List;

public class Main {
    public static void main(String[] args) {


        Vehicle bClass = new Car("Engine", "Mercedes", 0, "Diesel", "123456");
        Vehicle f40 = new Car("Engine", "Ferrari", 0, "Gasoline", "000000");
        RentManager.pricingTable.put("Ferrari", 1000);
        RentManager.pricingTable.put("Mercedes", 100);

        RentManager rentManager = new RentManager(List.of(bClass, f40));

        rentManager.rentVehicle("000000", "Duong", 7);
        rentManager.rentVehicle("000000", "Bommer", 10);
        rentManager.rentVehicle("123456", "Dutoit", 4);
    }
}
