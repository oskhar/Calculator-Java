package controllers;

// Library
import java.awt.event.ActionListener;

import views.DisplayView;

import java.awt.event.ActionEvent;

// Class
public class ClassController implements ActionListener {

    // Atribute
    private StringController hasil = new StringController();
    private DisplayView labelHitung;
    private DisplayView labelHasil;
    public KeyboardController key;


    // Constructor
    public ClassController (DisplayView labelHitung, DisplayView labelHasil) {

        this.labelHitung = labelHitung;
        this.labelHasil = labelHasil;
        key = new KeyboardController(labelHitung, labelHasil);

    }

    // Methode
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        String str = evt.getActionCommand();
        int i;
        String insideCalc;

        String[] listOps = {"+", "-", "x", "÷", "(", ")"};
        if (str.equals("=")) {

            labelHasil.setText(hasil.hitung(labelHitung.getText())+"");
            if (hasil.kurungSalah) {
                labelHasil.setText("Tanda kurung salah");
                
            }

        } else if (str.equals("del")) {
            labelHitung.setText(labelHitung.getText().substring(0, labelHitung.getText().length() - 1));

        } else if (str.equals("clear")) {
            labelHitung.setText("");

        }

        for (i = 0; i < listOps.length; i++) {

            if (str.equals(listOps[i]) && key.ops) {

                insideCalc = key.first ? str : labelHitung.getText() + str;
                labelHitung.setText(insideCalc);
                key.ops = false;
                if (key.first)
                    key.first = false;

            } else {

                insideCalc = key.first ? str : labelHitung.getText() + str;
                labelHitung.setText(insideCalc);
                key.ops = true;
                if (key.first)
                    key.first = false;
            }

        }
        
    }
    
}
