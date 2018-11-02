package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = {1,2,5};

        int total = 12;

        System.out.println(makeChange(coins,total));
    }

    private static int makeChange(int[] coins, int total) {
        int totalWays = 0;

        int[] numberOfWays = new int[total+1];
        System.out.println(Arrays.toString(numberOfWays));

        numberOfWays[0] = 1;

        for (int i=1;i<coins.length;i++) {

            for(int j=coins[i];j<totalWays+1;j++){

                    numberOfWays[i] = numberOfWays[i] + (numberOfWays[i-coins[i]]);

            }
        }

        System.out.println(Arrays.toString(numberOfWays));

        totalWays = numberOfWays[total];

        return totalWays;
    }
}
