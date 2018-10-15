package LeetCode;
// Date: 15th October 2018

// Programmer: Sagar Sudhakar

// Difficulty: Easy

// 344. Reverse String

/*
*
*
Write a function that takes a string as input and returns the string reversed.

Example 1:

Input: "hello"
Output: "olleh"

Example 2:

Input: "A man, a plan, a canal: Panama"
Output: "amanaP :lanac a ,nalp a ,nam A"
*
*
* */



public class ReverseString {
    public static void main(String[] args) {
        String inputString = "A man, a plan, a canal: Panama";
        System.out.println(inputString);
        System.out.println(reverseString(inputString));
        System.out.println(reverseString1(inputString));
        System.out.println(reverseString2(inputString));
    }

    //This is ridiculously slow = 1018 ms
    private static String reverseString(String inputString) {

        String reversed = "";

        int length = inputString.length();

        for(int i=length-1;i>=0;i--){
            reversed = reversed.concat(String.valueOf(inputString.charAt(i)));
        }

        return reversed;
    }

    //This is fast = 3 ms
    private static String reverseString1(String inputString) {

        StringBuilder reversed = new StringBuilder();

        int length = inputString.length();

        for(int i=length-1;i>=0;i--){
            reversed = reversed.append(inputString.charAt(i));
        }

        return reversed.toString();
    }

    // This is Fast = 3 ms
    // https://leetcode.com/submissions/detail/183013573/
    private static String reverseString2(String inputString) {

        StringBuilder reversed = new StringBuilder();

        StringBuilder input = new StringBuilder(inputString);

        int length = input.length();

        for(int i=length-1;i>=0;i--){
            reversed = reversed.append(input.charAt(i));
        }

        return reversed.toString();
    }
}
