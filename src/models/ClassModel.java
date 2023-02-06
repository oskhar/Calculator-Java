package models;

// Library
import java.awt.Color;
import java.io.File;

// Class
public class ClassModel {
    
    // Atribute
    public String[][] buttonNumber = {
        { "1", "60", "40", "20",  "150" },
        { "2", "60", "40", "90", "150" },
        { "3", "60", "40", "160", "150" },
        { "4", "60", "40", "230", "150" },
        { "5", "60", "40", "20",  "200" },
        { "6", "60", "40", "90", "200" },
        { "7", "60", "40", "160", "200" },
        { "8", "60", "40", "230", "200" },
        { "9", "60", "40", "20",  "250" },
        { "0", "60", "40", "90", "250" }
    };
    public String[][] buttonOprator = {
        { "+", "60", "40", "20",  "100" },
        { "-", "60", "40", "90", "100" },
        { "*", "60", "40", "160", "100" },
        { "/", "60", "40", "230", "100" }
    };
    public String[][] buttonControl = {
        { "del",   "60", "40", "160", "250" },
        { "clear", "60", "40", "230", "250" },
        { "(",   "60", "40", "300", "100" },
        { ")",   "60", "40", "300", "150" },
        { "=",   "60", "90", "300", "200" }
    };
    public String[][] labelAngka = {
        {"0", "240", "40", "20", "30"},
        {"0", "100", "40", "270", "30"}
    };
    public int width = 390;
    public int height = 370;
    public Color putih = new Color(200, 200, 200);
    public Color abutua = new Color(24, 27, 40);
    public Color abumuda = new Color(30, 34, 51);
    public Color gelap = new Color(22, 25, 37);
    public String icon = "";

    // Constructor
    public ClassModel () {

        try {
            File file = new File("");
            String path = file.getCanonicalPath();
            icon = path + "/lib/img/icon.png";
            System.out.println(icon);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
