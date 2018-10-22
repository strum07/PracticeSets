package LeetCode;

// https://leetcode.com/problems/fizz-buzz/

// Runtime: 3 ms, faster than 52.16% of Java online submissions for Fizz Buzz.

// https://leetcode.com/submissions/detail/184303542/



import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        int n=15;
        System.out.println(fizzBuzz(n));
    }

    private static List<String> fizzBuzz(int n) {

        List<String> processed = new ArrayList<>();

        for(int counter=1;counter<=n;counter++){
            if(counter%3==0 && counter%5==0){
               processed.add("FizzBuzz");
            }else if(counter%5==0){
                processed.add("Buzz");
            }else if(counter%3==0){
                processed.add("Fizz");
            }
            else{
                processed.add(String.valueOf(counter));
            }
        }
        return processed;
    }
}
