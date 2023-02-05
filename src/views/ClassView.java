/* 
    This program as main class for view java file
*/

// Package
package views;

// Library
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import controllers.ClassController;
import models.ClassModel;

// Class
public class ClassView extends JFrame {

    // Atribute
    private ClassModel model = new ClassModel();
    private ClassController controller;
    private ButtonView buttonNumber[] = new ButtonView[10];
    private ButtonView buttonOprator[] = new ButtonView[4];
    private ButtonView buttonControl[] = new ButtonView[5];
    private DisplayView labelAngka[] = new DisplayView[2];

    // Constructor
    public ClassView () {

        // Setting
        int i;
        setSize(model.width, model.height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(model.abutua);
        setLayout(null);
        setIconImage(new ImageIcon(model.icon).getImage()); 

        // Sync to my controller
        addLabel(0);
        addLabel(1);
        controller = new ClassController(labelAngka[0], labelAngka[1]);
        addKeyListener(controller.key);

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

        for (i = 0; i < 4; i++) {

            buttonOprator[i] =  new ButtonView (
                model.buttonOprator[i][0], 
                Integer.parseInt(model.buttonOprator[i][1]),
                Integer.parseInt(model.buttonOprator[i][2]),
                Integer.parseInt(model.buttonOprator[i][3]),
                Integer.parseInt(model.buttonOprator[i][4]),
                model.abumuda,
                model.putih,
                controller
            );

            add(buttonOprator[i]);

        }

        for (i = 0; i < 5; i++) {

            buttonControl[i] =  new ButtonView (
                model.buttonControl[i][0], 
                Integer.parseInt(model.buttonControl[i][1]),
                Integer.parseInt(model.buttonControl[i][2]),
                Integer.parseInt(model.buttonControl[i][3]),
                Integer.parseInt(model.buttonControl[i][4]),
                model.abumuda,
                model.putih,
                controller
            );

            add(buttonControl[i]);

        }

        for (i = 0; i < 2; i++) {

        }

        // Draw
        setVisible(true);

    }

    // Method
    private void addLabel (int i) {

        labelAngka[i] =  new DisplayView (
            model.labelAngka[i][0], 
            Integer.parseInt(model.labelAngka[i][1]),
            Integer.parseInt(model.labelAngka[i][2]),
            Integer.parseInt(model.labelAngka[i][3]),
            Integer.parseInt(model.labelAngka[i][4]),
            model.gelap,
            model.putih
        );

        add(labelAngka[i]);

    }
    
}
