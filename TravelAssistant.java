import java.util.*;

class TravelData {
    static List<Destination> destinations = new ArrayList<>();
    // Add similar lists for hotels, meeting points, transportations, and tour guides if needed

    static void initializeDestinations() {
        destinations.add(new Destination("Paris", 1500.0));
        destinations.add(new Destination("Tokyo", 2000.0));
        destinations.add(new Destination("New York", 1800.0));
        // Add more initial destinations
    }
}

class Destination {
    String name;
    double price;

    Destination(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class CustomerProgram {
    public static void main(String[] args) {
        TravelData.initializeDestinations();
        Scanner scanner = new Scanner(System.in);

        // Get customer information
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your ID number: ");
        String idNumber = scanner.nextLine();
        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        // Display destinations
        List<Destination> destinations = TravelData.destinations;
        System.out.println("Choose a destination:");
        displayOptions(destinations);

        int destinationChoice = scanner.nextInt();
        Destination selectedDestination = destinations.get(destinationChoice - 1);

        // Similar steps for Hotel, MeetingPoint, Transportation, and TourGuide

        // Display choices and prices
        System.out.println("Your selections:");
        System.out.println("Destination: " + selectedDestination.name + " - Price: $" + selectedDestination.price);
        // Display other selections

        double totalPrice = selectedDestination.price /* + other prices */;
        System.out.println("Total Price: $" + totalPrice);

        scanner.close();
    }

    private static void displayOptions(List<?> options) {
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}

class AdminProgram {
    public static void main(String[] args) {
        TravelData.initializeDestinations();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Destination");
            System.out.println("2. Remove Destination");
            System.out.println("3. Show Destinations");
            // Similar options for hotels, meeting points, transportations, and tour guides

            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addDestination(TravelData.destinations, scanner);
                    break;
                case 2:
                    removeDestination(TravelData.destinations, scanner);
                    break;
                case 3:
                    showDestinations(TravelData.destinations);
                    break;
                // Similar cases for hotels, meeting points, transportations, and tour guides
                case 0:
                    System.out.println("Exiting Admin Program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addDestination(List<Destination> destinations, Scanner scanner) {
        System.out.print("Enter destination name: ");
        String name = scanner.next();
        System.out.print("Enter destination price: ");
        double price = scanner.nextDouble();
        destinations.add(new Destination(name, price));
        System.out.println("Destination added successfully.");
    }

    private static void removeDestination(List<Destination> destinations, Scanner scanner) {
        System.out.print("Enter destination number to remove: ");
        int index = scanner.nextInt() - 1;
        if (index >= 0 && index < destinations.size()) {
            destinations.remove(index);
            System.out.println("Destination removed successfully.");
        } else {
            System.out.println("Invalid destination number.");
        }
    }

    private static void showDestinations(List<Destination> destinations) {
        System.out.println("Destinations:");
        for (int i = 0; i < destinations.size(); i++) {
            System.out.println((i + 1) + ". " + destinations.get(i).name + " - Price: $" + destinations.get(i).price);
        }
    }
}
