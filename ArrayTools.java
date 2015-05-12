package arrays;

/**
 *
 * @author Vasia
 */
public class ArrayTools {
    
    static int[] testNums = {65,9340,-3003,20,25};
    static char[] testChars = {'p','T','Q','a','C'};
    static String[] testStrings1 = {"henry","david","will","william","zach","arod","amy","amykate"};
    static String[] testStrings2 = {"15999","containsnonalph@nu33mer||characters", "058373453","56A9DF0"};
    
    static int[][] testMatrix1 = {{5,9,2},{8,3,1},{3,3,2}};
    static int[][] testMatrix2 = {{2,5},{9,8,7,6,5},{1,2,4,3},{0,5,23,45,78,1},{}};
    
    
    
    public static int minIntIter(int[] list){
        int min = list[0];
        for (int i = 1; i < list.length; i++){
            if (list[i] < min)
                min = list[i];
        }
        return min;
    }
    
    
    
    public static int maxIntRecur(int[] list){
        return maxIntRecurHelper(list,0,list[0]);
    }
    
    public static int maxIntRecurHelper(int[] list, int index, int value){
        if (index == list.length)
            return value;
        if (list[index] > value)
            return maxIntRecurHelper(list,index + 1, list[index]);
        else return maxIntRecurHelper(list,index + 1, value);
    }
    
    
    
    public static int[] negativeNumsIter(int[] list){
        //if we want to return a new array that has only the negative numbers of the input array,
        //we first have to count how many negative numbers there are, so we can
        //make a new array of exactly that size
        
        //set int count to 0
        int count = 0;
        //for:each loop - for every integer "num" in list, if num is less than 0, increment count.
        for (int num: list){
            if (num < 0)
                count++;
        }
        
        //make a new array of size count (count = amount of negative #)
        int[] ans = new int[count];
        
        
        //we are going through two arrays, so we'll use i for the input array
        //and indexAns for the answer array
        int indexAns = 0;
        
        //we generate a number i for every index of the input array
        for (int i = 0; i < list.length; i++){
            //if the item at position i in list is negative, add it to the answer array at position indexAns,
            //and then increment indexAns.
            if (list[i] < 0){
                ans[indexAns++] = list[i];
            }
        }
        //return the answer array
        return ans;
    }
    
    public static double averageIter(int[] list){
        int sum = sumIter(list);
        return (double)sum / list.length;
    }
    
    public static int sumIter(int[] list){
        int sum = 0;
        for (int i = 0; i <list.length;i++){
            sum += list[i];
        }
        return sum;
    }
    
    public static double averageRecur(int[] list){
        return averageRecurHelper(list,0,0);
    }
    
    public static double averageRecurHelper(int[] list, int sum, int index){
        if (index == list.length)
            return (double)sum/list.length;
        else return averageRecurHelper(list, list[index] + sum, index + 1);
    }
    
    
    public static int[] doubleCapacity(int[] list){
        //newSize = twice the size of list
        int newSize = list.length * 2;
        int[] newArray = new int[newSize];
        
        //copy over all the elements of list into newArray. 
        //by default an int arrays elements are intialized to zero,
        //so the rest of the space we're not copying over is just zeroes.
        for (int i = 0; i < list.length;i++)
            newArray[i] = list[i];
        
        return newArray;
    }
    
    
    public static int[] reverseArray1(int[] list){
        int[] ans = new int[list.length];
        
        for (int i = list.length - 1; i >= 0; i--){
            ans[list.length - 1 - i] = list[i];
        }
        return ans;
    }
    
    public static int[] reverseArray2(int[] list){
        int[] ans = new int[list.length];
        
        for (int i = 0; i < list.length; i++){
            ans[i] = list[list.length - 1 - i];
        }
        return ans;
    }
    
    
    
    
    
    
    
    
    public static int countUpperCaseIter(char[] list){
        int count = 0;
        for (int i = 0; i < list.length;i++){
            
            //instead of Character.isUpperCase(list[i]),
            //we can have an if statement that says
            //if (list[i] >= 'A' && list[i] <= 'Z')
            //OR an identical if statement
            //if (list[i] >= 65 && list[i] <= 97)
            if (Character.isUpperCase(list[i]))
                count++;
        }
        return count;
    }
    
    public static int countUpperCaseRecur(char[]list){
        return countUpperCaseRecurHelper(list,0,0);
    }
    
    public static int countUpperCaseRecurHelper(char[]list, int index, int count){
        if (index == list.length){
            return count;
        }
        if (Character.isUpperCase(list[index]))
            return countUpperCaseRecurHelper(list,index + 1, count + 1);
        else return countUpperCaseRecurHelper(list,index + 1,count);
    }
    
    
    //similar to finding the min,max of an int array.
    public static String firstAlphabetically(String[] list){
        String first = list[0];
        for (int i = 1; i < list.length; i++){
            first = compareStrings(first,list[i]);
        }
        return first;
    }
    
