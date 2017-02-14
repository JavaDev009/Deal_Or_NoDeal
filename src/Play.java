/**
 * Created by admin on 26-10-2016.
 */
import java.io.*;
class Play {

    public static void main(String[] args) throws IOException {
        //Game dnd = new Game();        //comment this line for gui

        Gamegui dnd = new Gamegui();    //comment this line for console

        dnd.starGame();

    }
}