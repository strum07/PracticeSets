package CodilityChallenges;

public class ISBNChecker {

    public static final int ISBN_THIRTEEN = 13;
    public static final int ISBN_TEN = 10;

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

    private static boolean isValidISBN(String ISBN) {

        boolean isValid = false;

        String digitsFromString = extractDigitsFromString(ISBN);

        int lengthOfISBN = digitsFromString.length();

        if(isValidLength(lengthOfISBN)){
            if(lengthOfISBN==ISBN_THIRTEEN){

                isValid = isValidISBNThirteen(digitsFromString,lengthOfISBN);

            }else if(lengthOfISBN==ISBN_TEN){

                isValid = isValidISBNTen(digitsFromString,lengthOfISBN);

            }
            //isValid = isValidISBN(digitsFromString,lengthOfISBN);
        }

        return isValid;
    }

    private static boolean isValidISBNThirteen(String digitsFromString, int lengthOfISBN) {

        boolean isValid = false;
        int sumOfProducts =0;

        //length-1 will give us the last index
        int checkDigit = Character.getNumericValue(digitsFromString.charAt(lengthOfISBN-1)) ;

        for(int i=0;i<lengthOfISBN-1;i++){
            if((i+1)%2==0){

                sumOfProducts += (Character.getNumericValue(digitsFromString.charAt(i)))*3;
            }else{

                sumOfProducts += (Character.getNumericValue(digitsFromString.charAt(i)));
            }
        }

        if(calculateISBNThirteenCheckDigit(sumOfProducts)==checkDigit){
            isValid = true;
        }


        return isValid;
    }

    private static boolean isValidISBNTen(String digitsFromString, int lengthOfISBN) {

        boolean isValid = false;
        int sumOfProducts =0;

        //length-1 will give us the last index
        int checkDigit = Character.getNumericValue(digitsFromString.charAt(lengthOfISBN-1)) ;

        for(int i=0;i<lengthOfISBN;i++){
            sumOfProducts += (Character.getNumericValue(digitsFromString.charAt(i)))*(i+1);
        }

        if(calculateISBNTenCheckDigit(sumOfProducts)==checkDigit){
            isValid = true;
        }

        return isValid;
    }


    private static boolean isValidISBN(String cleanNumber, int lengthOfISBN) {

        boolean isValid = false;
        int sumOfProducts =0;

        //length-1 will give us the last index
        int checkDigit = Character.getNumericValue(cleanNumber.charAt(lengthOfISBN-1)) ;

        if(lengthOfISBN==ISBN_THIRTEEN){

            //loop until the we see the last index containing the check digit (not -2!!!)
            for(int i=0;i<lengthOfISBN-1;i++){
                if((i+1)%2==0){

                    sumOfProducts += (Character.getNumericValue(cleanNumber.charAt(i)))*3;
                }else{

                    sumOfProducts += (Character.getNumericValue(cleanNumber.charAt(i)));
                }
            }

            if(calculateISBNThirteenCheckDigit(sumOfProducts)==checkDigit){
                isValid = true;
            }

        }else if(lengthOfISBN==ISBN_TEN){

            for(int i=0;i<lengthOfISBN;i++){
                    sumOfProducts += (Character.getNumericValue(cleanNumber.charAt(i)))*(i+1);
            }

            if(calculateISBNTenCheckDigit(sumOfProducts)==checkDigit){
                isValid = true;
            }
        }

        return isValid;
    }


    private static int calculateISBNTenCheckDigit(int sumOfProducts) {
        return sumOfProducts%11;
    }


    private static int calculateISBNThirteenCheckDigit(int sumOfProducts) {
        return ((10-(sumOfProducts%10))%10);
    }

    private static boolean isValidLength(int lengthOfISBN) {
        return lengthOfISBN == ISBN_TEN || lengthOfISBN == ISBN_THIRTEEN;
    }

    private static String extractDigitsFromString(String isbn) {

        StringBuilder sbISBN = new StringBuilder();

        if(isbn == null || isbn.isEmpty()) {
            return "";
        }

        for(char c : isbn.toCharArray()){
            if(Character.isDigit(c)){
                sbISBN.append(c);
            }
        }

        return sbISBN.toString();
    }
}
