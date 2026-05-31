package pbo.f01;

import java.util.Scanner;
import pbo.f01.model.ParkingService;

/**
 * Driver class utama
 * Nama: Swasti Maristella Sihombing
 * Nim: 12S24030
 */

public class App {
    public static void main(String[] args) {
        ParkingService service = new ParkingService();

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Smart Campus Parking System ===");
        System.out.println("Perintah: area-add, vehicle-add, park, display-all");
        System.out.println("=====================================");

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("#");
            String command = parts[0];

            if (command.equals("area-add")) {
                String name = parts[1];
                int capacity = Integer.parseInt(parts[2]);
                String allowedType = parts[3];
                service.addArea(name, capacity, allowedType);

            } else if (command.equals("vehicle-add")) {
                String plateNumber = parts[1];
                String owner = parts[2];
                String type = parts[3];
                service.addVehicle(plateNumber, owner, type);

            } else if (command.equals("park")) {
                String plateNumber = parts[1];
                String areaName = parts[2];
                service.park(plateNumber, areaName);

            } else if (command.equals("display-all")) {
                service.displayAll();
            }
            System.out.flush();
        }

        scanner.close();
    }
}