package quidProQuo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StateOfTheUnionView extends JPanel {
    private static final int WIDTH = 1480;
    private static final int HEIGHT = 825;
    private static int year;

    public StateOfTheUnionView(int year) {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        StateOfTheUnionView.year = year;
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
        Main.frame.setContentPane(new RoomView(Main.year, Main.dem, Main.rep, Main.nat));
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

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);
        g.setColor(Color.WHITE);
        g.drawString("Year " + year, WIDTH/2, 20);
    }
}

