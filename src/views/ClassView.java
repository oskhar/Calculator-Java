/* 
    This program as parent for view java file
*/

// Package
package views;

// Library
import javax.swing.JFrame;

import controllers.ClassController;
import models.ClassModel;

// Class
public class ClassView extends JFrame {

    // Atribute
    private ClassController controller = new ClassController();
    private ClassModel model = new ClassModel();
    private ButtonView buttonNumber[] = new ButtonView[10];
    private ButtonView buttonOprator[] = new ButtonView[4];
    private ButtonView buttonControl[] = new ButtonView[3];

    // Constructor
    public ClassView () {

        int i;
        setSize(model.width, model.height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(model.abutua);
        setLayout(null);

        for (i = 0; i < 10; i++) {

            buttonNumber[i] =  new ButtonView (
                model.buttonNumber[i][0], 
                Integer.parseInt(model.buttonNumber[i][1]),
                Integer.parseInt(model.buttonNumber[i][2]),
                Integer.parseInt(model.buttonNumber[i][3]),
                Integer.parseInt(model.buttonNumber[i][4]),
                model.abumuda,
                model.putih,
                controller
            );

            add(buttonNumber[i]);

        }

        setVisible(true);

    }
    
}
