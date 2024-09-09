public interface Rentable {
    boolean isRentable();
    void rentIt() throws RentManager.RentException;
    boolean isReturnable();
    void returnIt() throws RentManager.RentException;
}
