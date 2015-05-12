package arrays;

/**
 *
 * @author Vasia
 */
public class ReviewSession {
/*
    For loops -> Recursion

Patterns (Iteratively and Recursively)

Exceptions

Interfaces (Comparable, Cloneable)

Abstract Methods/Classes

Reversing an array using recursion

Occurences of a character in a string (iteratively and recursively)

Useful methods from String, Character, Math, Arrays, etc.
    */
    
    public static void printNums(int n){
        for (int i = 0; i <= n; i++)
            System.out.print(i + " ");
    }
    
    public static void printNumsR(int n){
        if (n == 0){
            System.out.print(n + " ");
            return;
        }
        
        System.out.print(n + " ");
        printNumsR(n-1);
    }
    
    
    /*
    
    
    \
    \\\
    \\\\\
    >>>>>>>
    /////
    ///
    /
    
    
    \
    \\\
    >>>>>
    ///
    /
    
    \
    >>>
    /

    */
    
    public static void printSpaceShip(int n){
        //backward slash rows
        for (int i = 0; i < n; i++){
            for (int j = 0; j < (2*i) + 1; j++){
                System.out.print("\\");
            }
            System.out.println("");
        }
        //middle of spaceship
        for (int i = 0; i < (2*n) + 1; i++){
            System.out.print(">");
        }
        System.out.println("");
        
        //forward slash rows
        for (int i = n-1; i >= 0; i--){
            for (int j = 0; j < (2*i) + 1; j++){
                System.out.print("/");
            }
            System.out.println("");
        }
    }
    
    
    
    
    public static void printBackwardSlashes(int n){
        if (n == 0){
            System.out.print("\\");
            return;
        }
        
        System.out.print("\\");
        printBackwardSlashes(n-1);
    }
    
    public static void printMiddle(int n){
        if (n == 0){
            System.out.print(">");
            return;
        }
        
        System.out.print(">");
        printMiddle(n-1);
    }
    
    public static void printForwardSlashes(int n){
        if (n == 0){
            System.out.print("/");
            return;
        }
        
        System.out.print("/");
        printForwardSlashes(n-1);
    }
    
    
    
    
    
    public static void printAllBackSlashes(int n, int index){
        if (index == n)
            return;
        printBackwardSlashes((index)*2);
        System.out.println("");
        printAllBackSlashes(n,index + 1);
    }
    
    public static void printAllForwardSlashes(int n, int index){
        if (index == 0)
            return;
        printForwardSlashes((index-1)*2);
        System.out.println("");
        printAllForwardSlashes(n, index - 1);
    }
    
    public static void printSpaceshipHelper(int n,int section){
        if (section  == 3)
            return;
        if (section == 0)
            printAllBackSlashes(n,0);
        else if (section == 1){
            printMiddle(2*n + 1);
            System.out.println("");
        }
        else printAllForwardSlashes(n,n);
        
        printSpaceshipHelper(n,section +1);
    }
    
    public static void printSpaceShipR(int n){
        printSpaceshipHelper(n,0);
    }
    
    
    
    
    
    
    public static double divide(double a, double b) throws Exception{
        if (b == 0)
            throw new Exception();
        else return a / b; 
    }
    
    public static double useDivide(double a, double b) throws Exception{
        double c = divide(a,b);
        
       
        return c;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static int countUpperCase(String word){
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            //if (Character.isUpperCase(word.charAt(i)))
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
                count++;
        }
        return count;
    }
    
    
    
    
    
    
    
    
    
    
    
    /*
    public static int countUpperCaseRecur(String word){
        if (word.length() == 0)
            return 0;
        
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'){
            return 1 + countUpperCaseRecur(word.substring(1,word.length()));
        }
        else return countUpperCaseRecur(word.substring(1,word.length()));
        
    }
    */
    
    public static int countUpperCaseRecur(String word){
        return countUpperCaseRecurHelper(word,0,0);
    }
    
    public static int countUpperCaseRecurHelper(String word, int index, int count){
        if (index == word.length())
            return count;
        
        if (Character.isUpperCase(word.charAt(index)))
            return countUpperCaseRecurHelper(word,index + 1, count + 1);
        else {
            return countUpperCaseRecurHelper(word,index + 1, count);
        }
    }
    
//    String test = "ABC###DEF###GBHGG###TERTERT";
//    String[] letters = test.split("");
    
    //USEFUL METHODS TO KNOW
    //STRING CLASS
    //indexOf, substring, length(), charAt(), split(), 
    //toUpperCase(), toLowerCase()
    
    //CHARACTER CLASS
    //to use, write Character.methodName();
    //i.e. isUpperCase(char ch), isLowerCase(char ch), isDigit(char ch)
    //Character.isUpperCase('A') -> true
    
    //MATH CLASS
    //Math.sin(double arg), Math.pow(double base, double exp), 
    //Math.random() -> returns a double from [0,1)
    //Math.PI
    
    
    //ARRAYS
    //import java.util.Arrays;
    //int[] x = {5,1,7,3,99,6};
    //Arrays.sort(x);
    //x- > {1,3,5,6,7,99}
    
    //ARRAYLISTS
    //import java.util.ArrayList;
    //import java.util.Collections;
    //ArrayList<Card> cards = new ArrayList<>();
    //assumption here is that Card implements Comparable
    //whatever the parametrized class is has to implement Comparable, i.e.
    // override the compareTo method for this to work
    // 
    //we put a bunch of stuff into cards
    //Collections.sort(cards);
    //
    
    
    
    
    //1-n inclusive, gen(5) = ...{1,2,3,4,5}
    public static int generateRandNumber(int n){
        
        return (int)(Math.random() * n)+ 1;
    }
    
    
    
    
    
    
    
    public static void main(String[]args){
        
        int x =countUpperCaseRecur("AbC");
        System.out.println(x);
        /*
        try{
            useDivide(3,5);
            //code that could throw an exception
        }
        catch(Exception e){
            //executed only if an exception is thrown
        }
        finally{
            //executed no matter what
        }
                */
    }
}
