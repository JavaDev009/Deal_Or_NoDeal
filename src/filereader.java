import java.io.*;

class filereader {
    public void read(String s) throws IOException
    {
        int i;
        FileInputStream fin;
        try {
            fin = new FileInputStream(s);
        }
        catch(FileNotFoundException e) {
            System.out.println("File Not Found");
            return;
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Usage: ShowFile File");
            return;
        }
        do {
            i = fin.read();
            if(i != -1) System.out.print((char) i);
        } while(i != -1);
        fin.close();
    }
}