package pbo.f01.model;

public class Vehicle {
    private String plateNumber;
    private String owner;
    private String type;
    private ParkingArea parkingArea;

    public Vehicle() {}

    public Vehicle(String plateNumber, String owner, String type) {
        this.plateNumber = plateNumber;
        this.owner = owner;
        this.type = type;
    }

    public String getPlateNumber() { return plateNumber; }
    public String getOwner() { return owner; }
    public String getType() { return type; }
    public ParkingArea getParkingArea() { return parkingArea; }
    
    public void setParkingArea(ParkingArea parkingArea) {
        this.parkingArea = parkingArea;
    }
}