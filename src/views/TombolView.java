package views;

import javax.swing.*;
import java.awt.*;

public class TombolView extends JButton {
    
    public TombolView (String isi, int x, int y, Color bac, Color tex) {

        setBounds(x, y, 70, 50);
        setFont(new Font("Arial", Font.BOLD, 15));
        setForeground(tex);
        setBackground(bac);
        setText(isi);

    }

}
