public class Ticket {
    private int id;
    private String userName;
    private String subject;
    private String description;
    private String supportResponse;
    private String status;

    public Ticket(int id, String userName, String subject, String description) {
        this.id = id;
        this.userName = userName;
        this.subject = subject;
        this.description = description;
        this.supportResponse = "No response yet";
        this.status = "Open";
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getStatus() {
        return status;
    }

    public void setSupportResponse(String supportResponse) {
        this.supportResponse = supportResponse;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void showTicket() {
        System.out.println("--------------------------------");
        System.out.println("Ticket ID: " + id);
        System.out.println("User: " + userName);
        System.out.println("Subject: " + subject);
        System.out.println("Description: " + description);
        System.out.println("Support response: " + supportResponse);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------");
    }

    public void showUserTicket() {
        System.out.println("--------------------------------");
        System.out.println("Ticket ID: " + id);
        System.out.println("Subject: " + subject);
        System.out.println("Description: " + description);
        System.out.println("Support response: " + supportResponse);
        System.out.println("Status: " + status);
        System.out.println("--------------------------------");
    }
}
