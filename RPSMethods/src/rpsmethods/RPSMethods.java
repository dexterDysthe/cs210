/*
 Dexter Dysthe
 CSC 210 - 02  
 1 November 2016
 RPS Methods Assignment
*/


package rpsmethods;

import java.util.Scanner;
import java.util.Random;

public class RPSMethods {
    
    
    
    
    

    
    //Method that displays message reading: "Lets play Rock, Paper, Scissors!".
    public static void displayOpeningMessage() {
        System.out.println("Lets play Rock, Paper, Scissors!");

    }
    
    
    
    /*
     Method that prompts the user to enter an integer coresponding to their
     choice of move; either rock, paper or scissors. We will create a scanner to store 
     their selection. In the case the user enters an integer outside of the acceptable range,
     or if they input a selection of another data type, we will create a loop to
     continuously prompt the user to enter in an appropriate input; integer values 
     between 0 and 2. We will then output a statement with the user's coresponding       
     move.
    */
    public static int getUserMove() {
        Scanner input = new Scanner(System.in);
        int UserChoice = -1;
        do {
            System.out.println("Select 0 for scissors, 1 for rock or 2 for paper!");
            if (input.hasNextInt()) {
                UserChoice = input.nextInt();
                if (UserChoice < 0 || UserChoice > 2) {
                    System.out.println("Invalid input. Please enter a number between 0 and 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number between 0 and 2.");
                input.next();
            }
        } while (UserChoice < 0 || UserChoice > 2);

        if (UserChoice == 0) {
            System.out.println("You selected scissors!");
        } else if (UserChoice == 1) {
            System.out.println("You selected rock!");
        } else {
            System.out.println("You selected paper!");
        }
        return UserChoice;

    }
    
   
    
    /*
     Method that creates a Random object, which generates random integers between
     0 and 2. An output statement with the CPU's move will then be displayed 
     coresponding to whichever number is generated.
    */
    public static int getCPUMove() {
        Random rnd = new Random();
        int CPUChoice = rnd.nextInt(3);
        if (CPUChoice == 0) {
            System.out.println("The computer selected scissors.");
        } else if (CPUChoice == 1) {
            System.out.println("The computer selected rock.");
        } else {
            System.out.println("The computer selected paper.");
        }
        return CPUChoice;
    }

    
    
    /*
     * Method that passes through the integers associated with the return statements
     * from the 2 methods immediately above. This method will then determine the winner
     * of the game through the usage of a switch. Output messages will then be printed
     * coresponding to the outcome of the game.
    */
    public static int determineWinner(int UserChoice, int CPUChoice) {
        int Result = 0;
        
        
        switch (UserChoice) {
            case 0:
                if (CPUChoice == 0) {
                    System.out.println("It's a draw!");
                } else if (CPUChoice == 1) {
                    System.out.println("Rock beats scissors. You lose!");
                    Result+=2;

                } else {
                    System.out.println("Scissors beats paper. You win!");
                    Result++;

                }
                break;
            case 1:
                if (CPUChoice == 0) {
                    System.out.println("Rock beats scissors. You win!");
                    Result++;

                } else if (CPUChoice == 1) {
                    System.out.println("It's a draw!");
                } else {
                    System.out.println("Paper beats rock. You lose!");
                    Result+=2;

                }
                break;
            case 2:
                if (CPUChoice == 0) {
                    System.out.println("Scissors beats paper. You lose!");
                    Result+=2;

                } else if (CPUChoice == 1) {
                    System.out.println("Paper beats rock. You win!");
                    Result++;

                } else {
                    System.out.println("It's a draw!");
                }
                break;

        }
        
    return Result;
    
    }
        
    public static void TwoOutOfThree(int Result){
        
        int UserWins = 0;
        int CPUWins = 0;
        
        while(UserWins < 2 && CPUWins < 2){
            switch(Result){
                case 0:
                      System.out.println("Let's play again to determine the best two out"
                        + " of three!");
                      break;
                case 1:
                      UserWins++;
                      System.out.println("Let's play again to determine the best two out"
                        + " of three!");
                      break;
                case 2:
                      CPUWins++;
                      System.out.println("Let's play again to determine the best two out"
                        + " of three!");
                      break;
            }
            determineWinner(getUserMove(), getCPUMove());
            
            
        }
        if(UserWins == 2){
            System.out.println("Congratulations! You won the best two out of three!");
        }else if(CPUWins == 2){
            System.out.println("Sorry! You lost to a computer.");
        }
        
        
        
    }
    
    
    
    /*
     Main method. Calling on other specific task methods to perform certain areas
     of code
    */
    public static void main(String[] args) {
        displayOpeningMessage();
        determineWinner(getUserMove(), getCPUMove());
        
        TwoOutOfThree(determineWinner(getUserMove(), getCPUMove()));

    }
}
