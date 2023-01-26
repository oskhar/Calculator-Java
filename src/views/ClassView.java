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



    }
    
}
