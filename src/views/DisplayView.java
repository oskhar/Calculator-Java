package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Component;

// Library
import javax.swing.JTextArea;

// Class
public class DisplayView extends JTextArea {
    
    // Constructor
    public DisplayView (String nama, int width, int height, int x, int y, Color background, Color font) {

        setText(nama);
        setBounds(x, y, width, height);
        setBackground(background);
        setForeground(font);
        setFont(new  Font("Arial", Font.BOLD, 24));
        setAlignmentX(Component.LEFT_ALIGNMENT);

    }

}
