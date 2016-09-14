/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author Dhruvil New
 */
public class Game {
    Player player = new Player();

    Banker banker = new Banker();

    private int a = 0;

    private int b = 6;

    private double myAmount = 0;

    private double offer = 0;

    private int turn = 1;

    private int cases = 26;

    private final double amounts[] = { 23, 1, 5, 10, 25, 50, 75, 100,
            200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000,
            100000, 300000, 400000, 500000, 750000, 1000000, 250000, 800 };

    private final String models[] = { "Nayer", "Michelle", "Obama", "Rosey", "Miney",
            "Ashley", "Maria", "Ozawa", "Audrey", "Kristen", "Kim",
            "Kardashian", "Kourtney", "Ann", "Macy", "Tori", "Sam", "Monica",
            "Jin", "Koi", "jill", "Usher", "Justin Bieber", "Lindsay Lohan",
            "Hazell", "Buttercup", "Don Amalia", "Kojic!" };

    Briefcase briefcase[] = new Briefcase[27];

    Model lady[] = new Model[27];

    public void setladies() {
        for (int i = 0; i < lady.length; i++) {
            lady[i] = new Model();
            String name = models[i];
            lady[i].setName(name);
        }
    }

    public void Shuffle() {

        Random rgen = new Random();
        for (int i = 0; i < amounts.length - 1; i++) {
            int Position = rgen.nextInt(amounts.length);
            double temp = amounts[i];
            amounts[i] = amounts[Position];
            amounts[Position] = temp;
        }
    }

    public void casesSetup() {
        Shuffle();
        for (int i = 0; i < briefcase.length; i++) {
            if (i == 0) {
            } else {
            }
            briefcase[i] = new Briefcase();
            double value = amounts[i];
            briefcase[i].setAmount(value);
            briefcase[i].setFace(i);
        }
    }

    public void showCases() {
        for (int a = 0; a < briefcase.length; a++) {
            if (a == 0) {
            } else if (briefcase[a] == null) {
                System.out.print("\t[X]");
            } else {
                System.out.print("\t[" + briefcase[a].getFace() + "]");
            }
            if (a % 5 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    public void Welcome() {
        System.out.println("\t~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println("\t~*               Welcome !          ~*");
        System.out.println("\t~*~*~*~*~* Hosted by Dhruvil Shah ~*~*~*~*~*~*");
        System.out.println("\t~* Please Select from the Following Cases!~*");
        System.out.println("\t~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
    }

    public void starGame() {

        boolean gamestatus = true;
        casesSetup();
        Welcome();
        showCases();
        setladies();

        int choice = player.nUser();
        myAmount = briefcase[choice].getAmount();
        briefcase[choice] = null;
        cases--;

        while (gamestatus == true) {
            showCases();
            if (cases == 25 || cases == 19 || cases == 14 || cases == 10
                    || cases == 7) {
                for (a = b; a > 0; a--) {
                    int r = player.Remove(a, briefcase, models);
                    briefcase[r] = null;
                    cases--;
                }
                b--;
                turn++;
                banker.setOffer(turn,briefcase,myAmount);
                offer = banker.getOffer(turn, briefcase, myAmount);
                gamestatus = player.gamestatus();
            } else if (cases == 1) {
                int r = player.Remove(1, briefcase, models);
                briefcase[r] = null;
                gamestatus = false;
            } else {
                int r = player.Remove(1, briefcase, models);
                briefcase[r] = null;
                cases--;
                banker.setOffer(turn,briefcase,myAmount);
                offer = banker.getOffer(turn, briefcase, myAmount);
                gamestatus = player.gamestatus();
            }
        }
        finishgame();
    }

    public void finishgame() {
        if (cases == 1) {
            System.out.println("\tYou Rejected the Offer of Banker");
            System.out
            .printf("\tYour case contains $%.2f and the bankers offer is $%.2f\n",
                    myAmount, offer);
            System.out.printf("\tYou've won your case with an amount of: %.2f",
                    myAmount);
        } else {
            System.out.println("\tYou Accepted the offer of Banker");
            System.out
            .printf("\tYour case contains $%.2f and the bankers offer is $%.2f\n",
                    myAmount, offer);
            System.out.printf("\tYou've won the offer of Banker: $%.2f", offer);
        }
    }

}
