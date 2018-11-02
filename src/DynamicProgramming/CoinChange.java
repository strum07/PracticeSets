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

        for (int i=1;i<numberOfWays.length;i++) {

            for(int coin:coins){

                if(numberOfWays[i]<=coin){



                    numberOfWays[i] = numberOfWays[i] + (numberOfWays[i-coin]);

                }

            }

        }

        System.out.println(Arrays.toString(numberOfWays));

        totalWays = numberOfWays[total];

        return totalWays;
    }
}
