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
    private boolean first = true;


    // Constructor
    public ClassController (DisplayView labelHitung, DisplayView labelHasil) {

        this.labelHitung = labelHitung;
        this.labelHasil = labelHasil;

    }

    // Methode
    @Override
    public void actionPerformed(ActionEvent evt) {
        
        String str = evt.getActionCommand();
        if (str.equals("=")) {
            System.out.println(labelHitung.getText());
            labelHasil.setText(hasil.hitung(labelHitung.getText())+"");

        } else {
            String insideCalc = first ? str : labelHitung.getText() + str;
            labelHitung.setText(insideCalc);
            if (first)
                first = false;
        }
        
    }
    
}
