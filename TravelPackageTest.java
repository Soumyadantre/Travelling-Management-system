import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TravelPackageTest {

    @Test
    void addDestination() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 5);
        Destination destination = new Destination("Test Destination");

        travelPackage.addDestination(destination);

        assertTrue(travelPackage.getItinerary().contains(destination));
    }

    @Test
    void addPassenger() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 5);
        Passenger passenger = new Passenger("John", 1, "standard", 100);

        assertTrue(travelPackage.addPassenger(passenger));
        assertEquals(1, travelPackage.getPassengers().size());
    }

    @Test
    void printItinerary() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 5);
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 50, 10);
        destination.addActivity(activity);
        travelPackage.addDestination(destination);

        travelPackage.printItinerary();
        // Manual verification of printed output required
    }

    @Test
    void printPassengerList() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 5);
        Passenger passenger = new Passenger("John", 1, "standard", 100);
        travelPackage.addPassenger(passenger);

        travelPackage.printPassengerList();
        // Manual verification of printed output required
    }

    @Test
    void printPassengerDetails() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 5);
        Passenger passenger = new Passenger("John", 1, "standard", 100);
        Activity activity = new Activity("Test Activity", "Description", 50, 10);
        passenger.getActivitiesSignedUp().add(activity);
        travelPackage.addPassenger(passenger);

        travelPackage.printPassengerDetails(passenger);
        // Manual verification of printed output required
    }

    @Test
    void printAvailableActivities() {
        TravelPackage travelPackage = new TravelPackage("Test Package", 5);
        Destination destination = new Destination("Test Destination");
        Activity activity = new Activity("Test Activity", "Description", 50, 10);
        destination.addActivity(activity);
        travelPackage.addDestination(destination);

        travelPackage.printAvailableActivities();
        // Manual verification of printed output required
    }
}

