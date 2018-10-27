package CodilityChallenges;

/*
ISBN - International Standard Book Number
-----------------------------------------
There are two ISBN standards: ISBN-10 and ISBN-13.
Support for ISBN-13 is essential, whereas support
for ISBN-10 is optional.

Here are some valid examples of each:

ISBN-10:    0471958697
            0 471 60695 2
            0-470-84525-2
            0-321-14653-0

ISBN-13:    9780470059029
            978 0 471 48648 0
            978-0596809485
            978-0-13-149505-0
            978-0-262-13472-9

Spaces and hyphens may be included in a code, but are not significant.

This means that 9780471486480 is equivalent to 978-0-471-48648-0 and 978 0 471 48648 0.



*******************
******ISBN 10******
*******************

*ISBN-10 is made up of 9 digits plus a check digit (which may be 'X')

The check digit for ISBN-10 is calculated by multiplying each digit by its position (i.e., 1 x 1st digit, 2 x 2nd
digit, etc.),

summing these products together and taking

modulo 11 of the result (with 'X' being used if the result is 10).


*******************
******ISBN 10******
*******************




*******************
******ISBN 13******
*******************

* ISBN-13 is made up of 12 digits plus a check digit.

The check digit for ISBN-13 is calculated by multiplying
each digit alternately by 1 or 3 (i.e., 1 x 1st digit,
3 x 2nd digit, 1 x 3rd digit, 3 x 4th digit, etc.),

- summing these products together,
- taking modulo 10 of the result
- and subtracting this value from 10,
- and then taking the
- modulo 10 of the result again to produce a single digit.



*******************
******ISBN 13******
*******************


Basic task:
Create a function that takes a string and returns true
if that is a valid ISBN-13 and false otherwise.

Advanced task:
Also return true if the string is a valid ISBN-10.

* */

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
            isValid = isValidISBN(digitsFromString,lengthOfISBN);
        }

        return isValid;
    }

    private static boolean isValidLength(int lengthOfISBN) {
        return lengthOfISBN == ISBN_TEN || lengthOfISBN == ISBN_THIRTEEN;
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
