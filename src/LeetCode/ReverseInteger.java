package LeetCode;

// Date: 13th October 2018

// Programmer: Sagar Sudhakar

// Difficulty: Medium

// 7. Reverse Integer

// 9. Palindrome Number

// https://leetcode.com/problems/reverse-integer/description/

// https://leetcode.com/problems/palindrome-number/description/

// Status:

// Runtime: 22 ms

// https://leetcode.com/submissions/detail/182636817/

// https://leetcode.com/submissions/detail/182639800/

// Given a 32-bit signed integer, reverse digits of an integer.

   //      Example 1:

   //     Input: 123
   //     Output: 321

   //     Example 2:

   //     Input: -123
   //     Output: -321

   //     Example 3:

   //     Input: 120
   //     Output: 21

   //     Note:
   //     Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


public class ReverseInteger {


    public static void main(String[] args) {

        int a = 123;

        int b = -123;

        int c = 120;


        System.out.println(reverse(a));
        System.out.println(reverse(b));
        System.out.println(reverse(c));

        System.out.println(isPalindrome(b));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(111));

    }

    private static int reverse(int number) {
        long result =0;
        while(number != 0)
        {
            result = (result*10) + (number%10);
            if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
            number = number/10;
        }
        return (int)result;
    }


    private static boolean isPalindrome(int x) {
        boolean state = false;

        if(x<0){
            state = false;
        }
        else if (x == reverse(x)) {
            state = true;
        }

        return state;
    }

}
