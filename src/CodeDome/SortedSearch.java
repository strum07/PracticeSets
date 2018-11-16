package CodeDome;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class SortedSearch {

    public static void main(String[] args) {

        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 4, 5, 7 }, 4));
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 3, 4 }, 4));

        System.out.println(SortedSearch.countNumbersVersion3(new int[] { 1, 3, 5, 7 }, 4));
        System.out.println(SortedSearch.countNumbersVersion3(new int[] { 1, 4, 5, 7 }, 4));
        System.out.println(SortedSearch.countNumbersVersion3(new int[] { 1, 3, 3, 4 }, 4));

    }

    private static int countNumbers(int[] sortedArray, int key) {
        int count = 0;

        for(int x:sortedArray){
            if(x<key){
                count++;

            }else{
                break;
            }
        }
        return count;
    }


    private static int countNumbersVersion2(int[] sortedArray, int key) {
        int length = sortedArray.length;

        if(length<1){
            return 0;
        }

        int count = 0;
        int start = 0;
        int end = length - 1;

        while(start<end){
            start++;
            if(sortedArray[start]<key){
                count++;
            }else{
                break;
            }
        }
        return count+1;
    }



    private static int countNumbersVersion3(int[] sortedArray, int key)
    {
        if(sortedArray.length==0){
            return 0;
        }

        if(key<sortedArray[0]){
            return 0;
        }

        if(key>sortedArray[sortedArray.length-1]){
            return sortedArray.length;
        }

        HashSet<Integer> rangeSet = new HashSet<>();

        int count = 0;
        int start = 0;
        int end = sortedArray.length-1;

        while(start<end){
            int mid= start + (end-start)/2;


            if(sortedArray[mid]<key){
                count = mid;
                start = mid+1;
            }else {
                end = mid-1;
            }
        }

        return count+1;
    }
}
