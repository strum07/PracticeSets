package Set1;

import java.util.ArrayList;

public class MinimumMoves {

    public static void main(String[] args) {

        ArrayList<Integer> Andrea = new ArrayList<>();
        ArrayList<Integer> Maria = new ArrayList<>();

        Andrea.add(1234);
        Andrea.add(4321);

        Maria.add(2345);
        Maria.add(3214);

        int moveCount = findMoves(Andrea,Maria);

        System.out.print(moveCount);
    }

    private static int findMinimumMoves(ArrayList<Integer> andrea, ArrayList<Integer> maria) {
        int minCount = 0;
        for (int index =0; index<andrea.size(); index++) {
            int a1 = andrea.get(index);
            int m1 = maria.get(index);
            while (a1 > 0) {
                //Pop "Units" from the number
                int a = a1 % 10;
                int m = m1 % 10;

                while (a > m) {
                    m += 1;
                    minCount += 1;
                }
                while (a < m) {
                    m -= 1;
                    minCount += 1;
                }
                a1 = a1 / 10;
                m1 = m1 / 10;
            }
        }
        return minCount;
    }



    public static int findMoves(ArrayList<Integer> andrea, ArrayList<Integer> maria) {
        int minCount = 0;
        for (int index =0; index<andrea.size(); index++) {
            int a1 = andrea.get(index);
            int m1 = maria.get(index);
            while (a1 > 0) {
                int a = a1 % 10;
                int m = m1 % 10;

                if (a > m) {
                    minCount += a - m;
                }
                if (a < m) {
                    minCount += m - a;
                }
                a1 = a1 / 10;
                m1 = m1 / 10;
            }
        }
        return minCount;
    }
}
