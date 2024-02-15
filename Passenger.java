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
     public boolean signUpForActivity(Activity activity) {
        // Check if the activity has available capacity
        if (activity.getCurrentParticipants() < activity.getCapacity()) {
            // Check if the passenger has sufficient balance
            if ("standard".equalsIgnoreCase(passengerType) && balance >= activity.getCost()) {
                // Deduct the cost from the balance for standard passengers
                deductBalance(activity.getCost());
                // Add the activity to the list of activities signed up by the passenger
                activitiesSignedUp.add(activity);
                // Increment the current participants for the activity
                activity.incrementParticipants();
                return true; // Sign up successful
            } else if ("gold".equalsIgnoreCase(passengerType) && balance >= 0.9 * activity.getCost()) {
                // Deduct the discounted cost from the balance for gold passengers (10% discount)
                deductBalance(0.9 * activity.getCost());
                // Add the activity to the list of activities signed up by the passenger
                activitiesSignedUp.add(activity);
                // Increment the current participants for the activity
                activity.incrementParticipants();
                return true; // Sign up successful
            } else if ("premium".equalsIgnoreCase(passengerType)) {
                // Premium passengers can sign up for activities for free
                // Add the activity to the list of activities signed up by the passenger
                activitiesSignedUp.add(activity);
                // Increment the current participants for the activity
                activity.incrementParticipants();
                return true; // Sign up successful
            }
        }
        return false; // Sign up unsuccessful (either no capacity or insufficient balance)
    }

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

