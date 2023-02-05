package controllers;

// Library
import java.util.Stack;

// Class
public class StringController {

    // Atribute
    public boolean kurungSalah = false;

    // Method
    public double hitung (String str) {

         double hasil = 0;
         int i, tmp = 0;
         int[] urutan = new int[str.length()];

         for (i = 0; i < str.length(); i++) {
            
            if (str.charAt(i) == '(') {
                  str = str.substring(0, i) + "=" + str.substring(i + 1);
                  urutan[tmp] = i;
                  tmp++;

            } else if (str.charAt(i) == ')') {
                  str = str.substring(0, i) + "=" + str.substring(i + 1);
                  urutan[tmp] = i;
                  tmp++;

            }

         }

         String[] pemecah = str.split("=");
         if (pemecah.length > 1) {
            
            String[] listHasil = new String[pemecah.length / 2 + 1];

            if (pemecah.length % 2 != 0) {
               kurungSalah = true;
               return 0;

            }

            for (i = 0; i < pemecah.length / 2; i++) {
               listHasil[i+1] = hasilAkhir(str.substring(urutan[(2*i)], urutan[1+(2*i)]))+"";

            }

            // Output
            hasil = hasilAkhir(String.join("", listHasil));

         } else {

            hasil = hasilAkhir(str);

         }

         return hasil;

    }

    // Method
    public double hasilAkhir (String str) {

         double hasil = 0;
         int i, j;
         Stack<Double> stkAngka = new Stack<>();
         Stack<Integer> stkOptA = new Stack<>();
         Stack<Integer> stkOptB = new Stack<>();
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
         stkAngka.push(Double.parseDouble(pemecah[pemecah.length-1]));
         for (i = pemecah.length-2; i >= 0; i--) {

            if (stkOptA.peek() == 0) {
               stkAngka.push(Double.parseDouble(pemecah[(i-1)]) / Double.parseDouble(pemecah[i]));
               stkOptA.pop();

            } else if (stkOptA.peek() == 1) {
               stkAngka.push(Double.parseDouble(pemecah[(i-1)]) * Double.parseDouble(pemecah[i]));
               stkOptA.pop();

            } else {
               stkAngka.push(Double.parseDouble(pemecah[i]));
               stkOptB.push(stkOptA.peek());
               stkOptA.pop();

            }

         }

         System.out.println(stkOptB);
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
            System.out.println(hasil);

         }

         return hasil;

    }

}