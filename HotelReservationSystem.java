import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private String roomNumber;
    private String category; // e.g., "Single", "Double", "Suite"
    private boolean isAvailable;

    public Room(String roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true; // Rooms are available by default
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void reserve() {
        isAvailable = false;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Category: " + category + ", Available: " + isAvailable;
    }
}

class Reservation {
    private String roomNumber;
    private String customerName;

    public Reservation(String roomNumber, String customerName) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Reservation for " + customerName + " in Room " + roomNumber;
    }
}

class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room("101", "Single"));
        rooms.add(new Room("102", "Double"));
        rooms.add(new Room("201", "Suite"));
        rooms.add(new Room("202", "Double"));
        rooms.add(new Room("301", "Single"));
    }

    public List<Room> searchAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public boolean reserveRoom(String roomNumber, String customerName) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber) && room.isAvailable()) {
                room.reserve();
                reservations.add(new Reservation(roomNumber, customerName));
                return true;
            }
        }
        return false;
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Available Rooms:");
                    List<Room> availableRooms = hotel.searchAvailableRooms();
                    if (availableRooms.isEmpty()) {
                        System.out.println("No rooms available.");
                    } else {
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter room number to reserve: ");
                    String roomNumber = scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    if (hotel.reserveRoom(roomNumber, customerName)) {
                        System.out.println("Reservation successful!");
                    } else {
                        System.out.println("Room not available or invalid room number.");
                    }
                    break;

                case 3:
                    hotel.viewReservations();
                    break;

                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}