    //returns string that comes first in dictionary
    public static String compareStrings(String a, String b){
        //determine shorter string
        String shorterString = (a.length() > b.length()) ? b : a;
        
        
        for (int i = 0; i < shorterString.length(); i++){
            //if the current letter in word a comes before the current letter in word b, word a is first
            if (a.charAt(i) < b.charAt(i))
                return a;
            //if the current letter in word b comes before the current letter in word a, word b is first
            if (a.charAt(i) > b.charAt(i))
                return b;
            
            //if we continue iterating through the for loop, that means that the current letters were the same
        }
        //if we make it here, that means that the shorter string is a substring of the larger string 
        // (i.e. "will" and "william"), and then we want the shorter word to come first in the dictionary
        // (look at a dictionary) and so return the shorterString.
        return shorterString;
    }
    
    
    
    public static int toHex(String hex) throws IllegalArgumentException{
        //value is the int variable to which we will add onto as we parse the string
        int value = 0;
        
        //for every character in the string
        for (int i = 0; i < hex.length(); i++){
            
            //set char c = the current character, makes our life easier
            //by not having to call hex.charAt(i) each time (less typing/writing)
            char c = hex.charAt(i);
            
            //if the character c is in the range 0-9
            if (c >= '0' && c <= '9'){
                //c - '0' will equal the number represented by the character (not its character code)
                //so '2' - '0' = 2, '5' - '0' = 5, etc..
                
                //alternatively, you could do c - 48 (because 48 is the character code for '0')
                //and you would get the same result
                
                //Math.pow(16,hex.length() - 1 - i) returns the power of 16 we want to multiply the value of c by
                //To understand this, imagine we have a simple Base10 (decimal) number, 354.
                //1354 = (1*10^3) + (3 * 10^2) + (5 * 10^1) + (4 * 10^0)
                //1354 = (1*1000) + (3*100) + (5*10) + (4*1)
                //1354 = 1000 + 300 + 50 + 4
                //similarly, in other bases we just use whatever the base is, in this case 16.
                //so 1354 (base 16) is
                //0x1354 = (1*16^3) + (3 * 16^2) + (5 * 16^1) + (4 * 16^0)
                //0x1354 = (1*4096) + (3*256) + (5*16) + (4*1)
                //0x1354 = (4096) + (768) + (80) + 4 = 4948(base10)
                
                //what does hex.length() -1 - i mean?
                //if our string is "1354", its length is 4. the exponents we need are
                // 3,2,1,0 as we go through the string from left to right
                //our variable i is going from 0,1,2,3 (0 -> hex.length() -1)
                //so if we want 3,2,1,0, then just subtract i from hex.length() and 
                //subtract 1 again (because strings are zero-indexed)
                value += (c-'0')*(int)Math.pow(16,hex.length() - 1 - i);
            }
            
            //if c is in the range A-F, subtract the character code for A, then add 10,
            //because A = 10, B = 11, ..., F = 15.
            //'A' = 65, 65 - 65 = 0, 0 + 10 = 10
            //...
            //'F' = 70, 70 - 65 = 5, 5 + 10 = 15
            else if (c >= 'A' && c <= 'F'){
                value += (c-'A' + 10)*(int)Math.pow(16,hex.length() - 1 - i);
            }
            
            
            //if c is not in the range 0-9 or A-F then an inappropriate string was fed in,
            // throw a new IllegalArgumentException
                
            else
                throw new IllegalArgumentException();
        }
        return value;
    }
    
    //convert from any base ranging from base 2 to base 36
    public static int toBase10(String num, int base){
        
        //this method only accepts bases 2 to 36
        if (base < 2 || base > 36)
            throw new IllegalArgumentException();
        
        
        int value = 0;
        
        for (int i = 0; i < num.length(); i++){
            
            char c = num.charAt(i);
            
            if (c >= '0' && c <= '9'){
                
                
                //if the value represented by the character is greater than the base, inappropriate string, throw Exception
                //for example, the number "543" cannot exist in base 2.
                //the number "10QDS" cannot exist in base 16.
                //the number "ABCDXYZ" can exist in base 36, but not in bases 2-35.
                //the number "189ABC" can exist in base 13, but not bases 2-12.
                //base 1 exists but it is equivalent to counting on your fingers or tallying.
                if (c-'0' >= base)
                    throw new IllegalArgumentException();
                
                value += (c-'0')*(int)Math.pow(base,num.length() - 1 - i);
            }
            
            else if (c >= 'A' && c <= 'Z'){
                
                //check to make sure value is acceptable in the base again
                if (c-'A'  + 10>= base)
                    throw new IllegalArgumentException();
                
                value += (c-'A' + 10)*(int)Math.pow(base,num.length() - 1 - i);
            }
            else
                throw new IllegalArgumentException();
        }
        return value;
    }
    
    
    //dont assume matrix is square!
    public static int sumOfMatrix(int[][] mat){
        int sum = 0;
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                sum += mat[i][j];
            }
        }
        return sum;
    }
    
    
    
    
    
    public static void main(String[]args){
        System.out.println(toBase10("ZZZ",37));
    }

}
