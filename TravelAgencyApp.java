import java.util.Scanner;

public class TravelAgencyApp {
    private static TravelPackage travelPackage;

    public static void main(String[] args) {
        travelPackage = createSampleTravelPackage(); // Create a sample travel package

        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    travelPackage.printItinerary();
                    break;
                case 2:
                    travelPackage.printPassengerList();
                    break;
                case 3:
                    signUpForActivity(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========== Travel Agency Application ==========");
        System.out.println("1. View Itinerary");
        System.out.println("2. View Passenger List");
        System.out.println("3. Sign Up for Activity");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void signUpForActivity(Scanner scanner) {
        System.out.print("Enter passenger number: ");
        int passengerNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Passenger passenger = findPassengerByNumber(passengerNum);

        if (passenger != null) {
            travelPackage.printAvailableActivities();
            System.out.print("Enter activity name to sign up: ");
            String activityName = scanner.nextLine();

            // Find the destination and activity
            Activity activity = findActivityByName(activityName);

            if (activity != null) {
                boolean success = passenger.signUpForActivity(activity);
                if (success) {
                    System.out.println("Signed up successfully!");
                } else {
                    System.out.println("Failed to sign up. Activity may be full or invalid.");
                }
            } else {
                System.out.println("Invalid activity name.");
            }
        } else {
            System.out.println("Passenger not found.");
        }
    }

    private static Passenger findPassengerByNumber(int passengerNum) {
        for (Passenger passenger : travelPackage.getPassengers()) {
            if (passenger.getPassengerNum() == passengerNum) {
                return passenger;
            }
        }
        return null;
    }

    private static Activity findActivityByName(String activityName) {
        for (Destination destination : travelPackage.getItinerary()) {
            for (Activity activity : destination.getActivities()) {
                if (activity.getName().equalsIgnoreCase(activityName)) {
                    return activity;
                }
            }
        }
        return null;
    }

    private static TravelPackage createSampleTravelPackage() {
    TravelPackage travelPackage = new TravelPackage();
    travelPackage.setName("Adventure Package");
    travelPackage.setCapacity(50);

    // Create destinations
    Destination destination1 = new Destination();
    destination1.setName("Beach Paradise");

    Destination destination2 = new Destination();
    destination2.setName("Mountain Retreat");

    // Create activities
    Activity activity1 = new Activity();
    activity1.setName("Snorkeling");
    activity1.setDescription("Explore underwater life");
    activity1.setCost(50.0);
    activity1.setCapacity(20);

    Activity activity2 = new Activity();
    activity2.setName("Hiking");
    activity2.setDescription("Enjoy scenic mountain trails");
    activity2.setCost(30.0);
    activity2.setCapacity(30);

    // Add activities to destinations
    destination1.addActivity(activity1);
    destination2.addActivity(activity2);

    // Add destinations to travel package
    travelPackage.addDestination(destination1);
    travelPackage.addDestination(destination2);

    // Create passengers
    Passenger passenger1 = new Passenger();
    passenger1.setName("John Doe");
    passenger1.setPassengerNum(1);
    passenger1.setBalance(100.0);

    Passenger passenger2 = new Passenger();
    passenger2.setName("Jane Smith");
    passenger2.setPassengerNum(2);
    passenger2.setBalance(150.0);

    // Add passengers to travel package
    travelPackage.addPassenger(passenger1);
    travelPackage.addPassenger(passenger2);

    return travelPackage;
}

}
