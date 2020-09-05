package RandomNumber;

import java.util.Scanner;

public  class randomNumberGame {

    randomNumberGame() {
        Scanner cin = new Scanner(System.in);
        showRHeader();
        showCalculation();
        int choice;
        Boolean quit;
        quit= false;
        System.out.print("Enter choice:");
        choice = cin.nextInt();
        while (!quit) {
            switch (choice){
                case 1:
                    normalGame ngame = new normalGame();
                    break;
                case 2:
                    areaGame agame = new areaGame();
                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.err.println("Invalid selection!");
            }
        }
    }


    public void showRHeader() {
        System.out.println("=========================");
        System.out.println("!    Area Math Game   !");
        System.out.println("=========================");
    }
    public void showCalculation () {
        System.out.println("1. Simple Calculation");
        System.out.println("2. Area Calculation");
        System.out.println("3. Exit");
    }
}

