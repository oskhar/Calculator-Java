package models;

// Library
import java.awt.Color;

// Class
public class ClassModel {
    
    // Atribute
    public String[][] buttonNumber = {
        { "1", "80", "80", "40",  "210" },
        { "2", "80", "80", "130", "210" },
        { "3", "80", "80", "220", "210" },
        { "4", "80", "80", "310", "210" },
        { "5", "80", "80", "40",  "300" },
        { "6", "80", "80", "130", "300" },
        { "7", "80", "80", "220", "300" },
        { "8", "80", "80", "310", "300" },
        { "9", "80", "80", "40",  "390" },
        { "0", "80", "80", "130", "390" }
    };
    public String[][] buttonOprator = {
        { "+", "80", "80", "40",  "120" },
        { "-", "80", "80", "130", "120" },
        { "*", "80", "80", "220", "120" },
        { "÷", "80", "80", "310", "120" }
    };
    public String[][] buttonControl = {
        { "Del",   "80", "80", "220", "390" },
        { "Clear", "80", "80", "310", "390" },
        { "=",   "80", "350", "400", "390" }
    };
    public int width = 520;
    public int height = 860;
    public Color putih = new Color(240, 240, 240);
    public Color abutua = new Color(24, 27, 40);
    public Color abumuda = new Color(30, 34, 51);

}
