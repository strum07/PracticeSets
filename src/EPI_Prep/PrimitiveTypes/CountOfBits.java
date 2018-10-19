package EPI_Prep.PrimitiveTypes;

public class CountOfBits {
    public static void main(String[] args) {
        int x=3;

        System.out.println(countBits(x));
    }

    private static int countBits(int number) {

        short numBits =0;

        while(number!=0){
            numBits+=(number&1);

            //Right Shift Operator?
            number>>>=1;

        }
        return numBits;
    }
}
