// Package
package views;

// Library
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;

// Class
public class ButtonView extends JButton {
    
    // Atribute

    // Constuctor
    public ButtonView (String nama, int width, int height, int x, int y, Color background, Color font, ActionListener act) {

        setText(nama);
        setBounds(x, y, width, height);
        setBackground(background);
        setForeground(font);
        setFocusable(false);
        setBorder(null);
        setFont(new  Font("Arial", Font.BOLD, 20));
        addActionListener(act);

    }

}
