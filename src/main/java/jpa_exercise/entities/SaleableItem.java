/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_exercise.entities;

/**
 *
 * @author fcarella
 */
public interface SaleableItem {
    public Double getPrice();
    public void sellCopy(Publication p);
}
