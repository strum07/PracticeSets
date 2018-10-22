package Search;


public class BinarySearch {
    public static void main(String[] args) {
        int[] input ={1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(1,input));
        System.out.println(binarySearch(10,input));
        System.out.println(binarySearch(5,input));
        System.out.println(binarySearch(6,input));
        System.out.println(binarySearch(Integer.MAX_VALUE,input));

        // int max = Integer.MAX_VALUE+Integer.MAX_VALUE;
        // System.out.println(Integer.MIN_VALUE);

    }

    private static boolean binarySearch(int key, int[] input) {
        int length = input.length;
        int start = 0;
        int end = length -1;

        return binarySearch(key,start,end,input);
    }

    private static boolean binarySearch(int key, int start, int end, int[] input) {
        //int mid = (start+end)/2;

        // This is done to handle overflow in case (start+end) is bigger than MaxInt

        int mid  = start + (end-start)/2;

        boolean found = false;

        if(start<=end){
            if(key==input[mid]){
                return true;
            }else if(key > input[mid]){
                found = binarySearch(key,mid+1,end,input);
            }else{
                found = binarySearch(key,start,mid-1,input);
            }
        }
        return found;
    }
}
