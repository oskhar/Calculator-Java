package controllers;

// Library
import java.util.Stack;

// Class
public class StringController {

   // Method
   public int hitung(String str) {

      char[] tokens = str.toCharArray();
      Stack<Integer> values = new Stack<Integer>();
      Stack<Character> ops = new Stack<Character>();

      for (int i = 0; i < tokens.length; i++) {
         
         if (tokens[i] == ' ')
            continue;

         if (tokens[i] >= '0' && tokens[i] <= '9') {

            StringBuffer sbuf = new StringBuffer();
            
            while (
               i < tokens.length &&
               tokens[i] >= '0' &&
               tokens[i] <= '9'
            ) {
               sbuf.append(tokens[i++]);
            }
            
            values.push(Integer.parseInt(sbuf.toString()));

         }

         else if (
            tokens[i] == '+' ||
            tokens[i] == '-' ||
            tokens[i] == 'x' ||
            tokens[i] == '÷'
         ) {
            while (
               !ops.empty() &&
               hasPrecedence(tokens[i], ops.peek())
            ) {
               values.push(applyOp(ops.pop(), values.pop(), values.pop()));
            }

            ops.push(tokens[i]);
         }
      }

      while (!ops.empty()) {
         values.push(applyOp(ops.pop(), values.pop(), values.pop()));
      }

      return values.pop();

   }

   // Method
   public boolean hasPrecedence(char op1, char op2) {

      if (op2 == '(' || op2 == ')'){
         return false;
      }

      if (
         (op1 == 'x' || op1 == '÷') &&
         (op2 == '+' || op2 == '-')
      ) {
         return false;

      } else {
         return true;
      }

   }

   // Method
   public int applyOp(char op, int b, int a) {

      switch (op) {
      case '+':
         return a + b;
      case '-':
         return a - b;
      case 'x':
         return a * b;
      case '÷':
         return a / b;
      }
      return 0;

   }

}