package CodilityChallenges;

import java.util.Arrays;

public class testChallenge {

    public static void main(String[] args) {


        //increasing array
        int[] a = {1, 2, 3, 4, 5, 6};

        //decreasing array
        int[] b = {6, 5, 4, 3, 2, 1};

        //same elements
        int[] c = {1, 1, 1, 1, 1, 1};

        //one elements
        int[] d = {1};

        //no elements
        int[] e = {};

        //jagged elements
        int[] f = {1, 2, 1, 2, 1, 2, 1};

        //test1 elements
        int[] g = {-3,-3};

        //test1 elements
        int[] h = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};

        /*
        System.out.println("increasing array: " + Arrays.toString(a) + " Count: " + countCastles(a));
        System.out.println("decreasing array: " + Arrays.toString(b) + " Count: " + countCastles(b));
        System.out.println("same element: " + Arrays.toString(c) + " Count: " + countCastles(c));
        System.out.println("One element: " + Arrays.toString(d) + " Count: " + countCastles(d));
        System.out.println("No elements: " + Arrays.toString(e) + " Count: " + countCastles(e));
        System.out.println("jagged elements: " + Arrays.toString(f) + " Count: " + countCastles(f));

        */

        System.out.println("test 1: " + Arrays.toString(g) + " Count: " + count2(g));
        System.out.println("test 1: " + Arrays.toString(g) + " countcastles: " + countCastles(g));
        System.out.println("test 2: " + Arrays.toString(h) + " Count: " + count2(h));
        System.out.println("test 2: " + Arrays.toString(h) + " countcastles: " + countCastles(h));

    }

    private static int countCastles(int[] a) {

        int count = 0;
//        if (a.length < 2) {
//            return a.length;
//        }

        if (a.length == 1) {
            count = 1;
            return count;
        }


        if (a.length == 2) {
            if (a[0] == a[1]) {
                count = 1;
                return count;
            }
            count = 2;
            return count;
        }



        count = count+ checkBounds(a);
        System.out.println("checkbounds: "+checkBounds(a));



        int sameelement = 0;
        for (int i = 1; i < a.length - 2; i++) {


            if(a[i]==a[i+1]){
                count = count+1;
                sameelement++;
                continue;
            }

            if ((a[i] > a[i + 1] && a[i] > a[i - 1]) || (a[i] < a[i + 1] && a[i] < a[i - 1])) {
                count = count + 1;
            }

        }

        System.out.println(sameelement);

        return count;

    }

    private static int checkBounds(int[] a) {

        int boundsCount = 0;
        int arrayLength = a.length;


        if(a[0]==a[1]){
            boundsCount=boundsCount-1;
        }


        if(a[arrayLength-1]==a[arrayLength-2]){
            boundsCount=boundsCount-1;
        }


        //check 0
        if ((a[0] > a[1]) || (a[0] < a[1])) {
            boundsCount = boundsCount + 1;
        }
        //check last element
        if ((a[arrayLength - 1] > a[arrayLength - 2]) || (a[arrayLength - 1] < a[arrayLength - 2])) {
            boundsCount = boundsCount + 1;
        }



        return boundsCount;
    }


    private static int count2(int[] a){
        if(a == null || a.length == 0)
            return 0;
        if(a.length == 1)
            return 1;
        int count = 1;
        int i = 0, j = i + 1;
        while(i < a.length && j < a.length){
            if(a[j] == a[i]){
                ++i;
                ++j;
            }else if(a[j] > a[i]){
                ++count;
                int k = j + 1;
                while(k < a.length && a[k] >= a[k - 1]){
                    ++k;
                }
                if(k == a.length)
                    return count;
                i = k - 1;
                j = k;
            }else{
                ++count;
                int k = j + 1;
                while(k < a.length && a[k] <= a[k - 1]){
                    ++k;
                }
                if(k == a.length)
                    return count;
                i = k - 1;
                j = k;
            }
        }
        return count;
    }
}
