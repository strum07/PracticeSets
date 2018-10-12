package LeetCode;

import java.util.HashMap;

// Date: 12th October 2018

// Programmer: Sagar Sudhakar

// Difficulty: Easy

// 169. Majority Element

// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

      //  You may assume that the array is non-empty and the majority element always exist in the array.

      //  Example 1:

      //  Input: [3,2,3]
      //  Output: 3

      //  Example 2:

      //  Input: [2,2,1,1,1,2,2]
      //  Output: 2



//https://leetcode.com/submissions/detail/182337658/

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums ={2,1,1,1,1,2,2};

        System.out.println(majorityElement(nums));
        System.out.println(majorityVoteMethod(nums));
    }


    // Runtime:  32 ms
    private static int majorityElement(int[] nums) {
        int majorityElement = 0;

        HashMap<Integer,Integer> countOfOccurances = new HashMap<>();

        for(int index=0;index<nums.length;index++){

            countOfOccurances.put(nums[index],countOfOccurances.getOrDefault(nums[index],0)+1);

            if(countOfOccurances.get(nums[index])>(nums.length/2)){
                majorityElement = nums[index];
                return majorityElement;
            }
        }
        throw new IllegalArgumentException();
    }


    // Runtime: 3 ms
    // Lesson: primitive types are always faster
    // Keep it simple

    private static int majorityVoteMethod(int[] nums) {
        int majorityCandidate = -1;
        int count = 0;

        for(int index=0;index<nums.length;index++){
            if(count==0){
                count++;
                majorityCandidate = nums[index];
            }else if(majorityCandidate == nums[index]){
                count++;
            }else{
                count--;
            }
        }
        return majorityCandidate;
    }
}
