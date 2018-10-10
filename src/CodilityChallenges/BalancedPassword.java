package CodilityChallenges;

//A string is balanced if it consists of exactly two different characters and both of those characters appear exactly the same number of times. For example: "aabbab" is balanced (both 'a' and 'b' occur three times) but "aabba" is not balanced ('a' occurs three times, 'b' occurs two times). String "aabbcc" is also not balanced (it contains three different letters).

//A substring of string S is a string that consists of consecutive letters in S. For example: "ompu" is a substring of "computer" but "cmptr" is not.

//Write a function solution that, given a string S, returns the length of the longest balanced substring of S.

//Examples:

//1. Given S = "cabbacc", the function should return 4 ("abba" is the longest balanced substring).

//2. Given S = "abababa", the function should return 6 ("ababab" and "bababa" are the longest balanced substrings).

//3. Given S = "aaaaaaa", the function should return 0 (S does not contain a balanced substring).

//Write an efficient algorithm for the following assumptions:

//N is an integer within the range [1..100,000];
//string S consists only of lowercase letters (a−z).

import java.util.HashMap;
import java.util.LinkedList;

public class BalancedPassword {

    public static void main(String[] args) {

        String S1 = "cabbacc";
        String S2 = "abababa";
        String S3 = "aaaaaaa";
        String S4 = "BAAAB";
        String S5 = "aabbcc";
        String S6 = "aabbab";

        System.out.println(longestBalancedPasswordLength(S1));
        System.out.println(longestBalancedPasswordLength(S2));
        System.out.println(longestBalancedPasswordLength(S3));
        System.out.println(longestBalancedPasswordLength(S4));
        System.out.println(longestBalancedPasswordLength(S5));
        System.out.println(longestBalancedPasswordLength(S6));
    }

    private static int longestBalancedPasswordLength(String S){

        StringBuilder string = new StringBuilder(S.toLowerCase());

        int maxLength = 0;

        LinkedList<Character> characterBuffer = new LinkedList<>();

        HashMap<Character,Integer> characterCount = new HashMap<>();

        for(int i=0;i<string.length();i++){

            //if the buffer size is empty OR
            //if the buffer size is less than 2
            if(characterBuffer.size()<2){

                //if this character is not present
                if(!characterBuffer.contains(string.charAt(i))){

                    //add character to buffer
                    characterBuffer.add(string.charAt(i));
                }
            }
            //if the buffer size is equal to 2 or more
            else{

                //if this character is not present
                if(!characterBuffer.contains(string.charAt(i))){

                    //clear contents of the list
                    characterBuffer.clear();

                    //add previous character - to tail by default - becomes new head
                    characterBuffer.add(string.charAt(i-1));

                    //add new character to list - to tail by default
                    characterBuffer.add(string.charAt(i));

                    //Clear contents of count
                    characterCount.clear();

                    //reinitialize count of previous character to 1
                    characterCount.put(string.charAt(i-1),1);
                }
            }

            //increment count of current character
            characterCount.put(string.charAt(i),characterCount.getOrDefault(string.charAt(i),0)+1);

            //check the current state of affairs - use the buffer and count of characters to see if we have a new maxlength substring each iteration
            if(lengthIfBalanced(characterBuffer,characterCount)>maxLength){

                //if found, set max length to newly found/formed substring
                maxLength = lengthIfBalanced(characterBuffer,characterCount);
            }
        }
        return maxLength;
    }

    private static int lengthIfBalanced(LinkedList<Character> characterBuffer, HashMap<Character, Integer> characterCount) {
        int length = 0;

        if(characterBuffer.size()==2){
            Character a = characterBuffer.getFirst();
            Character b = characterBuffer.getLast();

            Integer countA = characterCount.get(a);
            Integer countB = characterCount.get(b);

            if(countA.equals(countB)){
                length = countA+countB;
            }
        }
        return length;
    }
}