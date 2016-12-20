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
public class Vehicle {
    private String motor;
    
    public void moveForward(){
    }
    public void moveBackward(){
    }
    public void turnLeft(){
    }
    public void turnRight(){
    }
    @Override
    public String toString() {
        return "Im a vehicle";
    }

    public Vehicle() {
        System.out.println("Vehicle Contructor");
    }

    /**
     * @return the motor
     */
    public String getMotor() {
        return motor;
    }

    /**
     * @param motor the motor to set
     */
    public void setMotor(String motor) {
        this.motor = motor;
    }
        
}
