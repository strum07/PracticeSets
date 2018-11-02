package FactoryDemo;

public class ISBNTen implements ISBN{

    public boolean isValid(String digitsFromISBN) {

        int lastIndex = digitsFromISBN.length()-1;

        int checkDigit = Character.getNumericValue(digitsFromISBN.charAt(lastIndex));

        boolean isValid = false;

        int sumOfProducts=0;

        //Validate check digit for ISBN10

        for(int i=0,factor = 10;i<(ISBN_TEN-1);i++,factor--){

            int currentDigit = Character.getNumericValue(digitsFromISBN.charAt(i));

            sumOfProducts +=  (currentDigit*factor);

        }

        int calculatedCheckDigit = ((ISBN_TEN_MULTIPLE-(sumOfProducts%ISBN_TEN_MULTIPLE))%ISBN_TEN_MULTIPLE);


        if(checkDigit==calculatedCheckDigit){
        isValid = true;
        }

        return isValid;

    }
}
