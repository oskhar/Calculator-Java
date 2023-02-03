package models;

// Library
import java.util.Stack;

// Class
public class ClassModel {
    
    // Atribute
    public Object[][] buttonNumber = {
        { 0, 80, 80, 40,  210 },
        { 1, 80, 80, 130, 210 },
        { 2, 80, 80, 220, 210 },
        { 3, 80, 80, 310, 210 },
        { 4, 80, 80, 40,  300 },
        { 5, 80, 80, 130, 300 },
        { 6, 80, 80, 220, 300 },
        { 7, 80, 80, 310, 300 },
        { 8, 80, 80, 40,  390 },
        { 9, 80, 80, 130, 390 }
    };
    public Object[][] buttonOprator = {
        { "+", 80, 80, 40,  120 },
        { "-", 80, 80, 130, 120 },
        { "*", 80, 80, 220, 120 },
        { "÷", 80, 80, 310, 120 }
    };
    public Object[][] buttonControl = {
        { "Del",   80, 80, 220, 390 },
        { "Clear", 80, 80, 310, 390 },
        { "=",   80, 350, 400, 390 }
    };
    public int width = 520;
    public int height = 860;

}
