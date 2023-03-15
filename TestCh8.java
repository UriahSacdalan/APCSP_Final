import java.util.Scanner;
public class TestCh8 {
    public static void main(String[] args){
        //Initializing input
        Scanner input = new Scanner(System.in);
        System.out.print("Input any character: ");

        //Using next().charAt(0) to Accept Char Input
        char a = input.next().charAt(0);

        //Printing the Contents of 'a'
        System.out.println("The Variable A Contains the Following Data: " + a);

    }
}


