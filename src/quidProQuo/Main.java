package quidProQuo;

import quidProQuo.room.RoomView;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Main {
    public static Timer timer;
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                RoomView room = new RoomView();
                JFrame frame = new JFrame("Quid Pro Quo");
                frame.setContentPane(room);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
                timer.start();

            }
        });
    }
}
