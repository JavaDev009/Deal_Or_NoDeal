import javax.swing.*;
import java.util.Random;
import java.applet.Applet;
import java.awt.Graphics;

/**
 * Created by admin on 10-11-2016.
 */
public class Gamegui extends Applet {
    private final Player player = new Player();

    private final Banker banker = new Banker();

    private final Gui gui = new Gui();

    private Probability chance = new Probability();

    //private sychronisere sync = new sychronisere();

    private int b = 6;

    private double myAmount = 0;

    private double offer = 0;

    private int turn = 1;

    private int cases = 26;


    private final double[] amounts = {23, 1, 5, 10, 25, 50, 75, 100,
            200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000,
            100000, 300000, 400000, 500000, 750000, 1000000, 250000, 800};

    private final String[] models = {"Harshil", "Satya", "Bela", "Utkarsh", "Sanjay",
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
                briefcase[0] = null;
            } else {
                briefcase[i] = new Briefcase();
                double value = amounts[i];
                briefcase[i].setAmount(value);
                briefcase[i].setFace(i);
            }
        }
    }

    public void starGame() {
        boolean gamestatus = true;
        casesSetup();
        int start=1;
    while (start>0) {
        while (briefcase[gui.mysuit] != null) {
            int choice = gui.mysuit;
            System.out.println("Your Briefcase is "+choice);
            myAmount = briefcase[choice].getAmount();
            //System.out.println(myAmount);
            briefcase[choice] = null;
            //cases--;
            start--;
            break;
        }
    }

        while (gamestatus) {
            if (gui.clicker == 25 || gui.clicker == 19 || gui.clicker == 14 || gui.clicker == 10 || gui.clicker == 7) {
                int a = b;
                while (a > 0) {
                    while (briefcase[gui.mysuit] != null) {

                        int r = gui.mysuit;
                        //showStatus("there was " + briefcase[r] + " cash in the briefcase");
                        String s = "there was cash " + briefcase[r].getAmount() + " in the briefcase";
                        JOptionPane.showMessageDialog(null, s);
                        //System.out.println(briefcase[r].getAmount());
                        briefcase[r] = null;
                        //cases--;
                        a--;
                        break;
                    }
                }
                b--;
                turn++;
                banker.setOffer(turn, briefcase, myAmount);
                offer = banker.getOffer(turn, briefcase, myAmount);
                int reply;
                if(chance.Aiworks(offer,briefcase,myAmount))
                    reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + offer + " as a final offer. \n It is a Good One \n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                else
                    reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + offer + " as a final offer. \n It is not that Good \n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + offer + "\n There was $" + myAmount + " in your case. \n The difference between the offer and your case is $" + ((int) (100 * (offer - myAmount))) / 100.00);
                    gamestatus = false;
                    System.exit(0);
                } else
                    gamestatus = true;
            } else if (gui.clicker == 1) {
                while (briefcase[gui.mysuit] != null) {

                    int r = gui.mysuit;
                    String s = "there was cash " + briefcase[r].getAmount() + " in the briefcase";
                    JOptionPane.showMessageDialog(null, s);
                    //System.out.println(briefcase[r].getAmount());
                    briefcase[r] = null;
                    gamestatus = false;
                    break;
                }
            } else {
                while (briefcase[gui.mysuit] != null) {
                int r = gui.mysuit;
                String s = "there was cash "+briefcase[r].getAmount()+" in the briefcase";
                JOptionPane.showMessageDialog(null, s);
                //System.out.println(briefcase[r].getAmount());
                briefcase[r] = null;
                //cases--;
                banker.setOffer(turn, briefcase, myAmount);
                offer = banker.getOffer(turn, briefcase, myAmount);
                int reply;
                if(chance.Aiworks(offer,briefcase,myAmount))
                    reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + offer + " as a final offer. \n It is a Good One \n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                else
                    reply = JOptionPane.showConfirmDialog(null, "The banker offers $" + offer + " as a final offer. \n It is not that Good \n Do you accept?", "Banker's offer", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You have won $" + offer + "\n There was $" + myAmount + " in your case. \n The difference between the offer and your case is $" + ((int) (100 * (offer - myAmount))) / 100.00);
                    gamestatus = false;
                    System.exit(0);
                } else
                    gamestatus = true;
                    break;
            }}
        }
        finishgame();
    }

    private void finishgame() {
        if (cases == 1) {
            JOptionPane.showMessageDialog(null, "You walk away with " + myAmount + " cash in your briefcase");
        } else {
            JOptionPane.showMessageDialog(null, "Good decision, You get " + offer + " cash from the banker");
        }
    }
}

