package DynamicProgramming;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = {1,2,5};

        int total = 12;

        System.out.println(makeChange(coins,total));
    }

    private static int makeChange(int[] coins, int total) {
        int ways = 0;

        int[] numberOfWays = new int[total+1];



        return ways;
    }
}
