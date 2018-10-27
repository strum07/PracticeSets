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

        String cleanNumber = cleanString(ISBN);

        int ISBNLength = cleanNumber.length();

        if(isValidLength(ISBNLength)){
            System.out.println("");
            System.out.println("Clean Number:" +cleanNumber);
            System.out.println("String Length: "+ISBNLength);
            isValid = validateCleanISBN(cleanNumber,ISBNLength);
        }

        return isValid;
    }

    private static boolean isValidLength(int isbnLength) {
        return isbnLength == 10 || isbnLength == 13;
    }

    private static boolean validateCleanISBN(String cleanNumber, int ISBNLength) {

        boolean isValid = false;

        if(ISBNLength==13){
            //System.out.println("I am here!");
            //System.out.println("Received Clean Number: "+cleanNumber);

            int sumOfProducts =0;

            //length-1 will give us the last index
            int checkDigit = Character.getNumericValue(cleanNumber.charAt(ISBNLength-1)) ;

            //loop until the we see the last index containing the check digit (not -2!!!)
            for(int i=0;i<ISBNLength-1;i++){
                if((i+1)%2==0){
                    //System.out.println("Iteration: "+(i+1));
                    sumOfProducts += (Character.getNumericValue(cleanNumber.charAt(i)))*3;
                }else{
                    //System.out.println("Iteration: "+(i+1));
                    sumOfProducts += (Character.getNumericValue(cleanNumber.charAt(i)))*1;
                }
            }
            System.out.println("Sum of Products: "+sumOfProducts);
            System.out.println("Calculated Digit: "+calculateCheckDigit(sumOfProducts));
            System.out.println("Check Digit: "+checkDigit);

            if(calculateCheckDigit(sumOfProducts)==checkDigit){
                isValid = true;
            }

        }else if (ISBNLength==10){

            String newString = "978"+cleanNumber;

            System.out.println(newString);

            isValid = validateCleanISBN(newString,newString.length());

        }

        return isValid;
    }

    private static int calculateCheckDigit(int sumOfProducts) {
        /*
         - summing these products together,
         - taking modulo 10 of the result
         - and subtracting this value from 10,
         - and then taking the modulo 10 of the result again to produce a single digit.
        */
        return ((10-(sumOfProducts%10))%10);
    }

    private static String cleanString(String isbn) {

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
