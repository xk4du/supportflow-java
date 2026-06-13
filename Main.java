import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Ticket> tickets = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int nextId = 1;

    public static void main(String[] args) {
        int option;

        do {
            showMainMenu();
            option = readInt();

            switch (option) {
                case 1:
                    userArea();
                    break;
                case 2:
                    supportArea();
                    break;
                case 0:
                    System.out.println("Closing SupportFlow...");
                    System.out.println("Project developed by David Poltergatt.");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

    public static void showMainMenu() {
        System.out.println("\n=== SUPPORTFLOW ===");
        System.out.println("1 - User area");
        System.out.println("2 - Support area");
        System.out.println("0 - Exit");
        System.out.print("Choose an option: ");
    }

    public static void userArea() {
        int option;

        do {
            System.out.println("\n=== USER AREA ===");
            System.out.println("1 - Open a ticket");
            System.out.println("2 - View my tickets");
            System.out.println("3 - View support response");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");

            option = readInt();

            switch (option) {
                case 1:
                    openTicket();
                    break;
                case 2:
                    viewUserTickets();
                    break;
                case 3:
                    viewSupportResponse();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

    public static void supportArea() {
        int option;

        do {
            System.out.println("\n=== SUPPORT AREA ===");
            System.out.println("1 - List all tickets");
            System.out.println("2 - Answer a ticket");
            System.out.println("3 - Change ticket status");
            System.out.println("4 - Close a ticket");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");

            option = readInt();

            switch (option) {
                case 1:
                    listAllTickets();
                    break;
                case 2:
                    answerTicket();
                    break;
                case 3:
                    changeTicketStatus();
                    break;
                case 4:
                    closeTicket();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 0);
    }

    public static void openTicket() {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter the ticket subject: ");
        String subject = scanner.nextLine();

        System.out.print("Describe your problem: ");
        String description = scanner.nextLine();

        if (userName.isBlank() || subject.isBlank() || description.isBlank()) {
            System.out.println("All fields are required. Ticket was not created.");
            return;
        }

        Ticket ticket = new Ticket(nextId, userName, subject, description);
        tickets.add(ticket);
        nextId++;

        System.out.println("Ticket opened successfully!");
    }

    public static void viewUserTickets() {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        boolean found = false;

        for (Ticket ticket : tickets) {
            if (ticket.getUserName().equalsIgnoreCase(userName)) {
                ticket.showUserTicket();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tickets found for this user.");
        }
    }

    public static void viewSupportResponse() {
        System.out.print("Enter the ticket ID: ");
        int id = readInt();

        Ticket ticket = findTicketById(id);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        ticket.showUserTicket();
    }

    public static void listAllTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets registered.");
            return;
        }

        for (Ticket ticket : tickets) {
            ticket.showTicket();
        }
    }

    public static void answerTicket() {
        System.out.print("Enter the ticket ID: ");
        int id = readInt();

        Ticket ticket = findTicketById(id);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        System.out.print("Enter the support response: ");
        String response = scanner.nextLine();

        if (response.isBlank()) {
            System.out.println("Response cannot be empty.");
            return;
        }

        ticket.setSupportResponse(response);
        ticket.setStatus("In progress");

        System.out.println("Ticket answered successfully!");
    }

    public static void changeTicketStatus() {
        System.out.print("Enter the ticket ID: ");
        int id = readInt();

        Ticket ticket = findTicketById(id);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        System.out.println("Choose the new status:");
        System.out.println("1 - Open");
        System.out.println("2 - In progress");
        System.out.println("3 - Closed");
        System.out.print("Option: ");

        int statusOption = readInt();

        switch (statusOption) {
            case 1:
                ticket.setStatus("Open");
                break;
            case 2:
                ticket.setStatus("In progress");
                break;
            case 3:
                ticket.setStatus("Closed");
                break;
            default:
                System.out.println("Invalid status.");
                return;
        }

        System.out.println("Status changed successfully!");
    }

    public static void closeTicket() {
        System.out.print("Enter the ticket ID: ");
        int id = readInt();

        Ticket ticket = findTicketById(id);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        ticket.setStatus("Closed");
        System.out.println("Ticket closed successfully!");
    }

    public static Ticket findTicketById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }

        return null;
    }

    public static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scanner.nextLine();
        }

        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
