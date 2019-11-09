package quidProQuo;

import javax.swing.*;

public class Main {
    public static JFrame frame;
    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                StartView start = new StartView();
                frame = new JFrame("Quid Pro Quo");
                frame.setContentPane(start);
                frame.pack();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);


            }
        });
    }
}
