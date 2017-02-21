/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3.w17;

import java.util.Date;

/**
 *
 * @author fcarella
 */
public class Magazine extends Publication{
    private int orderCopy;
    private Date currIssue;

    public Magazine() {
    }

    public Magazine(int orderCopy, Date currIssue) {
        this.orderCopy = orderCopy;
        this.currIssue = currIssue;
    }

    public Magazine(int orderCopy, Date currIssue, String title, Double price, int copies) {
        super(title, price, copies);
        this.orderCopy = orderCopy;
        this.currIssue = currIssue;
    }
    
    
    public void receiveNewIssues(Date newIssue){
    }
    public void adjustQty(int n){
    
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the orderCopy
     */
    public int getOrderCopy() {
        return orderCopy;
    }

    /**
     * @param orderCopy the orderCopy to set
     */
    public void setOrderCopy(int orderCopy) {
        this.orderCopy = orderCopy;
    }

    /**
     * @return the currIssue
     */
    public Date getCurrIssue() {
        return currIssue;
    }

    /**
     * @param currIssue the currIssue to set
     */
    public void setCurrIssue(Date currIssue) {
        this.currIssue = currIssue;
    }
    
}
