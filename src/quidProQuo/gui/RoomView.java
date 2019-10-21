package quidProQuo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class RoomView extends JPanel {
    private static final long serialVersionUID = 1L;

    /** Width of the window */
    private static final int WIDTH = 800;

    /** Height of window */
    private static final int HEIGHT = 600;

    /** Width of card images */
    private static final int CARD_WIDTH = 80;

    /** Height of card images */
    private static final int CARD_HEIGHT = 116;

    /** Offset of piles from left edge */
    private static final int LEFT_OFFSET = 30;

    /** Offset of top-row piles from top edge */
    private static final int TOP_OFFSET = 20;

    /** Offset of tableau piles from left edge */
    private static final int FOUNDATION_LEFT_OFFSET = 360;

    /** Offset of tableau piles from top edge */
    private static final int TABLEAU_TOP_OFFSET = 160;

    /** Spacing of piles horizontally */
    private static final int HORIZONTAL_PILE_SPACING = 110;

    /** Vertical spacing of cards in tableau piles */
    public static final int VERTICAL_CARD_SPACING = 24;

    // TODO: add other fields

    public RoomView() {
        setBackground(new Color(255, 255, 255));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));


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
        };
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }


    protected void handleMousePressed(MouseEvent e) {
        // TODO: implement

        repaint();
    }

    protected void handleMouseDragged(MouseEvent e) {
        // TODO: implement

        repaint();
    }

    protected void handleMouseReleased(MouseEvent e) {
        // TODO: implement

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Paint background
        super.paintComponent(g);

        // TODO: draw selection (if there is one)

        // TODO: draw congratulatory message if player has won the game
    }


}
