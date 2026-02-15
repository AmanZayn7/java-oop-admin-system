package oodjaman;

public class WorkerProfile {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private String address;

    public WorkerProfile(String name, String position, String email, String phoneNumber, String address) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPosition: " + position + "\nEmail: " + email
                + "\nPhone Number: " + phoneNumber + "\nAddress: " + address;
    }
}
