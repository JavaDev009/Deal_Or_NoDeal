/**
 * Created by admin on 13-11-2016.
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Board extends JPanel
{
    public static JLabel[] boardValue = new JLabel[26];
    {
        for(int x=0; x<26; x++)
        {
            boardValue[x] = new JLabel();
        }
    }

    //Public static and declared and initialized everything so I can edit them
    //with action listeners in the Briefcase class

    public Board()
    {


        setLayout(new GridLayout(13, 2, 2, 2));





        boardValue[0].setText("$0.01");
        boardValue[1].setText("$1");
        boardValue[2].setText("$5");
        boardValue[3].setText("$10");
        boardValue[4].setText("$25");
        boardValue[5].setText("$50");
        boardValue[6].setText("$75");
        boardValue[7].setText("$100");
        boardValue[8].setText("$200");
        boardValue[9].setText("$300");
        boardValue[10].setText("$400");
        boardValue[11].setText("$500");
        boardValue[12].setText("$750");
        boardValue[13].setText("$1,000");
        boardValue[14].setText("$5,000");
        boardValue[15].setText("$10,000");
        boardValue[16].setText("$25,000");
        boardValue[17].setText("$50,000");
        boardValue[18].setText("$75,000");
        boardValue[19].setText("$100,000");
        boardValue[20].setText("$200,000");
        boardValue[21].setText("$300,000");
        boardValue[22].setText("$400,000");
        boardValue[23].setText("$500,000");
        boardValue[24].setText("$750,000");
        boardValue[25].setText("$1,000,000");

        // Set strings for each boardValue to display, they correspond with briefcase
        // 'reference' integers

        add(boardValue[0]);
        add(boardValue[13]);
        add(boardValue[1]);
        add(boardValue[14]);
        add(boardValue[2]);
        add(boardValue[15]);
        add(boardValue[3]);
        add(boardValue[16]);
        add(boardValue[4]);
        add(boardValue[17]);
        add(boardValue[5]);
        add(boardValue[18]);
        add(boardValue[6]);
        add(boardValue[19]);
        add(boardValue[7]);
        add(boardValue[20]);
        add(boardValue[8]);
        add(boardValue[21]);
        add(boardValue[9]);
        add(boardValue[22]);
        add(boardValue[10]);
        add(boardValue[23]);
        add(boardValue[11]);
        add(boardValue[24]);
        add(boardValue[12]);
        add(boardValue[25]);

        // Had to enter them in a weird order, took the long way


    }

    public static void setColor()
    {
        for(int x=0;x<26;x++)
        {
            boardValue[x].setForeground(Color.BLACK);
            boardValue[x].setBackground(Color.YELLOW);

        }
        // I don't think this actually ended up doing anything
    }
}
