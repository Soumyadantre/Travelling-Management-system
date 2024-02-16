import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
            return true;
        } else {
            return false;
        }
    }

    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        System.out.println("Itinerary:");
        for (Destination destination : itinerary) {
            System.out.println("- " + destination.getName());
            for (Activity activity : destination.getActivities()) {
                System.out.println("  - " + activity.getName() +
                        ": " + activity.getCurrentParticipants() + "/" + activity.getCapacity() + " participants");
            }
        }
    }

    public void printPassengerList() {
        System.out.println("Passenger List:");
        System.out.println("- Package Name: " + name);
        System.out.println("- Passenger Capacity: " + passengerCapacity);
        System.out.println("- Number of Passengers Enrolled: " + passengers.size());
        System.out.println("- Passengers:");
        for (Passenger passenger : passengers) {
            System.out.println("  - Name: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
        }
    }

    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Passenger Details:");
        System.out.println("- Name: " + passenger.getName());
        System.out.println("- Number: " + passenger.getPassengerNumber());
        System.out.println("- Balance: " + passenger.getBalance());
        System.out.println("- Activities Signed Up:");

        for (Activity activity : passenger.getActivitiesSignedUp()) {
            System.out.println("  - Activity: " + activity.getName() +
                    ", Destination: " + findDestinationByActivity(activity).getName() +
                    ", Price: " + activity.getCost());
        }
    }
    public List<Passenger> getPassengers() {
        return passengers;  // assuming passengers is a private List<Passenger> field
    }
    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                int availableSpaces = activity.getCapacity() - activity.getCurrentParticipants();
                System.out.println("- Activity: " + activity.getName() +
                        ", Destination: " + destination.getName() +
                        ", Available Spaces: " + availableSpaces);
            }
        }
    }

    private Destination findDestinationByActivity(Activity activity) {
        for (Destination destination : itinerary) {
            if (destination.getActivities().contains(activity)) {
                return destination;
            }
        }
        return null;
    }

    // Getters and Setters
    public List<Destination> getItinerary() {
        return itinerary;  // assuming itinerary is a private List<Destination> field
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelPackage that = (TravelPackage) o;
        return passengerCapacity == that.passengerCapacity &&
                Objects.equals(name, that.name) &&
                Objects.equals(itinerary, that.itinerary) &&
                Objects.equals(passengers, that.passengers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passengerCapacity, itinerary, passengers);
    }
}

