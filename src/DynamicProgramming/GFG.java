package DynamicProgramming;

public class GFG {

        static int makeChange(int coins[], int numberOfCoins, int target )
        {

            if (target == 0)
                return 1;

            if (target < 0)
                return 0;

            if ((numberOfCoins < 1) && (target > 0))
                return 0;

            int reducedCoins = numberOfCoins-1;

            int reducedTarget = target-coins[numberOfCoins-1];

            return makeChange( coins, reducedCoins, target ) +
                    makeChange( coins, numberOfCoins, reducedTarget );
        }

        public static void main(String[] args)
        {
            int coins[] = {1, 2, 5};
            int numberOfCoins = coins.length;
            System.out.println( makeChange(coins, numberOfCoins, 5));
        }

}


