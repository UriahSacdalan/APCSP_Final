import com.sun.tools.javac.Main;

import java.util.Scanner;
import java.util.Random;
/* Needs: selection (if), iteration (loop i.e. for), sequences (put it in order), user-defined methods that call other user-defined methods
*/
public class MainHangman {
    public static Scanner scanner = new Scanner(System.in);
    public static boolean gameStart;
    public static boolean winner;

    public static void setTrue(){
        gameStart = true;
    }
    public static void setFalse(){
        winner = false;
    }

    public static void playAgain(){
        if(!winner){
            System.out.println("Sorry, you're out of tries!");
        }
        System.out.println("Want to try again? (Yes/No)");
        String playAgain = scanner.nextLine();
        if (playAgain.equals("No")){
            gameStart = false;
        }
        else if (playAgain.equals("Yes")){
            gameStart = true;
        }
    }

    public static void main(String[] args){
        MainHangman hangman = new MainHangman();

        Random random = new Random();

        String wordList[] = {"art", "scone", "beef", "bread", "home", "life"}; //List of words

        hangman.setTrue();
        while (gameStart) {
            System.out.println("Guess my word! \n");
            int randomWord = random.nextInt(wordList.length); //randomly choose from list
            String word = wordList[randomWord];
            char[] letters = wordList[randomWord].toCharArray(); //make letters individual characters(?)
            int triesToGuess = letters.length; //# of Tries; for loop ineffective... maybe?? I DONT KNOWWW
            char blank[] = new char[triesToGuess]; //used as a container for letters

            //loop will assign blanks corresponding to letters
            for (int blankLoop = 0; blankLoop < blank.length; blankLoop++) {
                blank[blankLoop] = '_';
            }

            hangman.setFalse();
            int tries = 0;
            while(!winner && tries != triesToGuess){
                System.out.println("Letters left: "); //Displays letters in word
                print(blank);
                int lives = triesToGuess-tries;
                System.out.printf("You have %d tries left. \n", lives);
                System.out.println("Enter one letter: ");

                char guess = scanner.nextLine().charAt(0); //read user input
                tries++;

                if(guess == '-'){
                    winner = true;
                    gameStart = false;
                } else{
                    for(int index = 0; index < letters.length; index++){
                        if(letters[index] == guess){
                            blank[index] = guess;
                        }
                    }

                    if(didYouWin(blank)){
                        winner = true;
                        System.out.println("You got it! Your word was " + word + "!");
                    }
                }
            }
            hangman.playAgain();
        }
        System.out.println("Game Over!");
    }
    public static void print(char array[]){
        for(int index = 0; index < array.length; index++){
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }

    public static boolean didYouWin(char array[]){
        boolean win = true;
        for(int index = 0; index < array.length; index++){
            if(array[index] == '_'){
                win = false;
            }
        }
        return win;
    }
}
