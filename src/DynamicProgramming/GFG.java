package DynamicProgramming;

public class GFG {

    // Recursive java program for
// coin change problem.

        // Returns the count of ways we can
        // sum S[0...m-1] coins to get sum n
        static int count( int coins[], int numberOfCoins, int target )
        {
            // If n is 0 then there is 1 solution
            // (do not include any coin)
            if (target == 0)
                return 1;

            // If n is less than 0 then no
            // solution exists
            if (target < 0)
                return 0;

            // If there are no coins and n
            // is greater than 0, then no
            // solution exist
            if (numberOfCoins <=0 && target >= 1)
                return 0;

            // count is sum of solutions (i)
            // including S[m-1] (ii) excluding S[m-1]
            return count( coins, numberOfCoins - 1, target ) +
                    count( coins, numberOfCoins, target-coins[numberOfCoins-1] );
        }

        // Driver program to test above function
        public static void main(String[] args)
        {
            int coins[] = {1, 2, 5};
            int numberOfCoins = coins.length;
            System.out.println( count(coins, numberOfCoins, 4));


        }

}


