package EPI_Prep.Arrays;

// https://leetcode.com/problems/sort-colors/


/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Follow up:

    A rather straight forward solution is a two-pass algorithm using counting sort.
    First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
    Could you come up with a one-pass algorithm using only constant space?


* */

import java.util.Arrays;

public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] input ={2,0,1};

        sortColors(input);

        System.out.println(Arrays.toString(input));
    }

    public static  void sortColors(int[] nums) {

        int start = 0;
        int end = nums.length-1;

        while(start<end){
            if(nums[start]==2){
                int temp = nums[end];
                nums[end] =  nums[start];
                nums[start] = temp;
                start++;
                end--;
            }else if(nums[start]==0){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }
}
