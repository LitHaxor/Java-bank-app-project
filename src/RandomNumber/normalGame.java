package RandomNumber;
import RandomNumber.normalGaming;

import java.util.Random;
import java.util.Scanner;

public class normalGame extends randomNumberGame implements normalGaming {

    normalGame() {
       showHeader();
       showSimpleCalculation();
       calculateMyProgram();
    }

    public void showHeader() {
        System.out.println("=========================");
        System.out.println("!    Normal Math Game   !");
        System.out.println("=========================");
    }

    public void showSimpleCalculation () {
        System.out.println("1. Addition");
        System.out.println("2. Substraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
    }

    public void calculateMyProgram() {
        Scanner input = new Scanner(System.in);
        int select;
        Boolean valid=false ;
        System.out.print("Enter choice:");
        select = input.nextInt();
        while (!valid) {
            Random random = new Random();
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            switch (select) {
                case 1:
                    add(a,b);
                    break;
                case 2:
                    subs(a,b);
                    break;
                case 3:
                    multi(a,b);
                    break;
                case 4:
                    division(a,b);
                    break;
                case 5:
                    valid = true;
                    break;
                default:
                    System.err.println("Not a valid option");
            }
        }
    }
    Scanner cin = new Scanner(System.in);
    public void add(int a, int b) {
        int  result;
        System.out.println("What is the addition of " + a  + " and " + b +" ?");
        result = cin.nextInt();
        if(a+ b == result) {
            System.out.println("Correct!");
        }
        else  {
            System.err.println("Incorrect!");
        }
    }
    public void subs(int a, int b) {
        int  result;
        System.out.println("What is the addition of " + a  + " and " + b +" ?");
        result = cin.nextInt();
        if(a- b == result) {
            System.out.println("Correct!");
        }
        else  {
            System.err.println("Incorrect!");
        }
    }
    public void multi(int a, int b) {
        int  result;
        System.out.println("What is the addition of " + a  + " and " + b +" ?");
        result = cin.nextInt();
        if(a* b == result) {
            System.out.println("Correct!");
        }
        else  {
            System.err.println("Incorrect!");
        }
    }
    public void division(int a, int b) {
        int  result;
        System.out.println("What is the addition of " + a  + " and " + b +" ?");
        result = cin.nextInt();
        if(a/b == result) {
            System.out.println("Correct!");
        }
        else  {
            System.err.println("Incorrect!");
        }
    }
}
