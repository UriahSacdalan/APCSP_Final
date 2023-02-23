import com.sun.tools.javac.Main;

import java.util.Scanner;
import java.util.Random;
/* Needs: selection (if), iteration (loop i.e. for), sequences (put it in order), user-defined methods that call other user-defined methods
*/
public class MainHangman {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static boolean gameStart;
    public static String wordList[] = {"art", "scone", "beef", "bread", "head", "life"}; //List of words
    public static int randomWord = random.nextInt(wordList.length); //randomly choose from list
    public static String word = wordList[randomWord];
    public static char[] letters = wordList[randomWord].toCharArray();
    public static int triesToGuess = letters.length;
    public static char blank[] = new char[triesToGuess];
    public static boolean winner;


    public static void setTrue() {
        gameStart = true;
    }

    public static void setFalse() {
        winner = false;
    }

    public static void print(char array[]) {
        for (int index = 0; index < array.length; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }

    public static void readInput() {
        char guess = scanner.nextLine().charAt(0); //read user input
        if (guess == '-') {
            winner = true;
            gameStart = false;
        } else {
            for (int index = 0; index < letters.length; index++) {
                if (letters[index] == guess) {
                    blank[index] = guess;
                }
            }

            if (didYouWin(blank)) {
                winner = true;
                System.out.println("You got it! Your word was " + word + "!");
            }
        }
    }

    public static boolean didYouWin(char array[]) {
        boolean win = true;
        for (int index = 0; index < array.length; index++) {
            if (array[index] == '_') {
                win = false;
            }
        }
        return win;
    }

    public static void playAgain() {
        if (!winner) {
            System.out.println("Sorry, you're out of tries!");
        }
        System.out.println("Want to try again? (Yes/No)");
        String playAgain = scanner.nextLine();
        if (playAgain.equals("No")) {
            gameStart = false;
        } else if (playAgain.equals("no")) {
            gameStart = false;
        } else if (playAgain.equals("Yes")) {
            gameStart = true;
        } else if (playAgain.equals("yes")) {
            gameStart = true;
        }
    }

    public static void main(String[] args) {
        MainHangman hangman = new MainHangman();

        hangman.setTrue();
        while (gameStart) {
            System.out.println("Guess my word! \n");

            //loop will assign blanks corresponding to letters
            for (int blankLoop = 0; blankLoop < blank.length; blankLoop++) {
                blank[blankLoop] = '_';
            }

            hangman.setFalse();
            int tries = 0;
            while (!winner && tries != triesToGuess) {
                System.out.println("Letters left: "); //Displays letters in word
                print(blank);
                int lives = triesToGuess - tries;
                System.out.printf("You have %d tries left. \n", lives);
                System.out.println("Enter one letter: ");
                tries++;

                hangman.readInput();
            }
            hangman.playAgain();
        }
        System.out.println("Game Over!");
    }
}
