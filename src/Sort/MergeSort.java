package Sort;

/*

MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:
             middle m = (l+r)/2
     2. Call mergeSort for first half:
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)
* */

public class MergeSort {

    public static void main(String[] args) {
        int[] input = {64,25,12,22,11};

        mergeSort(input);

        System.out.println(input);
    }

    private static void mergeSort(int[] input) {
        int length = input.length;
        int start = 0;
        int end = length-1;
        int mid = start+((end-start)/2);

        mergeSort(input,start,mid);
        mergeSort(input,mid+1,end);

        merge(input,start,mid,end);

    }

/*
    private static void mergeSort(int[] input,int start, int end){
        int mid = start+((end-start)/2);

        mergeSort(input,start,mid);
        mergeSort(input,mid+1,end);

        merge(input,start,mid,end);

    }
    */


    private static void merge(int[] input, int start, int mid, int end) {

        int leftSize = (mid-start)+1;
        int rightSize = (end-mid);

        int[] newLeft = new int[leftSize];
        int[] newRight = new int[rightSize];

        System.arraycopy(input, 0, newLeft, 0, leftSize);

        if (rightSize - mid + 1 >= 0) {
            System.arraycopy(input, mid + 1, newRight, mid + 1, rightSize - mid + 1);
        }

        int leftPointer = 0;
        int rightPointer = 0;
        int inputPointer = 0;


        while(leftPointer<leftSize && rightPointer<rightSize){

            if(newLeft[leftPointer]>newRight[rightPointer]){
                input[inputPointer] = newRight[rightPointer];
                rightPointer++;
                inputPointer++;
            }else{
                input[inputPointer] = newLeft[leftPointer];
                leftPointer++;
                inputPointer++;
            }
        }


        while(leftPointer<leftSize){
            input[inputPointer] = newLeft[leftPointer];
            leftPointer++;
            inputPointer++;
        }

        while(rightPointer<rightSize){
            input[inputPointer] = newRight[rightPointer];
            rightPointer++;
            inputPointer++;
        }
    }


}
