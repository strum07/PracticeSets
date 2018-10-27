package CodilityChallenges;

public class ISBNValidator {


    private static final String EMPTY_STRING = "";
    private static final boolean BOOLEAN_EMPTY_STRING = false;

    private static final int ISBN_THIRTEEN = 13;
    private static final int ISBN_TEN = 10;
    private static final int INVALID_POSITION = -1;
    private static final int INVALID_ISBN_TYPE = -1;
    private static final int INVALID_SUM_OF_PRODUCTS = -3;
    private static final int MIN_SUM_OF_PRODUCTS = 0;
    private static final int MAX_SUM_OF_PRODUCTS_ISBN_TEN = (9*9)*9;
    private static final int MAX_SUM_OF_PRODUCTS_ISBN_THIRTEEN = (9*12)*9;

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
    }

    private static boolean isValidISBN(String rawISBN) {

        boolean isValid = false;

        String digitsFromISBN = extractDigitsFromRawISBN(rawISBN);

        int lengthOfISBN = digitsFromISBN.length();

        if(isValidLength(lengthOfISBN)){
            if(lengthOfISBN==ISBN_THIRTEEN){

                isValid = isValidISBNThirteen(digitsFromISBN);

            }else if(lengthOfISBN==ISBN_TEN){

                isValid = isValidISBNTen(digitsFromISBN);

            }
        }
        return isValid;
    }

    private static String extractDigitsFromRawISBN(String rawISBN) {

        StringBuilder sbISBN = new StringBuilder();

        if(rawISBN == null || rawISBN.isEmpty()) {
            return EMPTY_STRING;
        }

        for(char c : rawISBN.toCharArray()){
            if(Character.isDigit(c)){
                sbISBN.append(c);
            }
        }
        return sbISBN.toString();
    }

    private static boolean isValidLength(int lengthOfISBN) {
        return lengthOfISBN == ISBN_TEN || lengthOfISBN == ISBN_THIRTEEN;
    }

    private static boolean isValidISBNThirteen(String digitsFromISBN) {

        boolean isValid = false;
        int sumOfProducts =0;

        if(digitsFromISBN == null || digitsFromISBN.isEmpty()) {
            return BOOLEAN_EMPTY_STRING;
        }

        int checkDigit = extractCheckDigit(digitsFromISBN,ISBN_THIRTEEN);

        sumOfProducts = getSumOfProducts(digitsFromISBN, sumOfProducts,ISBN_THIRTEEN);

        if(checkDigit!=INVALID_POSITION){
            if(calculateISBNThirteenCheckDigit(sumOfProducts)==checkDigit){
                isValid = true;
            }
        }

        return isValid;
    }

    private static int getSumOfProducts(String digitsFromISBN, int sumOfProducts, int typeISBN ) {

        if(typeISBN == ISBN_THIRTEEN){
            for(int i=0;i<ISBN_THIRTEEN-1;i++){

                int currentDigit = numberAt(digitsFromISBN,i);

                if(currentDigit!=INVALID_POSITION){
                    if((i+1)%2==0){

                        sumOfProducts += currentDigit*3;
                    }else{

                        sumOfProducts += currentDigit;
                    }
                }
            }
        } else if(typeISBN == ISBN_TEN){

        }






        return sumOfProducts;
    }

    private static boolean isValidISBNTen(String digitsFromISBN) {

        boolean isValid = false;
        int sumOfProducts =0;

        if(digitsFromISBN == null || digitsFromISBN.isEmpty()) {
            return BOOLEAN_EMPTY_STRING;
        }

        int checkDigit = extractCheckDigit(digitsFromISBN,ISBN_TEN);

        for(int i=0,multiplier=10;i<ISBN_TEN-1;i++,multiplier--){

            int currentDigit = numberAt(digitsFromISBN,i);

            if(currentDigit!=INVALID_POSITION){

                sumOfProducts += currentDigit*multiplier;
            }
        }

        if(checkDigit!=INVALID_POSITION){
            if(calculateISBNTenCheckDigit(sumOfProducts)==checkDigit){
                isValid = true;
            }
        }

        return isValid;
    }

    private static int numberAt(String digitsFromISBN, int position) {

        if((position<0) || (position>(digitsFromISBN.length()-1))){
            return INVALID_POSITION;
        }

        return Character.getNumericValue(digitsFromISBN.charAt(position));
    }

    private static int extractCheckDigit(String digitsFromISBN, int lengthOfISBN) {
        return numberAt(digitsFromISBN,lengthOfISBN-1);
    }

    private static int calculateISBNThirteenCheckDigit(int sumOfProducts) {
        return ((10-(sumOfProducts%10))%10);
    }

    private static int calculateISBNTenCheckDigit(int sumOfProducts) {
        return ((11-(sumOfProducts%11))%11);
    }


    private static int calculateISBNCheckDigit(int sumOfProducts, int typeISBN){

        if((typeISBN == ISBN_TEN)&&(sumOfProducts<MIN_SUM_OF_PRODUCTS || sumOfProducts>MAX_SUM_OF_PRODUCTS_ISBN_TEN)){
            return INVALID_SUM_OF_PRODUCTS;
        }

        if((typeISBN == ISBN_THIRTEEN)&&(sumOfProducts<MIN_SUM_OF_PRODUCTS || sumOfProducts>MAX_SUM_OF_PRODUCTS_ISBN_THIRTEEN)){
            return INVALID_SUM_OF_PRODUCTS;
        }

        if(typeISBN==ISBN_TEN){
            return ((11-(sumOfProducts%11))%11);

        }else if(typeISBN==ISBN_THIRTEEN){
            return ((10-(sumOfProducts%10))%10);
        }

        return INVALID_ISBN_TYPE;
    }

}
