package LeetCode;

// Date: 12th October 2018

// Programmer: Sagar Sudhakar

// Difficulty: Easy

// 169. Majority Element

// Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

       // Note: You may not slant the container and n is at least 2.



        // The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.


// https://leetcode.com/problems/container-with-most-water/description/

public class ContainerWithMostWater {


    public static void main(String[] args) {


        int[] height = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxArea(height));

    }

    private static int maxArea(int[] height) {
        int area = 0;

        int leftEdge = 0;
        int rightEdge = 0;
        int width=0;

        for(int i=0;i<height.length;i++){
            if(width==0){
                leftEdge = height[i];
                rightEdge = height[i+1];
                width++;
                area = leftEdge*rightEdge*width;
            }else{
                if(height[i+1]>rightEdge && rightEdge > leftEdge){
                    rightEdge = height[i+1];
                    leftEdge = height[i];
                    area = leftEdge*rightEdge*width;
                }
            }

        }

        return area;

    }


}
