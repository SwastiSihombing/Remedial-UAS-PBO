package pbo.f01.model;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ParkingService {

    private Map<String, ParkingArea> areas = new HashMap<>();
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public ParkingService() {}

    public void addArea(String name, int capacity, String allowedType) {
        if (areas.containsKey(name)) return;
        areas.put(name, new ParkingArea(name, capacity, allowedType));
    }

    public void addVehicle(String plateNumber, String owner, String type) {
        if (vehicles.containsKey(plateNumber)) return;
        vehicles.put(plateNumber, new Vehicle(plateNumber, owner, type));
    }

    public void park(String plateNumber, String areaName) {
        Vehicle vehicle = vehicles.get(plateNumber);
        ParkingArea area = areas.get(areaName);

        if (vehicle == null || area == null) return;
        if (!area.accepts(vehicle.getType())) return;
        if (area.isFull()) return;

        vehicle.setParkingArea(area);
        area.getVehicles().add(vehicle);
    }

    public void displayAll() {
        List<String> sortedAreaNames = areas.keySet().stream()
            .sorted()
            .collect(Collectors.toList());

        for (String areaName : sortedAreaNames) {
            ParkingArea area = areas.get(areaName);
            System.out.println(area.getName() + " " + area.getAllowedType() + " " + 
                             area.getCapacity() + "|" + area.getOccupied());

            List<Vehicle> areaVehicles = area.getVehicles().stream()
                .sorted((v1, v2) -> v1.getPlateNumber().compareTo(v2.getPlateNumber()))
                .collect(Collectors.toList());

            for (Vehicle v : areaVehicles) {
                System.out.println(v.getPlateNumber() + " " + v.getOwner() + " " + v.getType());
            }
        }
    }
}