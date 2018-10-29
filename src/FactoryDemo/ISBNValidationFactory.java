package FactoryDemo;

import static FactoryDemo.ISBN.ISBN_TEN;
import static FactoryDemo.ISBN.ISBN_THIRTEEN;

public class ISBNValidationFactory {

    public boolean validateISBN(String rawInput){

        String digitsFromISBN = ExtractDigits.extractDigitsFromString(rawInput);

        int typeOfISBN = digitsFromISBN.length();


        if(typeOfISBN==ISBN_THIRTEEN){

            ISBNThirteen thirteen = new ISBNThirteen();
            return thirteen.isValid(digitsFromISBN);
        }

        else if(typeOfISBN==ISBN_TEN){
            ISBNTen ten = new ISBNTen();

            return ten.isValid(digitsFromISBN);
        }

        return false;
    }
}
