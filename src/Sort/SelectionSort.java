package Sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {

        int[] input = {64,25,12,22,11};
        selectionSort(input);


    }

    // Selects the smallest element in the array
    // Puts it in the beginning of the array
    // Repeats to the rest of the array after ignoring the start of the array


    private static void selectionSort(int[] input) {

        // int count = 0;

        for(int i=0;i<input.length-1;i++){

            int minCandidate = i;

            for(int j=i+1;j<input.length;j++){

                if(input[minCandidate]>input[j]){
                    minCandidate=j;
                }
            }
            //System.out.println("Iteration: "+(++count));
            //System.out.println("Before Swap: "+Arrays.toString(input));
            swap(i,minCandidate,input);
            //System.out.println("After Swap: "+Arrays.toString(input));
        }

        System.out.println(Arrays.toString(input));

    }

    private static void swap(int chosenCandidate, int minCandidate, int[] input) {
        int temp = input[chosenCandidate];
        input[chosenCandidate] = input[minCandidate];
        input[minCandidate] = temp;
        //System.out.println(Arrays.toString(input));
    }

}
