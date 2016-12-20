/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author fcarella
 */
public class Pub implements SaleableItem {
    private int copies;

    @Override
    public void sellCopy() {
        copies--;
    }

    public Pub() {
        JButton button=new JButton();
        button.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
        }
        
        );
    }
    
   
}
