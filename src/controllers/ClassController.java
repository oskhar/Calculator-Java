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

        String[] listOps = {"+", "-", "x", "÷", "("};
        if (str.equals("=")) {

            labelHasil.setText(hasil.hitung(labelHitung.getText())+"");
            if (hasil.kurungSalah) {
                labelHasil.setText("'(' or ')' not sync");
                hasil.kurungSalah = false;
                
            }

        } else if (str.equals("del")) {
            labelHitung.setText(labelHitung.getText().substring(0, labelHitung.getText().length() - 1));

        } else if (str.equals("clear")) {
            labelHitung.setText("");

        }

        for (i = 0; i < 10+listOps.length; i++) {

            if (str.equals(i+"")) {
                insideCalc = key.first ? str : labelHitung.getText() + str;
                labelHitung.setText(insideCalc);
                key.ops = true;
                if (key.first)
                    key.first = false;

            } else if (i > 9) {
                
                if (str.equals(listOps[i-10]) && key.ops) {
                    insideCalc = key.first ? str : labelHitung.getText() + str;
                    labelHitung.setText(insideCalc);
                    key.ops = false;
                    if (key.first)
                        key.first = false;

                } else if (str.equals("(") && !key.ops) {
                    insideCalc = key.first ? str : labelHitung.getText() + str;
                    labelHitung.setText(insideCalc);
                    key.ops = false;
                    if (key.first)
                        key.first = false;

                } else if (str.equals(")") && key.ops) {
                    insideCalc = key.first ? str : labelHitung.getText() + str;
                    labelHitung.setText(insideCalc);
                    key.ops = true;
                    if (key.first)
                        key.first = false;

                }

            }

        }
        
    }
    
}
