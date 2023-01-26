package views;

// Libarary
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

// CLASS
public class TombolView extends JButton {
    
    // CONSTRUCTOR
    public TombolView (String isi, int x, int y, Color bac, Color tex, ActionListener act) {

        setBounds(x, y, 70, 50);
        setFont(new Font("Arial", Font.BOLD, 15));
        setForeground(tex);
        setBackground(bac);
        setText(isi);
        addActionListener(act);

    }

}
