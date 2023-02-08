import java.util.Scanner;
import java.util.Random;
/* Needs: selection (if), iteration (loop i.e. for), sequences (put it in order), user-defined methods that call other user-defined methods
*/
public class MainHangman {
    /*public static void main(String[] args)
    {
        Random testRand = new Random();
        String wordList[] = {"art", "scone", "beef", "bread", "home", "life"}; //List of words
        int randomWord = testRand.nextInt(wordList.length); //randomly choose from list

        Scanner input = new Scanner(System.in);
        for(int tries = 6; tries > 0; tries--) {
            System.out.println("Tries left: " + tries); //Displays # of tries
            System.out.print("Enter guess: ");
            String guess = input.nextLine(); //read user input
            if (guess.equals(wordList[randomWord]))
                System.out.println("Correct! Your word was: " + guess); //Output user input
            else {
                System.out.println("That is not a valid guess. Try again!");
            }
        }
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random testRand = new Random();

        String wordList[] = {"art", "scone", "beef", "bread", "home", "life"}; //List of words


        boolean gameStart = true;
        while (gameStart) {
            System.out.println("Guess my word! \n");
            int randomWord = testRand.nextInt(wordList.length); //randomly choose from list
            char[] letters = wordList[randomWord].toCharArray(); //make letters individual characters(?)
            int triesToGuess = letters.length; //# of Tries; for loop ineffective... maybe?? I DONT KNOWWW
            char blank[] = new char[triesToGuess]; //used as a container for letters

            //loop will assign blanks corresponding to letters
            for (int blankLoop = 0; blankLoop < blank.length; blankLoop++) {
                blank[blankLoop] = '_';
            }
            boolean winner = false;
            int tries = 0;
            while (!winner && tries != triesToGuess) {
                System.out.print("Letters left: "); //Displays letters in word
                System.out.println(blank);

                int lives = triesToGuess-tries;
                System.out.println("You have " + lives + " letters left. \n");

                System.out.print("Enter one letter: ");
                char guess = scanner.next().charAt(0); //read user input
                if (guess == '_') {
                    winner = true;
                    gameStart = false;
                }
                else{
                    System.out.println("Input: " + guess);
                }
                /*    System.out.println("Correct! Your word was: " + guess); //Output user input
                else {
                    System.out.println("That is not a valid guess. Try again!");
                }*/

            }
        }
    }
}