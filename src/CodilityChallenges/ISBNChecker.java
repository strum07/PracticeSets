package CodilityChallenges;

public class ISBNChecker {

    private static final int ISBN_THIRTEEN = 13;
    private static final int ISBN_TEN = 10;
    private static final int INVALID_POSITION = -1;

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
            return "";
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

        int checkDigit = extractCheckDigit(digitsFromISBN,ISBN_THIRTEEN);

        for(int i=0;i<ISBN_THIRTEEN-1;i++){
            if((i+1)%2==0){

                sumOfProducts += numberAt(digitsFromISBN,i)*3;
            }else{

                sumOfProducts += numberAt(digitsFromISBN,i);
            }
        }

        if(checkDigit!=INVALID_POSITION){
            if(calculateISBNThirteenCheckDigit(sumOfProducts)==checkDigit){
                isValid = true;
            }
        }

        return isValid;
    }

    private static boolean isValidISBNTen(String digitsFromISBN) {

        boolean isValid = false;
        int sumOfProducts =0;

        int checkDigit = extractCheckDigit(digitsFromISBN,ISBN_TEN);

        for(int i=0;i<ISBN_TEN;i++){

            sumOfProducts += numberAt(digitsFromISBN,i)*(i+1);

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
        return (sumOfProducts%11);
    }
}
