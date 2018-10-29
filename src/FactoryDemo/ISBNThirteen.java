package FactoryDemo;

public class ISBNThirteen implements ISBN {

    public boolean isValid(String digitsFromISBN) {
        //Validate check digit for ISBN13

        boolean isValid = false;

        int lastIndex = digitsFromISBN.length()-1;

        int checkDigit = Character.getNumericValue(digitsFromISBN.charAt(lastIndex));



        int sumOfProducts=0;


        for(int i=0;i<(ISBN_THIRTEEN-1);i++){

            int currentDigit = Character.getNumericValue(digitsFromISBN.charAt(i));

            //check for even and odd indexes! Not the number!
            if(((i+1)%2)==0){
                sumOfProducts += (currentDigit*3);

            }else{
                sumOfProducts += (currentDigit*1);
            }

        }

        int calculatedCheckDigit = ((ISBN_THIRTEEN_MULTIPLE-(sumOfProducts%ISBN_THIRTEEN_MULTIPLE))%ISBN_THIRTEEN_MULTIPLE);

        if(checkDigit==calculatedCheckDigit){
            isValid = true;
        }

        return isValid;
    }
}
