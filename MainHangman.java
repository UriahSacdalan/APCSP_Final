import java.util.Scanner;
import java.util.Random;
/* Needs: selection (if), iteration (loop i.e. for), sequences (put it in order), user-defined methods that call other user-defined methods
*/
public class MainHangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random testRand = new Random();

        String wordList[] = {"art", "scone", "beef", "bread", "home", "life"}; //List of words

        boolean gameStart = true;
        while (gameStart) {
            System.out.println("Guess my word! \n");
            int randomWord = testRand.nextInt(wordList.length); //randomly choose from list
            char[] letters = wordList[randomWord].toCharArray(); //make letters individual characters
            int triesToGuess = letters.length; //# of Tries
            char blank[] = new char[triesToGuess]; //used as a container for letters

            //loop will assign blanks corresponding to letters
            for (int blankLoop = 0; blankLoop < blank.length; blankLoop++) {
                blank[blankLoop] = '_';
            }
            /*boolean winner = false;
            int tries = 0;
            while (!winner && tries != triesToGuess) {
                System.out.print("Letters left: "); //Displays letters in word
                System.out.println(blank);

                int lettersRemain = triesToGuess-tries;
                System.out.println("You have " + lettersRemain + " letters left. \n");

                System.out.print("Enter one letter: ");
                char guess = scanner.next().charAt(0); //read user input
                if (guess == '_') {
                    winner = true;
                    gameStart = false;
                }
                else{
                    for(int index = 0; index < letters.length; index++){
                        if(letters[index] == guess){
                            blank[index] = guess;
                        }
                    }
                }
            }*/
        }
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