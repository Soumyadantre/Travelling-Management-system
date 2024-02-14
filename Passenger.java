import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Passenger {
    private String name;
    private int passengerNumber;
    private String passengerType;
    private double balance;
    private List<Activity> activitiesSignedUp;

    public Passenger(String name, int passengerNumber, String passengerType, double balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.balance = balance;
        this.activitiesSignedUp = new ArrayList<>();
    }

    public void deductBalance(double amount) {
        if ("standard".equals(passengerType)) {
            balance -= amount;
        } else if ("gold".equals(passengerType)) {
            double discountedAmount = 0.9 * amount; // 10% discount
            balance -= discountedAmount;
        }
        // Premium passengers are not charged
    }

    // Getters and Setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return passengerNumber == passenger.passengerNumber &&
                Double.compare(passenger.balance, balance) == 0 &&
                Objects.equals(name, passenger.name) &&
                Objects.equals(passengerType, passenger.passengerType) &&
                Objects.equals(activitiesSignedUp, passenger.activitiesSignedUp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passengerNumber, passengerType, balance, activitiesSignedUp);
    }
}

