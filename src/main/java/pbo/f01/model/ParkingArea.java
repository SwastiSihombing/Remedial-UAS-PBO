package pbo.f01.model;

import java.util.ArrayList;
import java.util.List;

public class ParkingArea {
    private String name;
    private int capacity;
    private String allowedType;
    private List<Vehicle> vehicles = new ArrayList<>();

    public ParkingArea() {}

    public ParkingArea(String name, int capacity, String allowedType) {
        this.name = name;
        this.capacity = capacity;
        this.allowedType = allowedType;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String getAllowedType() { return allowedType; }
    public List<Vehicle> getVehicles() { return vehicles; }

    public boolean accepts(String vehicleType) {
        return allowedType.equals("*") || allowedType.equals(vehicleType);
    }

    public boolean isFull() {
        return vehicles.size() >= capacity;
    }

    public int getOccupied() {
        return vehicles.size();
    }
}