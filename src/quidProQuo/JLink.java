package quidProQuo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class JLink extends JLabel {
    private String url;
    private String html = "<html><a href=''>%s</a></html>";

    public JLink(String text) {
        this(text, null, null);
    }

    public JLink(String text, String url) {
        this(text, url, null);
    }

    public JLink(String text, String url, String tooltip) {
        super(text);
        this.url = url;

        setToolTipText(tooltip);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent e) {
                setText(String.format(html, text));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setText(text);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                try {

                    Desktop.getDesktop().browse(new URI(JLink.this.url));

                } catch (IOException | URISyntaxException e1) {
                    JOptionPane.showMessageDialog(JLink.this,
                            "Could not open the hyperlink. Error: " + e1.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        });
    }

    public void setUrl(String str) {
        url = str;
    }
}
