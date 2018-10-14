package LeetCode;

// Date: 13th October 2018

// Programmer: Sagar Sudhakar

// Difficulty: Medium

// 11. Container With Most Water


// Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    //    Note: You may not slant the container and n is at least 2.


    //  The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

    //    Example:
    //    Input: [1,8,6,2,5,4,8,3,7]
    //    Output: 49


// https://leetcode.com/problems/container-with-most-water/description/

// Status: Accepted

// Runtime: 5 ms

// https://leetcode.com/submissions/detail/182604461/

// Classic 2 pointer problem



public class ContainerWithMostWater {


    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));

    }

    private static int maxArea(int[] height) {
        int maxArea = 0;

        int leftPointer = 0;
        int rightPointer = height.length -1;

        if(height.length==0 || height.length < 2){
            return maxArea;
        }

        while(leftPointer<rightPointer) {
            int area = (rightPointer - leftPointer) * Math.min(height[leftPointer], height[rightPointer]);

            maxArea = Math.max(maxArea, area);

            if (height[leftPointer] < height[rightPointer]) {
                leftPointer++;
            } else {
                rightPointer--;
            }
        }
        return maxArea;
    }

}
