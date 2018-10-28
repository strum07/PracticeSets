package CodilityChallenges;

public class ISBNValidator {

    private static final int ISBN_THIRTEEN = 13;

    private static final int ISBN_TEN = 10;

    private static final int INVALID_POSITION = -1;

    private static final int MIN_SUM_OF_PRODUCTS = 0;

    private static final int ISBN_TEN_MAX_SUM_OF_PRODUCTS = (9*9)*9;

    private static final int ISBN_THIRTEEN_MAX_SUM_OF_PRODUCTS = (9*12)*9;

    public static void main(String[] args) {

        String validTen = "0-321-14653-0";

        String validThirteen1 = "978-0-321-14653-3";
        String validThirteen2 = "978 0 471 48648 0";
        String validThirteen3 = "978-0596809485";
        String validThirteen4 = "978-0-13-149505-0";
        String validThirteen5 = "978-0-262-13472-9";

        System.out.println(isValidISBN(validThirteen1));
        System.out.println(isValidISBN(validThirteen2));
        System.out.println(isValidISBN(validThirteen3));
        System.out.println(isValidISBN(validThirteen4));
        System.out.println(isValidISBN(validThirteen5));

        System.out.println("valid 10");
        System.out.println(isValidISBN(validTen));

        //ISBNValidator ob = new ISBNValidator();
        //System.out.println("Object here:");
        //System.out.println(ob.isValidISBN("978-0-321-14653-3"));
    }

    // returning empty string - case for exception
    private static boolean isValidISBN(String rawISBN) {

        if((rawISBN == null || rawISBN.isEmpty())) {
            return false;
        }

        boolean isValid = false;

        String digitsFromISBN = extractDigitsFromRawISBN(rawISBN);

        int typeOfISBN = digitsFromISBN.length();

        if(isValidISBNType(typeOfISBN)){

            int checkDigit = extractCheckDigit(digitsFromISBN);

            int sumOfProducts = getSumOfProducts(digitsFromISBN);

            isValid = isValidCheckDigit(sumOfProducts, checkDigit,typeOfISBN);

        }

        return isValid;
    }

    // returning empty string - case for exception
    private static String extractDigitsFromRawISBN(String rawISBN) {

        StringBuilder sbISBN = new StringBuilder();

        if(rawISBN == null || rawISBN.isEmpty()) {
            throw new RuntimeException("The ISBN string doesn't contain numbers or is Empty! Value: "+rawISBN);
        }

        for(char c : rawISBN.toCharArray()){
            if(Character.isDigit(c)){
                sbISBN.append(c);
            }
        }
        return sbISBN.toString();
    }

    // done with exceptions
    private static boolean isValidISBNType(int lengthOfISBN) {
        return lengthOfISBN == ISBN_TEN || lengthOfISBN == ISBN_THIRTEEN;
    }

    // done with exceptions
    private static int extractCheckDigit(String digitsFromISBN) {

        checkForSpuriousISBNValue(digitsFromISBN);

        int lastIndex = digitsFromISBN.length()-1;

        return numberAt(digitsFromISBN,lastIndex);
    }


    private static boolean isValidCheckDigit(int sumOfProducts, int checkDigit, int typeISBN) {
        if (checkDigit == INVALID_POSITION) {
            return false;
        }
        return calculateISBNCheckDigit(sumOfProducts, typeISBN) == checkDigit;
    }

    // done with exceptions
    private static int getSumOfProducts(String digitsFromISBN) {

        checkForSpuriousISBNValue(digitsFromISBN);

        int typeOfISBN = digitsFromISBN.length();

        int sumOfProducts = 0;

        if(typeOfISBN == ISBN_THIRTEEN){
            for(int i=0;i<ISBN_THIRTEEN-1;i++){

                int currentDigit = numberAt(digitsFromISBN,i);

                if((i+1)%2==0){

                    sumOfProducts += currentDigit*3;
                }else{

                    sumOfProducts += currentDigit;
                }

            }
        } else if(typeOfISBN == ISBN_TEN){

            for(int i=0,multiplier=10;i<ISBN_TEN-1;i++,multiplier--){

                int currentDigit = numberAt(digitsFromISBN,i);

                sumOfProducts += currentDigit*multiplier;

            }

        }
        return sumOfProducts;
    }

    // done with exceptions
    private static int numberAt(String digitsFromISBN, int position) {

        checkForSpuriousISBNValue(digitsFromISBN);

        if((position<0) || (position>(digitsFromISBN.length()-1))){
            throw new ArrayIndexOutOfBoundsException("Position doesn't exist in string containing the ISBN NUMBER : "+digitsFromISBN+" the position you are trying to access: "+position);
        }

        return Character.getNumericValue(digitsFromISBN.charAt(position));
    }

    private static void checkForSpuriousISBNValue(String digitsFromISBN) {
        if(digitsFromISBN == null || digitsFromISBN.isEmpty()) {
            throw new RuntimeException("The ISBN string doesn't contain numbers or is Empty! Value: "+digitsFromISBN);
        }

        if(!(isValidISBNType(digitsFromISBN.length()))){
            throw new RuntimeException("Illegal ISBN Type! Value: "+digitsFromISBN.length());
        }
    }



    // done with exceptions
    private static int calculateISBNCheckDigit(int sumOfProducts, int typeISBN){

        if(!isValidISBNType(typeISBN)){
            throw new NumberFormatException("Invalid ISBN type - Value: "+typeISBN);
        }

        if((typeISBN == ISBN_TEN)&&(sumOfProducts<MIN_SUM_OF_PRODUCTS || sumOfProducts> ISBN_TEN_MAX_SUM_OF_PRODUCTS)){
            throw new NumberFormatException("Invalid Sum Of Products; VALID RANGE FOR ISBN 10: "+MIN_SUM_OF_PRODUCTS+" to "+ISBN_TEN_MAX_SUM_OF_PRODUCTS+" Current Value: "+ sumOfProducts);
        }

        if((typeISBN == ISBN_THIRTEEN)&&(sumOfProducts<MIN_SUM_OF_PRODUCTS || sumOfProducts> ISBN_THIRTEEN_MAX_SUM_OF_PRODUCTS)){

            throw new NumberFormatException("Invalid Sum Of Products; VALID RANGE FOR ISBN 13: "+MIN_SUM_OF_PRODUCTS+" to "+ISBN_THIRTEEN_MAX_SUM_OF_PRODUCTS+" Current Value: "+ sumOfProducts);
        }

        int checkDigit = -1;

        if(typeISBN==ISBN_TEN){
            checkDigit = ((11-(sumOfProducts%11))%11);

        }else if(typeISBN==ISBN_THIRTEEN){
            checkDigit = ((10-(sumOfProducts%10))%10);
        }

        if(checkDigit==-1){
            throw new IllegalStateException("Check digit is assigned to default = -1, but value isn't changed! Value: "+checkDigit);
        }

        return checkDigit;
    }

}
