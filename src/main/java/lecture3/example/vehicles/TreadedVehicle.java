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
public class TreadedVehicle extends Vehicle{

    private int numTreads;

    public TreadedVehicle() {
        System.out.println("TreadedVehicle Contructor");

    }

    @Override
    public String toString() {
        return "Im a treaded vehicle";
    }

    public void turnOnTheSpot() {

    }

    /**
     * @return the numTreads
     */
    public int getNumTreads() {
        return numTreads;
    }

    /**
     * @param numTreads the numTreads to set
     */
    public void setNumTreads(int numTreads) {
        this.numTreads = numTreads;
    }

}
