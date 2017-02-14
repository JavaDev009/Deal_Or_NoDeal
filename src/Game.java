/**
 * Created by admin on 26-10-2016.
 */
import java.io.*;
import java.util.Random;

class Game {

    private final Player player = new Player();

    private final Banker banker = new Banker();

    private Probability chance = new Probability();

    private int b = 6;

    private double myAmount = 0;

    private double offer = 0;

    private int turn = 1;

    private int cases = 26;

    private final double[] amounts = { 23, 1, 5, 10, 25, 50, 75, 100,
            200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000,
            100000, 300000, 400000, 500000, 750000, 1000000, 250000, 800 };

    private final String[] models = { "Harshil", "Satya", "Bela", "Utkarsh", "Sanjay",
            "Tony", "mario", "Doraemon", "Shinchan", "Rohit", "Shaival",
            "Thor", "vision", "superman", "spiderman", "batman", "pikachu", "charmander",
            "bulbasor", "logan", "charles", "wonderwomen", "phoenix", "silversurfer",
            "dr strange", "sherlock", "trojen", "heartbleed"};

    private final Briefcase[] briefcase = new Briefcase[27];

    private final Model[] ppl = new Model[27];

    private void setladies() {
        for (int i = 0; i < ppl.length; i++) {
            ppl[i] = new Model();
            String name = models[i];
            ppl[i].setName(name);
        }
    }

    private void Shuffle() {

        Random rgen = new Random();
        for (int i = 0; i < amounts.length - 1; i++) {
            int Position = rgen.nextInt(amounts.length);
            double temp = amounts[i];
            amounts[i] = amounts[Position];
            amounts[Position] = temp;
        }
    }

    private void casesSetup() {
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

    private void showCases() {
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

    private void Welcome() throws IOException {
        filereader D = new filereader();
        D.read("main.txt");
    }

    public void starGame() throws IOException {

        boolean gamestatus = true;
        casesSetup();
        Welcome();
        showCases();
        setladies();

        int choice = player.nUser();
        myAmount = briefcase[choice].getAmount();
        briefcase[choice] = null;
        cases--;

        while (gamestatus) {
            showCases();
            if (cases == 25 || cases == 19 || cases == 14 || cases == 10
                    || cases == 7) {
                int a = 0;
                for (a = b; a > 0; a--) {
                    int r = player.Remove(a, briefcase, models);
                    briefcase[r] = null;
                    cases--;
                }
                b--;
                turn++;
                banker.setOffer(turn,briefcase,myAmount);
                offer = banker.getOffer(turn, briefcase, myAmount);
                if(chance.Aiworks(offer,briefcase,myAmount))
                    System.out.printf("\tThe Bankers Offer is: %.2f \n It is indeed a preety good deal\n", offer);
                else
                    System.out.printf("\tThe Bankers Offer is: %.2f \n It is not that of a good deal\n", offer);
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
                if(chance.Aiworks(offer,briefcase,myAmount))
                    System.out.printf("\tThe Bankers Offer is: %.2f \n It is indeed a preety good deal\n", offer);
                else
                    System.out.printf("\tThe Bankers Offer is: %.2f \n It is not that of a good deal\n", offer);
                gamestatus = player.gamestatus();
            }
        }
        finishgame();
    }

    private void finishgame() {
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