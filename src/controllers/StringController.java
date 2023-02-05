package controllers;

import java.util.Arrays;
// Library
import java.util.Stack;

// Class
public class StringController {

    // Atribute
    public boolean kurungSalah = false;
    private Stack<Double> stkAngka = new Stack<>();
    private Stack<Integer> stkOptA = new Stack<>();
    private Stack<Integer> stkOptB = new Stack<>();

    // Method
    public double hitung (String str) {

         int i, tmp = 0;
         boolean find = false;

         for (i = 0; i < str.length(); i++) {
            
            if (str.charAt(i) == '(') {

               if (find) {
                  kurungSalah = true;
                  return 0;

               }
               tmp = i+1;
               find = true;
               str = str.substring(0, i) + " " + str.substring(i + 1);

            } else if (str.charAt(i) == ')') {

               if (!find) {
                  kurungSalah = true;
                  return 0;

               }
               find = false;
               str = str.substring(0, tmp) + hasilAkhir(str.substring(tmp, i)) + str.substring(i + 1);

            }

         }

         return hasilAkhir(str);

    }

    // Method
    public double hasilAkhir (String str) {

         double hasil = 0;
         int i, j;
         char[] operator = {'÷', 'x', '-', '+'};

         for (i = 0; i < str.length(); i++) {

            for (j = 0; j < 4; j++) {

               if (str.charAt(i) == operator[j]) {
                  str = str.substring(0, i) + "=" + str.substring(i + 1);
                  stkOptA.push(j);

               }

            }

         }

         String[] pemecah = str.split("=");
         boolean limit = false;

         for (i = pemecah.length-1; i > 0; i--) {

            if (stkOptA.peek() == 0) {
               
               stkAngka.push(Double.parseDouble(pemecah[((i)-1)]) / Double.parseDouble(pemecah[(i)]));
               stkOptA.pop();
               limit = false;

            } else if (stkOptA.peek() == 1) {
               
               stkAngka.push(Double.parseDouble(pemecah[(i-1)]) * Double.parseDouble(pemecah[i]));
               stkOptA.pop();
               limit = false;

            } else if (limit) {

               stkAngka.push(Double.parseDouble(pemecah[i]));
               stkOptB.push(stkOptA.peek());
               stkOptA.pop();
               limit = false;

            } else if (i == 1) {

               stkAngka.push(Double.parseDouble(pemecah[i-1]));

            } else {

               stkOptB.push(stkOptA.peek());
               stkOptA.pop();
               limit = true;

            }
            if (pemecah.length-1 == 1) {

               stkAngka.push(Double.parseDouble(pemecah[i]));
               stkOptB.push(stkOptA.peek());
               stkOptA.pop();
            }

         }

         // Hitung hasil
         hasil = stkAngka.peek();
         stkAngka.pop();

         while (!stkAngka.empty()) {
            if (stkOptB.peek() == 2) {
                  hasil -= stkAngka.peek();
                  stkAngka.pop();

            } else if (stkOptB.peek() == 3) {
                  hasil += stkAngka.peek();
                  stkAngka.pop();

            }

         }

         return hasil;

   }

}