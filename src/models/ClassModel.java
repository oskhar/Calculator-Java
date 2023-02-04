package models;

// Library
import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;

// Class
public class ClassModel {
    
    // Atribute
    public String[][] buttonNumber = {
        { "1", "60", "40", "20",  "170" },
        { "2", "60", "40", "90", "170" },
        { "3", "60", "40", "160", "170" },
        { "4", "60", "40", "230", "170" },
        { "5", "60", "40", "20",  "220" },
        { "6", "60", "40", "90", "220" },
        { "7", "60", "40", "160", "220" },
        { "8", "60", "40", "230", "220" },
        { "9", "60", "40", "20",  "270" },
        { "0", "60", "40", "90", "270" }
    };
    public String[][] buttonOprator = {
        { "+", "60", "40", "20",  "120" },
        { "-", "60", "40", "90", "120" },
        { "*", "60", "40", "160", "120" },
        { "÷", "60", "40", "230", "120" }
    };
    public String[][] buttonControl = {
        { "del",   "60", "40", "160", "270" },
        { "clear", "60", "40", "230", "270" },
        { "(",   "60", "40", "300", "120" },
        { ")",   "60", "40", "300", "170" },
        { "=",   "60", "90", "300", "220" }
    };
    public String[][] labelAngka = {
        {"0", "240", "40", "20", "40"},
        {"0", "100", "40", "270", "40"}
    };
    public int width = 390;
    public int height = 370;
    public Color putih = new Color(200, 200, 200);
    public Color abutua = new Color(24, 27, 40);
    public Color abumuda = new Color(30, 34, 51);
    public Color gelap = new Color(22, 25, 37);
    public ImageIcon icon;

    // Constructor
    public ClassModel () {

        try {
            File file = new File("");
            String path = file.getCanonicalPath();
            icon = new ImageIcon(path + "/Calculator-Java/lib/img/icon.png");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
