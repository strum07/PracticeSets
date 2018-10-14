package LeetCode;

// Date: 12th October 2018

// Programmer: Sagar Sudhakar

// Difficulty: Hard

// Trapping Rain Water

// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


      //  The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

      //  Example:

      //  Input: [0,1,0,2,1,0,1,3,2,1,2,1]
      //  Output: 6

// https://leetcode.com/problems/trapping-rain-water/description/

// Status: Accepted

// https://leetcode.com/submissions/detail/182561271/

public class TrappingRainWater {


    public static void main(String[] args) {

        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }

    private static int trap(int[] height) {
        int[] waterCapacity = new int[height.length];
        int[] leftEdges = new int[height.length];
        int[] rightEdges = new int[height.length];
        int leftEdge = 0;
        int rightEdge =0;
        int maxArea = 0;


        for(int i=0;i<height.length;i++){
            if(height[i]>leftEdge){
                leftEdge = height[i];
                leftEdges[i] = leftEdge;
            }
            else {
                leftEdges[i] = leftEdge;

            }
        }

        for(int i=height.length-1;i>=0;i--){
            if(height[i]>rightEdge){
                rightEdge = height[i];
                rightEdges[i] = rightEdge;
            }
            else {
                rightEdges[i] = rightEdge;

            }
        }

        for(int i=0;i<height.length;i++){
            waterCapacity[i] = Math.min(leftEdges[i],rightEdges[i])-height[i];
            maxArea+=waterCapacity[i];
        }

        System.out.println(java.util.Arrays.toString(height));
        System.out.println(java.util.Arrays.toString(leftEdges));
        System.out.println(java.util.Arrays.toString(rightEdges));
        System.out.println(java.util.Arrays.toString(waterCapacity));
        System.out.println(maxArea);

        return maxArea;

    }
}
