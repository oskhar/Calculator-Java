package controllers;

// Library
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import views.DisplayView;

// Class
public class KeyboardController implements KeyListener {

    // Atribute
    private StringController hasil = new StringController();
    private DisplayView labelHitung;
    private DisplayView labelHasil;
    public boolean first = true;

    // Constructor
    public KeyboardController (DisplayView labelHitung, DisplayView labelHasil) {

        this.labelHitung = labelHitung;
        this.labelHasil = labelHasil;

    }

    @Override
    public void keyPressed(KeyEvent evt) {
        String str = evt.getKeyText(evt.getKeyCode());

        if (str.equals("Enter")) {
            labelHasil.setText(hasil.hitung(labelHitung.getText())+"");
            if (hasil.kurungSalah) {
                labelHasil.setText("'(' or ')' not sync");
                hasil.kurungSalah = false;
                
            }

        }
        
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        // Nothing
        
    }

    @Override
    public void keyTyped(KeyEvent evt) {

    }

}
