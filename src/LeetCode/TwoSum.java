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

    private static int[] twoSum(int[] nums, int target) throws IllegalArgumentException {

        HashMap<Integer,Integer> complementMap = new HashMap<>();

        for(int index=0;index<nums.length;index++){

            int complement = (target) - (nums[index]);

            // System.out.println("Iteration: "+index);
            // System.out.println("Target: "+target);
            // System.out.println("Number at Index: "+nums[index]);
            // System.out.println("Complement: "+complement);
            // System.out.println(target+" - "+nums[index]+" = "+complement);
            // System.out.println();

            complementMap.put(complement,index);
        }

        // System.out.println(complementMap.keySet());
        // System.out.println(complementMap.values());

        // {2, 7, 11, 15};
        // [7, 2, -2, -6]

        // [ -2, 2, -6, 7]
        // [ 2, 1, 3, 0]

        for(int index=0;index<nums.length;index++){
            if(complementMap.containsKey(nums[index])){
                if(index != complementMap.get(nums[index])){
                    //System.out.println("In here");
                    return new int[] {index,complementMap.get(nums[index])};
                }
            }
        }

        return nums;
    }

}
