/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3.example.vehicles;

/**
 *
 * @author fcarella
 */
public class Motorcycle extends WheeledVehicle {

    public Motorcycle() {
        System.out.println("Motorcycle Contructor");
        setNumWheels(2);
        setMotor("2 stroke");
    }
  @Override
    public String toString() {
        return super.toString()+":Im a Motorcycle";
    }
   
}
