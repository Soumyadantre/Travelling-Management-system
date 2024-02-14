import java.util.ArrayList;
import java.util.List;

public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    // Constructors, getters, and setters go here

    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    public boolean addPassenger(Passenger passenger) {
        // Implementation of add passenger logic
    }

    public void printItinerary() {
        // Implementation of print itinerary logic
    }

    public void printPassengerList() {
        // Implementation of print passenger list logic
    }

    public void printPassengerDetails(Passenger passenger) {
        // Implementation of print passenger details logic
    }

    public void printAvailableActivities() {
        // Implementation of print available activities logic
    }
}
