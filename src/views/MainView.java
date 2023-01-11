package views;

import java.awt.Color;
import javax.swing.*;

public class MainView extends JFrame {
    
    // CONSTRUCTOR
    public MainView () {
        
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        tambahTombol("10");

        aturBackgorund (Color.white);
        setVisible(true);

    }

    // METHOD
    public void tambahTombol (String isi) {
        TombolView tbl = new TombolView(isi, 50, 50, Color.blue, Color.white);
        add(tbl);

    }

    // METHOD
    public void aturBackgorund (Color wrn) {
        JLabel background = new JLabel();
        background.setBackground(wrn);
        add(background);

    }

}
