package LeetCode;

// https://leetcode.com/problems/single-number/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        int[] input ={2,1,2};

        //System.out.println(singleNumber(input));
        //System.out.println(singleNumber1(input));

        System.out.println(singleNumber2(input));
    }

    private static int singleNumber(int[] input) {
        int outlier = -1;
        HashMap<Integer,Integer> counts = new HashMap<>();
        int size = input.length;
        for(int i=0;i<size;i++){
            counts.put(input[i],counts.getOrDefault(input[i],0)+1);
        }

        return outlier;
    }

    private static int singleNumber1(int[] A) {

        Set<Integer> s = new HashSet<Integer>();
        for (int i: A){
            if(!s.add(i)){
                s.remove(i);
            }
        }
        return s.iterator().next();

    }


    private static int singleNumber2(int A[]) {
        int result = 0;
        int iteration = 0;
        int size = A.length;
        for (int i = 0; i<size; i++)
        {
            System.out.println("Iteration: "+iteration++);
            System.out.println("Before : "+result);
            System.out.println("Number : "+A[i]);
            result ^=A[i];
            System.out.println("After : "+result);
        }
        return result;
    }


}
