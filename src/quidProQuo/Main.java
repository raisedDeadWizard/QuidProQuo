package quidProQuo;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static JFrame frame;
    public static RoomView room;
    public static int dem = 30;
    public static int rep = 80;
    public static int nat = 50;
    public static int year = 1;
    public static ArrayList<ArrayList<Decision>> decisions = new ArrayList<ArrayList<Decision>>();
    public static ArrayList<ArrayList<Response>> responses = new ArrayList<ArrayList<Response>>();

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StartView start = new StartView();
                frame = new JFrame("Hail To The Chief");
                frame.setContentPane(start);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


            }
        });
    }

    public static void reset(){
        dem = 30;
        rep = 80;
        nat = 50;
        year = 1;
        decisions = new ArrayList<ArrayList<Decision>>();
        responses = new ArrayList<ArrayList<Response>>();

    }
}
