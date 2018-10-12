package LeetCode;

// Date: 12th October 2018

// Programmer: Sagar Sudhakar

// Difficulty: Easy

// 1. Two Sum

// https://leetcode.com/problems/two-sum/description/

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

        // You may assume that each input would have exactly one solution, and you may not use the same element twice.

        // Example:

        // Given nums = [2, 7, 11, 15], target = 9,

        // Because nums[0] + nums[1] = 2 + 7 = 9,
        // return [0, 1].

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 8, 7};
        int target = 9;
        System.out.println(java.util.Arrays.toString(twoSum(nums, target)));
    }

    // Status: Accepted
    //Runtime: 4 ms - Beats 99.45% of solutions
    private static int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        HashMap<Integer,Integer> complementMap = new HashMap<>();
        for(int index=0;index<nums.length;index++){
            int complement = (target) - (nums[index]);
            if(complementMap.containsKey(nums[index])){
                if(index != complementMap.get(nums[index])){
                    //System.out.println("In here");
                    return new int[] {complementMap.get(nums[index]),index};
                }
            }
            else{
                complementMap.put(complement,index);
            }
        }
        return nums;
    }
}
