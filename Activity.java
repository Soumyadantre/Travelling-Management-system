public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private int currentParticipants;

    public Activity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.currentParticipants = 0;
    }

    public boolean signUp(Passenger passenger) {
        if (currentParticipants < capacity) {
            double discountedCost = calculateDiscountedCost(passenger);
            if (passenger.deductBalance(discountedCost)) {
                currentParticipants++;
                return true;  // Successful sign-up
            }
        }
        return false;  // Failed sign-up
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return Double.compare(activity.cost, cost) == 0 &&
                capacity == activity.capacity &&
                currentParticipants == activity.currentParticipants &&
                Objects.equals(name, activity.name) &&
                Objects.equals(description, activity.description);
    }
    
    private double calculateDiscountedCost(Passenger passenger) {
        // Apply discount for gold passengers
        if ("gold".equals(passenger.getPassengerType())) {
            return 0.9 * cost;  // 10% discount for gold passengers
        } else {
            return cost;
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, description, cost, capacity, currentParticipants);
    }
}
