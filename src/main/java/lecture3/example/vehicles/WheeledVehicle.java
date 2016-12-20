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
public class WheeledVehicle extends Vehicle{
    private int numWheels;

    public WheeledVehicle() {
        System.out.println("WheeledVehicle Contructor");
    }
    
    @Override
    public String toString() {
        return "Im a wheeled vehicle";
    }
    
    public void burnout(){
    }

    /**
     * @return the numWheels
     */
    public int getNumWheels() {
        return numWheels;
    }

    /**
     * @param numWheels the numWheels to set
     */
    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }
}
