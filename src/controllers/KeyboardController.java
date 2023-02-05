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
    public boolean ops = false;

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
        String[] listOps = {"+", "-"};

        for (i = 0; i < 12; i++) {

            if (str.equals(i+"")) {
                insideCalc = first ? str : labelHitung.getText() + str;
                labelHitung.setText(insideCalc);
                ops = true;
                if (first)
                    first = false;

            } else if (i > 9 && ops) {

                if (str.equals(listOps[i-10])) {
                    insideCalc = first ? str : labelHitung.getText() + str;
                    labelHitung.setText(insideCalc);
                    ops = false;
                    if (first)
                        first = false;

                }

            } else if (str.equals("(") && !ops) {

                insideCalc = first ? str : labelHitung.getText() + str;
                labelHitung.setText(insideCalc);
                ops = false;
                if (first)
                    first = false;

            } else if (str.equals(")") && ops) {
                
                insideCalc = first ? str : labelHitung.getText() + str;
                labelHitung.setText(insideCalc);
                ops = true;
                if (first)
                    first = false;

            }

        }

        if (str.equals("/") && ops) {
            str = "÷";
            insideCalc = first ? str : labelHitung.getText() + str;
            labelHitung.setText(insideCalc);
            ops = false;
            if (first)
                first = false;

        } else if (str.equals("*") && ops) {
            str = "x";
            insideCalc = first ? str : labelHitung.getText() + str;
            labelHitung.setText(insideCalc);
            ops = false;
            if (first)
                first = false;

        }

    }

}
