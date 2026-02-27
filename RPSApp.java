import java.util.Scanner;
import java.util.Random;

enum HandSign {
    ROCK, 
    PAPER,
    SCISSORS 
}

public class RPSApp {
    /**
     * Get the computer’s move (randomly generated)
     */

    public static HandSign getComputerMove(){
        Random rd = new Random();
        int n = rd.nextInt(3); // n will be a random number in {0,1,2}
        
        HandSign computerMove = null; 

        // code using n to select
        // a HandSign
        HandSign[] allSigns = HandSign.values();
        computerMove = allSigns[n];

        return computerMove;
    }

    /**
     * Get the player move from the keyboard input
     */
    public static HandSign getPlayerMove(){
        // The Scanner class is used to get the keyboard input
        Scanner in = new Scanner(System.in);
        // Use a variable to tag if the input is valid 
        // (one of the characters {s,S,p,P,r,R,q,Q}) or not
        boolean validInput = true;
        HandSign playerHandSign = null;
        do {// repeat until valid input

            // Add your code to give some description about what input the
            //  users are supposed to give
            System.out.println("Please input your move (R,P,S,Q)");

            // convert the input string into a char type
            char inChar = in.next().toLowerCase().charAt(0);

            // Add your code to output the player’s hand sign. A
            //switch-statement is a good choice.
        
            switch(inChar){
                case('r'):
                    playerHandSign = HandSign.ROCK;
                    break;
                case('p'):
                    playerHandSign = HandSign.PAPER;
                    break;
                case('s'):
                    playerHandSign = HandSign.SCISSORS;
                    break;
                case('q'):
                    System.out.println("Qutting");
                    break;
                default:
                    System.out.println("Input not valid");
                    validInput = false;
                
            }


        } while(!validInput);
        
        return playerHandSign;

      }

    /**
     * Check who wins
     *
     * @param h1 the first hand sign
     * @param h2 the second hand sign
     * @return 0 if two signs equal, 
     *        -1 if the second sign wins, 
     *         1 if the first sign wins
     *
     */
    public static int whoWins(HandSign h1, HandSign h2){
         if(h1 == h2){
            return 0;
         }
         if ( (h1 == HandSign.ROCK && h2 == HandSign.SCISSORS) || (h1 == HandSign.PAPER && h2 == HandSign.ROCK) || (h1 == HandSign.SCISSORS && h2 == HandSign.PAPER)){
            return 1;
         }else{
            return -1;
         }
    }
    
    /**
     * The main method
     */
    public static void main(String[] args) {
        int playerScore = 0;
        int computerScore = 0;

        HandSign playerMove;// player’s sign from keyboard
        HandSign computerMove;// computer’s random sign

        int checkwin;
        boolean gameOver = false;
        while (!gameOver){
            // repeat this process till the user quits
            
            //Step1: Get the player move from the keyboard input
            playerMove = getPlayerMove();

            if (playerMove == null){
                System.out.println("Player has quit");
                gameOver = true;
                continue;
            }
            //Step2: Get the computer’s move (randomly generated)
            computerMove = getComputerMove();

            //Step3: Check who wins
            
            int win = whoWins(playerMove,computerMove);
            System.out.println(playerMove + " Player");
            System.out.println(computerMove + " Computer");

            if(win == 0){
                System.out.println("Draw");
            }else if(win == 1){
                System.out.println("Player wins");
            }else if(win == -1){
                System.out.println("Computer wins");
            }


            if(win == 1){
                playerScore += 1;
            }else if(win == -1){
                computerScore += 1;
            }
            // immplict else add nothing 

            
            //Step4: Output who played what and who won the round

            //Step5: Update and print player/computer scores

            System.out.println(playerScore + " player score");
            System.out.println(computerScore + " computer score");

    
        }
    }
}