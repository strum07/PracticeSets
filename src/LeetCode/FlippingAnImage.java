package LeetCode;

import java.util.Arrays;

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
