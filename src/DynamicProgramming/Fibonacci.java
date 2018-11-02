package DynamicProgramming;

import java.util.HashMap;

public class Fibonacci {
    public static void main(String[] args) {
        HashMap<Integer,Long> memo = new HashMap<>(1000);

        for(int i=0;i<=1000;i++){
            System.out.println(i+" : "+fib(i,memo));
        }
    }

    private static long fib(int n, HashMap<Integer,Long> memo) {

       if(memo.containsKey(n)){
           return memo.get(n);
       }

       if(n==0 || n==1){
           memo.putIfAbsent(n,(long)1);
           return 1;
       }

       else{
           memo.put(n-1, fib(n-1,memo));
           memo.put(n-2, fib(n-2,memo));
       }
       return memo.get(n-1)+memo.get(n-2);

    }
}
