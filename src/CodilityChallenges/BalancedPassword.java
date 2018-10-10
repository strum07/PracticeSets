package CodilityChallenges;


//until new character is encountered -
//increment count of the characters in the buffer
//store their startindex and end index



//as soon as you encounter a new character
//check if the counts of the two chars in the buffer match
//if they do (check if the length of substring (min(countofoccurences)*2) against previously stored value of current previous Maxlength and store tt there


//start index = last index
//last index = current index

//chars in buffer = char in startindex and char in currentIndex

//trick is to store all balanced substrings as you see them
//if not the substrings
//atleast the length of the substrings
//is it balanced after every iteration in the sliding window

//previous substring length = 0
//current substring = length = 0

//cabbacc
//a
// Get the first character
// Remember it and increment count

//b
// get the next character
// remember it and increment its count

//c
//We have not seen this char before
//remember it and increment the count
//store the first index as


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


import java.util.ArrayList;
import java.util.HashMap;

public class BalancedPassword {

    public static void main(String[] args) {

        String S1 = "cabbacc";
        String S2 = "abababa";
        String S3 = "aaaaaaa";
        String S4 = "baaab";

        System.out.println(longestBalancedPasswordLength(S1));
        System.out.println(longestBalancedPasswordLength(S2));
        System.out.println(longestBalancedPasswordLength(S3));
        System.out.println(longestBalancedPasswordLength(S4));

    }

    public static int longestBalancedPasswordLength(String string){

        int maxLength = 0;

        ArrayList<Character> characterBuffer = new ArrayList<>(2);

        HashMap<Character,Integer> countofCharacters = new HashMap<>();
        HashMap<Character,Integer> startIndex = new HashMap<>();

        //initialize the start index
        startIndex.put(string.charAt(0),0);

        HashMap<Character,Integer> endIndex = new HashMap<>();


        for(int i=0;i<string.length();i++){
            if(characterBuffer.size()<3){
                if(!characterBuffer.contains(string.charAt(i))){
                    characterBuffer.add(string.charAt(i));
                }
            }
            else{
                //REMOVE HEAD
                characterBuffer.remove(0);
                startIndex.put(string.charAt(i-1),i-1);
            }
            endIndex.put(string.charAt(i),i);
            countofCharacters.put(string.charAt(i),countofCharacters.getOrDefault(string.charAt(i),0)+1);

            if(lengthIfBalanced(characterBuffer,countofCharacters)>maxLength){
                maxLength = lengthIfBalanced(characterBuffer,countofCharacters);
            }
        }
        return maxLength;
    }

    private static int lengthIfBalanced(ArrayList<Character> characterBuffer, HashMap<Character, Integer> countofCharacters) {
        int length = 0;

        if(characterBuffer.size()==2){
            Character a = characterBuffer.get(0);
            Character b = characterBuffer.get(1);
            Integer countA = countofCharacters.get(a);
            Integer countB = countofCharacters.get(b);
            if(countA.equals(countB)){
                length = countA+countB;
            }
        }

        return length;
    }

}
