package quidProQuo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CreditsView extends JPanel {
    private static final int WIDTH = 1480;
    private static final int HEIGHT = 825;

    public CreditsView() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        MouseAdapter listener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                handleMousePressed(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                handleMouseDragged(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                handleMouseReleased(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) { handleMouseMoved(e);}

        };
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    protected void handleMouseMoved(MouseEvent e){
        repaint();
    }


    protected void handleMousePressed(MouseEvent e) {
        Main.frame.setContentPane(new StartView());
        Main.frame.pack();
        Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Main.frame.setVisible(true);

    }

    protected void handleMouseDragged(MouseEvent e) {
        repaint();
    }

    protected void handleMouseReleased(MouseEvent e) {
        repaint();
    }

    /** Paint Component **/
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        String creditsTitle = "CREDITS";
        String songCredits = "The file \"newGame.wav\" uses 3 distinct songs, The Stars and Stripes Forever, The Thunderer, and The Washington Post.\n" +
                "\n" +
                "The Stars and Stripes Forever was recorded by The United States Marine Band, conducted by Jason Fettig.\n" +
                "It was published in \"The Complete Marches of John Philip Sousa, No. 53\" in 2016.\n" +
                "It is licensed under the Creative Commons Attribution 4.0.\n" +
                "\n" +
                "The Thunderer was recorded by The United States Marine Band, conducted by Jason Fettig.\n" +
                "It was published in \"The Complete Marches of John Philip Sousa, No. 37\" in 2016.\n" +
                "It is licensed under the Creative Commons Attribution 4.0.\n" +
                "\n" +
                "The Washington Post was recorded by The United States Marine Band, conducted by Jason Fettig.\n" +
                "It was published in \"The Complete Marches of John Philip Sousa, No. 38\" in 2016.\n" +
                "It is licensed under the Creative Commons Attribution 4.0.\n" +
                "\n" +
                "The file \"hailToCheif.wav\" was a remix by Youtuber Raxlen Slice\n" +
                "Youtube link: https://www.youtube.com/watch?v=CRx1yV6T0ns";
        g.drawString(creditsTitle, WIDTH / 2, 25);

        //at each line break, the string is separated and is drawn separately as its own string
        int songIterator = 0;
        for(String str : songCredits.split("\n")) {
            songIterator++;
            g.drawString(str, WIDTH/4, 50 + songIterator*20);
        }
    }
}
