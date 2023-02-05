package controllers;

import java.util.Arrays;

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
        int i, j, tmp = 0;
        int[] urutan = new int[str.length()];
        char[] operator = {'÷', '*', '-', '+'};
        int pin = 0;

        for (i = 0; i < str.length(); i++) {
            for (j = 0; j < 4; j++) {
                if (str.charAt(i) == operator[j]) {
                    str = str.substring(0, i) + "=" + str.substring(i + 1);
                    urutan[tmp] = j;
                    tmp++;

                }

            }

        }

        String[] pemecah = str.split("=");

        for (i = 1; i < pemecah.length; i++) {

            if (urutan[i-1] == 0) {
                pemecah[i-1] = (Double.parseDouble(pemecah[(i-1)]) / Double.parseDouble(pemecah[i])) + "";
                for (j = i; j < pemecah.length - 1; j ++) {
                    pemecah[j] = pemecah[j+1];

                }
                for (j = i; j < urutan.length - 1; j ++) {
                    urutan[j-1] = urutan[j];

                }
                pin++;

            } else if (urutan[i-1] == 1) {
                pemecah[i-1] = (Double.parseDouble(pemecah[(i-1)]) * Double.parseDouble(pemecah[i])) + "";
                for (j = i; j < pemecah.length - 1; j ++) {
                    pemecah[j] = pemecah[j+1];

                }
                for (j = i; j < urutan.length - 1; j ++) {
                    urutan[j-1] = urutan[j];

                }
                pin++;

            }
            System.out.println(Arrays.toString(pemecah));
            System.out.println(Arrays.toString(urutan));

        }

        hasil = Double.parseDouble(pemecah[0]);

        for (i = 0; i < pemecah.length - pin; i++) {
            if (urutan[i] == 2) {
                hasil -= Double.parseDouble(pemecah[i+1]);

            } else if (urutan[i] == 3) {
                hasil += Double.parseDouble(pemecah[i+1]);

            }
            System.out.println(hasil);

        }

        return hasil;

    }

}