package LeetCode;

import java.util.Arrays;

// Date: 16th October 2018

// Programmer: Sagar Sudhakar

// Difficulty: Easy

// 832. Flipping an Image


/*
Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:

Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Example 2:

Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

Notes:

    1 <= A.length = A[0].length <= 20
    0 <= A[i][j] <= 1

*/




// https://leetcode.com/problems/flipping-an-image/description/

public class FlippingAnImage {

    public static void main(String[] args) {
        int[][] multi = new int[][]{
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        //System.out.println(Arrays.deepToString(invertImage(multi)));
        System.out.println(Arrays.deepToString(flipImage(multi)));

        //int[] rows = multi[1];

        //System.out.println(multi.length);
        //System.out.println(multi[1][1]);
        //System.out.println(Arrays.toString(rows));

        /*
        int arraySize = multi.length;
        for(int i=0;i<arraySize;i++){
            rows = multi[i];
            int rowLength = rows.length;
            for(int j=0; j< rowLength; j++){
                multi[i][j] = 7;
            }
        }

        System.out.println(Arrays.deepToString(multi));

        */
    }

   public static int[][] invertImage(int[][] multi) {

        int arraySize = multi.length;

        for(int i=0;i<arraySize;i++){
            int[] rows = multi[i];
            int rowLength = rows.length;
            for(int j=0; j<rowLength; j++){
               if(multi[i][j]==0){
                   multi[i][j] = 1;
               }else{
                   multi[i][j] = 0;
               }
            }
       }
       return multi;
   }


   // https://leetcode.com/submissions/detail/183195592/

    private static int[][] flipImage(int[][] multi) {

        int arraySize = multi.length;

        for(int i=0;i<arraySize;i++){

            int[] rows = multi[i];
            int rowLength = rows.length;
            int[] flippedInvertedRow = new int[rowLength];

            int counter = 0;

            for(int j=rowLength-1; j>=0;j--){
                int temp = rows[j];
                if(temp==0){
                    flippedInvertedRow[counter] = 1;
                }else{
                    flippedInvertedRow[counter] = 0;
                }
                counter++;
            }
            multi[i]=flippedInvertedRow;
        }
        return multi;
    }

}
