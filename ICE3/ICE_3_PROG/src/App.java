
//imports

import java.util.Scanner;
public class App {


    public static void main(String[] args) throws Exception {
  
       
        System.out.println("Please select code to run: " +
        "\n" + "Bracket tester: 1"
        + "\n" + "Odd Squares Sum: 2"
        + "\n" + "Greatest Common Divisor: 3");
        Scanner choiceCheck = new Scanner(System.in);
        Byte choice = choiceCheck.nextByte();

        if (choice == 1) {
            String inputString = "([]{}[)";
        System.out.println(parenthesisComparer(inputString));  
        } else {
            if (choice == 2) {
                 int limit = 50000;
        long sum = odd_squares_sum(limit);
        System.out.println("Sum of odds for limit = " + limit +" is " + sum);
            } else {
                if (choice == 3) {
                    int a = 10, b = 15;
                    double gcd = greatest_commeon_divisor(a,b);
                    System.out.println("Greatest common divisor is = " + gcd); 
                }
                
            }
            
        }
      

    }

    public static boolean parenthesisComparer(String line) {
        StringBuilder brackets = new StringBuilder("");
        int length = 0;
        char bracketSelected;
        boolean valid = true;
        while (length <= line.length() - 1 && length >= 0) {
            bracketSelected = line.charAt(length);
            if (bracketSelected == '{' || bracketSelected == '[' || bracketSelected == '(') {
                brackets.append(bracketSelected);
            } else {
                switch (bracketSelected) {
                    case '}':
                        if (brackets.charAt(brackets.length() - 1) == '{')
                            brackets.deleteCharAt(brackets.length() - 1);
                        else
                            length = -2;
                        break;

                    case ']':
                        if (brackets.charAt(brackets.length() - 1) == '[')
                            brackets.deleteCharAt(brackets.length() - 1);
                        else
                            length = -2;
                        break;
                    case ')':
                        if (brackets.charAt(brackets.length() - 1) == '(')
                            brackets.deleteCharAt(brackets.length() - 1);
                        else
                            length = -2;
                        break;
                    default:
                        System.out.println("Invalid input character " + bracketSelected);
                        valid = false;
                        length = -2;
                }
            }
            System.out.println("Bracket to delete or add" + bracketSelected);
            System.out.println(brackets);
            length++;
        }
        if (brackets.length() > 1)
            valid = false;
        return valid;
    }


     
    public static long odd_squares_sum(int limit){
        long total = 0;
        for(int i = 1; i <= limit; i = i + 2){
            
            total = (long)Math.pow(i,2) + total;
        }
        
        return total;
    }

    public static double greatest_commeon_divisor(int a, int b){
        double result = 0;
        int calc = 0;
        if(a < 0 || b < 0){
            return result;
        }
        else{
            while(a % b > 0){
                calc = a % b;
                a = b;
                b = calc;
            }
            return b;
        }
    
    }

}
