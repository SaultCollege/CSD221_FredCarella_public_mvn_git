/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture3.menu;

import java.util.Scanner;

/**
 *
 * @author fcarella
 */
public class Menu {

    private static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice = 0;
        boolean done = false;

        while (!done) {
            try {
                System.out.println("1. Option 1");
                System.out.println("2. Option 2");
                System.out.println("3. Option 3");
                System.out.println("99. Quit");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        doOption1();
                        break;
                    case 2:
                        doOption2();
                        break;
                    case 3:
                        doOption3();
                        break;
                    case 99:
                        done = true;
                        break;
                    default:
                        System.out.println("Wrong entry try again.");
                }
            } catch (Exception e) {
                System.out.println("Wrong entry try again.");
                input.next();
            }
        }
    }

    private static void doOption1() {
        System.out.println("Do option 1");
    }

    private static void doOption2() {
        System.out.println("Do option 2");
    }

    private static void doOption3() {
        System.out.println("Do option 3");
    }
}
