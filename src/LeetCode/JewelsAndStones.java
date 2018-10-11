package LeetCode;

//Date: 11th October 2018

//Programmer: Sagar Sudhakar

// Difficulty: Easy

// 771. Jewels and

// https://leetcode.com/problems/jewels-and-stones/description/

// You're given strings J representing the types of stones that are jewels, and S representing the stones you have.

// Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

//      The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

//      Example 1:
//      Input: J = "aA", S = "aAAbbbb"
//      Output: 3

//      Example 2:
//      Input: J = "z", S = "ZZ"
//      Output: 0

//      Note:
//      S and J will consist of letters and have length at most 50.
//      The characters in J are distinct.

// Status: Accepted
// Runtime: 16s


import java.util.HashMap;

public class JewelsAndStones {
    public static void main(String[] args) {

        String jewel = "aA";
        String stone = "aAAbbbb";

        String anotherJewel = "z";
        String anotherStone = "ZZ";

        System.out.println(numJewelsInStones(jewel,stone));
        System.out.println(numJewelsInStones(anotherJewel,anotherStone));
    }

    private static int numJewelsInStones(String jewel, String stone) {
        int count = 0;

        HashMap<Character,Integer> countOfStoneOccurances = new HashMap<>();

        for(int i=0;i<stone.length();i++){
            countOfStoneOccurances.put(stone.charAt(i),countOfStoneOccurances.getOrDefault(stone.charAt(i),0)+1);
        }

        for(int i=0;i<jewel.length();i++){
            if(countOfStoneOccurances.containsKey(jewel.charAt(i))){
                count += countOfStoneOccurances.get(jewel.charAt(i));
            }
        }
        return count;
    }

}
