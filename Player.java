/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author Dhruvil New
 */
public class Player {
    
    Scanner input = new Scanner(System.in);
    Banker banker = new Banker();

    public boolean gamestatus() {
        System.out.print("\tAccept or Reject! [1]Accept [2]reject: ");
        int temp = input.nextInt();
        System.out.println();
        if (temp == 1) {
            return false;
        } else {
            return true;
        }
    }

    public int nUser() {

        boolean isOkay = false;
        int nUser = 0;
        while (isOkay == false) {
            System.out.print("\n\tPlease Select Your Case!: ");
            nUser = input.nextInt();
            if (nUser < 0 || nUser >= 27) {
                System.out.println("\tInvalid input Try again");
            } else {
                isOkay = true;
            }
        }
        return nUser;
    }

    public int Remove(int i, Briefcase c[], String[] m) {

        int nChoice = 0;
        boolean inputisok = false;

        while (inputisok == false) {
            System.out.print("\tPlease remove " + i + " case/s: "); 
            nChoice = input.nextInt();
            if (nChoice < 0 || nChoice >= c.length || c[nChoice] == null) {
                System.out.println();
                System.out.println("\tInvalid Input please Try again\n");
            } else {
                System.out.println("\tI'm " + m[nChoice]
                        + " You just removed case # " + nChoice);
                System.out.println("\t|" + nChoice + "| contains $"
                        + c[nChoice].getAmount() + "\n");
                inputisok = true;
            }

        }
        return nChoice;
    }

}
