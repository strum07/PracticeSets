package EPI_Prep.PrimitiveTypes;


// https://www.geeksforgeeks.org/what-are-the-differences-between-bitwise-and-logical-and-operators-in-cc/

// In Java an int is always 32 bits

public class CountOfBits {
    public static void main(String[] args) {

        int x=32;

        System.out.println(x&1);

        System.out.println("Count of Bits: "+countBits(x));
    }

    private static int countBits(int number) {

        short numberOfBits =0;

        int iteration =0;

        while(number!=0){

            System.out.println("Iteration: "+(iteration+1));

            // so that we are "AND"-ing against 0001 to the last digit to pop so see if we have a bit in there
            // 1 will increment a count
            // 0 will not
            numberOfBits+=(number&1);



            System.out.println("Number of Bits: "+numberOfBits);

            System.out.println("Before shift: "+number);


            // Unsigned Right Shift

            number>>>=1;

            System.out.println("After shift: "+number);

            iteration++;

            System.out.println();

        }
        return numberOfBits;
    }
}
