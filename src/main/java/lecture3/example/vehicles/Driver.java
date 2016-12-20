/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3.example.vehicles;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author fcarella
 */
public class Driver {

    public static void main(String[] args) {
        // references to objects
        Vehicle vehicle = null;
        WheeledVehicle wheeledVehicle;
        TreadedVehicle treadedVehicle;
        Motorcycle motorcycle;

        System.out.println("-----------------");
        vehicle = new Vehicle();
        System.out.println("-----------------");
        wheeledVehicle = new WheeledVehicle();
        System.out.println("-----------------");
        treadedVehicle = new TreadedVehicle();
        System.out.println("-----------------");
        motorcycle = new Motorcycle();
        System.out.println("-----------------");
        vehicle.setMotor("8 cylinder");

        System.out.println("-----------------");
        System.out.println(vehicle);
        System.out.println("-----------------");
        System.out.println(wheeledVehicle);
        System.out.println("-----------------");
        System.out.println(treadedVehicle);
        System.out.println("-----------------");
        System.out.println(motorcycle);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(vehicle);
        vehicles.add(wheeledVehicle);
        vehicles.add(treadedVehicle);
        vehicles.add(motorcycle);
        // method 1
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println(vehicles.get(i));
        }
        // method 2
        for (Vehicle justin : vehicles) {
            System.out.println(justin);
        }
        // method 3
        Iterator it = vehicles.iterator();
        while (it.hasNext()) {
            Object v = it.next();
            System.out.println(v);
        }

        printList(vehicles);
        

        if (vehicles.contains(motorcycle)) {
            System.out.println("Ya, I got a motorcycle");
            System.out.println("its the "
                    + (vehicles.indexOf(motorcycle)+1)
                    + " 'th vehicle in the lot");
        }
        vehicles.remove(motorcycle);
        vehicles.remove(2);
        printList(vehicles);
        vehicles.add(treadedVehicle);
        vehicles.add(motorcycle);
        printList(vehicles);
    }

    public static void printList(ArrayList list) {
        // method 3
        System.out.println("-----------------");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object v = it.next();
            System.out.println(v);
        }

    }
}
