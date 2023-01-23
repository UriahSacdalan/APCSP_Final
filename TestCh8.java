import java.awt.*;

public class TestCh8 {
    public static void main(String[] args){
        stringObjects();
        methodLength();
        substrings();
    }

    public static void stringObjects(){
        String test1 = "Tango";
        System.out.println("Test 1: " + test1);

        String test2 = new String();
        test2 = "Tango";
        System.out.println("Test 2: " + test2);

        String test3 = new String("Tango");
        System.out.println("Test 3: " + test3);

        String test4 = new String(test3);
        System.out.println("Test 4: " + test4);

        System.out.println();
    }

    public static void methodLength(){
        //method length returns the # of characters in the String object.
        String test1 = "Argentine";
        String test2 = "Tango";
        String test3 = test1 + " " + test2;
        System.out.println((test1 + " has " + test1.length() + " characters."));
        System.out.println(test2 + " has " + test2.length() + " characters.");
        System.out.println(test3 + " has " + test3.length() + " characters.");
        System.out.println();
    }

    public static void substrings(){
        //First substring method uses 2 params: 1 to show index of starting letter, and another to
        //show the end of the substring, NOT THE INDEX OF THE LAST; NON-INCLUSIVE
        //if test1.substring(j,k): start at index j, end at index k-1
        String test1 = "Racecar";
        System.out.println(test1.substring(0,4));
        System.out.println(test1.substring(1,4));
        System.out.println(test1.substring(2,4));
        System.out.println();

        //Second substring method uses only 1 param: This method loops through the string and always
        //goes to the end of the string. First loop uses one param, 2nd uses 2
        String test2 = "Racecar";
        int length = test2.length();
        for(int index = 0; index < length; index++){
            System.out.println(test2.substring(index));
        }
        System.out.println();
        //Loop uses index & length as parameters because length of a string = index + 1
        for(int index = 0; index < length; index++){
            System.out.println(test2.substring(index,length));
        }
    }
}


