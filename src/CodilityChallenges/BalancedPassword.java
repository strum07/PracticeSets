package CodilityChallenges;

// Date: 10th October 2018

// Programmer: Sagar Sudhakar

// A string is balanced if it consists of exactly two different characters and both of those characters appear exactly the same number of times.

// For example: "aabbab" is balanced (both 'a' and 'b' occur three times) but "aabba" is not balanced ('a' occurs three times, 'b' occurs two times).

// String "aabbcc" is also not balanced (it contains three different letters).

// A substring of string S is a string that consists of consecutive letters in S. For example: "ompu" is a substring of "computer" but "cmptr" is not.

// Write a function solution that, given a string S, returns the length of the longest balanced substring of S.

// Examples:

// 1. Given S = "cabbacc", the function should return 4 ("abba" is the longest balanced substring).

// 2. Given S = "abababa", the function should return 6 ("ababab" and "bababa" are the longest balanced substrings).

// 3. Given S = "aaaaaaa", the function should return 0 (S does not contain a balanced substring).

// Write an efficient algorithm for the following assumptions:

// N is an integer within the range [1..100,000]; - Never understood what 'N' is!

// String S consists only of lowercase letters (a−z).

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

        for(int currentIndex=0;currentIndex<string.length();currentIndex++){

            if(bufferNotFull(characterBuffer)){

                // If this character is not present
                if(!characterBuffer.contains(string.charAt(currentIndex))){
                    // Add character to buffer
                    characterBuffer.add(string.charAt(currentIndex));
                }
            }
            // If the buffer size is equal to 2 (never will it be more than 2 as we clear the contents when it = 2 and character is not present)
            else{

                // If this character is not present
                if(!characterBuffer.contains(string.charAt(currentIndex))){

                    // Clear contents of the list
                    characterBuffer.clear();

                    // Add previous character - to tail by default - becomes current head
                    characterBuffer.add(string.charAt(previousCharTo(currentIndex)));

                    // Add new character to list - to tail by default - current tail
                    characterBuffer.add(string.charAt(currentIndex));

                    // Clear contents of count
                    characterCount.clear();

                    // Reinitialize count of previous character to 1
                    characterCount.put(string.charAt(previousCharTo(currentIndex)),1);
                }
            }

            // Also the below section is by logic the common steps no matter how the if condition forks -
            // As we want to increment count of the character in the current index and also check if the new substring under observation is of maxlength

            // Increment count of current character
            characterCount.put(string.charAt(currentIndex),characterCount.getOrDefault(string.charAt(currentIndex),0)+1);

            // Check the current state of affairs - use the buffer and count of characters to see if we have a new maxlength substring each iteration
            // If found, set max length to newly found/formed substring
            maxLength = Math.max(maxLength,lengthIfBalanced(characterBuffer,characterCount));
        }
        return maxLength;
    }

    private static int previousCharTo(int currentIndex) {
        // Might be an overkill - But readable now and eliminating magic numbers
        return currentIndex-1;
    }

    private static boolean bufferNotFull(LinkedList<Character> characterBuffer) {
        // If the buffer size is empty OR
        // If the buffer size is less than 2.
        return characterBuffer.size()<2;
    }

    private static int lengthIfBalanced(LinkedList<Character> characterBuffer, HashMap<Character, Integer> characterCount) {
        return (isValid(characterBuffer) && isBalanced(characterBuffer, characterCount)) ?  getLengthOfSubString(characterBuffer, characterCount) : 0;
    }

    private static boolean isValid(LinkedList<Character> characterBuffer) {
        // A string is valid if its constituents are made up of two characters
        return characterBuffer.size()==2;
    }

    private static int getLengthOfSubString(LinkedList<Character> characterBuffer, HashMap<Character, Integer> characterCount) {
        // Initialize length to the number of occurrences - (2*occurrences of char a(or b))
        return characterCount.get(characterBuffer.getFirst())+characterCount.get(characterBuffer.getLast());
    }

    private static boolean isBalanced(LinkedList<Character> characterBuffer, HashMap<Character, Integer> characterCount) {
        // A string is balanced if its constituents are made up of two characters and made up of two characters that have equal occurrences
        return characterCount.get(characterBuffer.getFirst()).equals(characterCount.get(characterBuffer.getLast()));
    }
}
