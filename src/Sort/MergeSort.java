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

        mergeSort(input,0,input.length-1);

        System.out.println(input);
    }

    private static void mergeSort(int[] input,int start, int end) {
        int length = input.length;

        int mid = start+((end-start)/2);

        if(end-start < 2){
            return;
        }else{
            mergeSort(input,start,mid);
            mergeSort(input,mid+1,end);
            merge(input,start,mid,end);
        }



    }


    private static void merge(int[] input, int start, int mid, int end) {

        int leftSize = (mid-start)+1;
        int rightSize = (end-mid);

        int[] newLeft = new int[leftSize];
        int[] newRight = new int[rightSize];


        if (mid-start >= 0){
            for(int i=start;i<=mid;i++){
                newLeft[i]=input[i];
            }
        }

        if (rightSize - mid + 1 >= 0) {
            for(int i=mid+1;i<=end;i++){
                newRight[i]=input[i];
            }
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
