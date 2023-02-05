package controllers;

// Library
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import views.DisplayView;

public class KeyboardController implements KeyListener {

    // Atribute
    private StringController hasil = new StringController();
    private DisplayView labelHitung;
    private DisplayView labelHasil;
    private boolean first = true;

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

        } else if (str.equals("Backspace") && labelHitung.getText().length() > 0) {
            labelHitung.setText(labelHitung.getText().substring(0, labelHitung.getText().length() - 1));

        }
        
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        // Nothing
        
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        
        String str = Character.toString(evt.getKeyChar());
        String insideCalc;
        int i;
        String[] listOps = {"+", "-", "x", "(", ")"};

        for (i = 0; i < 15; i++) {

            if (str.equals(i+"")) {
                insideCalc = first ? str : labelHitung.getText() + str;
                labelHitung.setText(insideCalc);
                if (first)
                    first = false;

            } else if (i > 9) {
                if (str.equals(listOps[i-10])) {
                    insideCalc = first ? str : labelHitung.getText() + str;
                    labelHitung.setText(insideCalc);
                    if (first)
                        first = false;

                }

            }

        }

        if (str.equals("/")) {
            str = "÷";
            insideCalc = first ? str : labelHitung.getText() + str;
            labelHitung.setText(insideCalc);
            if (first)
                first = false;

        }
        
    }
    
}
