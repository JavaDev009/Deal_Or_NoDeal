/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dhruvil New
 */
public class Banker {
    
    private double total = 0;
    private int a = 0;
    private double amount =0;
    double Average = 0;

    public void setOffer(int turn, Briefcase[] cases, double myAmount) {

        for (int i = 0; i < cases.length; i++) {
            if (cases[i] == null) {
            } else {
                total = total + cases[i].getAmount();
                a++;
            }
        }
        Average = myAmount+total / a;
        amount = Average*turn/ 10;
    }

    public double getOffer(int turn, Briefcase[] cases, double myAmount) {
        setOffer(turn, cases, myAmount);
        System.out.printf("\tThe Bankers Offer is: %.2f \n\n", amount);
        return amount;
    }

}
