package CodilityChallenges;

public class Something {



    public static class ISBNValidator {

        private static final int ISBN_THIRTEEN = 13;

        private static final int ISBN_TEN = 10;



        public static boolean isValidISBN(String rawISBN){

            boolean isValid = false;

            if(rawISBN == null || rawISBN.isEmpty()){

                return isValid;
            }


            String digitsFromISBN = extractDigitsFromRawISBN(rawISBN);

            int lengthOfISBN = digitsFromISBN.length();


            if(lengthOfISBN == ISBN_THIRTEEN){

                int lastIndex = digitsFromISBN.length()-1;

                int checkDigit = Character.getNumericValue(digitsFromISBN.charAt(lastIndex));

                int sumOfProducts = 0;

                for(int i=0;i<12;i++){

                    int currentDigit = Character.getNumericValue(digitsFromISBN.charAt(i));

                    //check for even and odd indexes! Not the number!
                    if((i+1)%2==0){
                        sumOfProducts = sumOfProducts + (currentDigit*3);

                    }else{
                        sumOfProducts = sumOfProducts + (currentDigit*1);
                    }

                }

                int calculatedCheckDigit = ((10-(sumOfProducts%10))%10);

                if(checkDigit==calculatedCheckDigit){
                    isValid = true;
                }

            }else if((lengthOfISBN == ISBN_TEN)){


                int lastIndex = digitsFromISBN.length()-1;

                int checkDigit = Character.getNumericValue(digitsFromISBN.charAt(lastIndex));

                int sumOfProducts = 0;


                for(int i=0,factor = 10;i<9;i++,factor--){

                    int currentDigit = Character.getNumericValue(digitsFromISBN.charAt(i));

                    sumOfProducts = sumOfProducts + (currentDigit*factor);


                }

                int calculatedCheckDigit = ((11-(sumOfProducts%11))%11);


                if(checkDigit==calculatedCheckDigit){
                    isValid = true;
                }

            }

            return isValid;

        }



        public static String extractDigitsFromRawISBN(String rawISBN) {

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

    }

}





















    @Test
    public void isValidISBN_WhenPassedAValidISBN10_DigitsOnly_ReturnsTrue() {

        String testISBN = "0471958697";

        boolean expected = true;
        boolean actual = ISBNValidator.isValidISBN(testISBN);

        assertEquals(expected, actual);
    }


    @Test
    public void isValidISBN_WhenPassedAValidISBN10_DigitsAndSpaces_ReturnsTrue() {

        String testISBN = "0 471 60695 2";

        boolean expected = true;
        boolean actual = ISBNValidator.isValidISBN(testISBN);

        assertEquals(expected, actual);
    }


    @Test
    public void isValidISBN_WhenPassedAValidISBN10_DigitsAndHyphens_ReturnsTrue() {

        String testISBN = " 0-306-40615-2";

        String anotherTestISBN = "0-321-14653-0";

        boolean expected = true;


        boolean actual = ISBNValidator.isValidISBN(testISBN);

        assertEquals(expected, actual);


        actual = ISBNValidator.isValidISBN(anotherTestISBN);

        assertEquals(expected, actual);
    }



    @Test
    public void isValidISBN_WhenPassedAInvalidISBN10_DigitsSpacesHyphen_ReturnsFalse() {

        String testISBN = "0 470-84525-9";

        boolean expected = false;
        boolean actual = ISBNValidator.isValidISBN(testISBN);

        assertEquals(expected, actual);
    }
















 import org.junit.*;
         import static org.junit.Assert.*;

public class ISBNValidationFactoryTest {


//81 - what was I thinking?


//ISBN 13 Tests




    ISBNValidationFactory ob = new ISBNValidationFactory();


    @Test
    public void isValidISBN_WhenPassedAnEmptyString_ReturnsFalse() {
        boolean expected = false;
        boolean actual = ob.validateISBN("");
        assertEquals(expected, actual);
    }


    @Test
    public void isValidISBN_WhenPassedAInvalidISBN_LengthLessThan10_ReturnsFalse() {

        String testISBN = "0 470-84";

        boolean expected = false;
        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);
    }


    @Test
    public void isValidISBN_WhenPassedAInvalidISBN_LengthGreaterThan13_ReturnsFalse() {

        String testISBN = "9999 9999-99999-999999999999-999999999999- 9999999";

        boolean expected = false;
        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);
    }


    @Test
    public void isValidISBN_WhenPassedAValidISBN13_DigitsOnly_ReturnsTrue() {

        String testISBN = "9780470059029";

        boolean expected = true;
        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);
    }


    @Test
    public void isValidISBN_WhenPassedAValidISBN13_DigitsAndSpaces_ReturnsTrue() {

        String testISBN = "978 0 471 48648 0";

        boolean expected = true;
        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);
    }


    @Test
    public void isValidISBN_WhenPassedAValidISBN13_DigitsAndHyphens_ReturnsTrue() {

        String testISBN = "978-0596809485";

        String anotherTestISBN = "978-0-262-13472-9";

        boolean expected = true;


        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);


        actual = ob.validateISBN(anotherTestISBN);

        assertEquals(expected, actual);
    }


    //did this test the opposite way!
    @Test
    public void isValidISBN_WhenPassedAInvalidISBN13_DigitsSpacesHyphen_ReturnsFalse() {

        String testISBN = "978 0-471 48648 8";

        boolean expected = false;
        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);
    }



    //ISBN 10 Tests



    @Test
    public void isValidISBN_WhenPassedAValidISBN10_DigitsOnly_ReturnsTrue() {

        String testISBN = "0471958697";

        boolean expected = true;
        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);
    }


    @Test
    public void isValidISBN_WhenPassedAValidISBN10_DigitsAndSpaces_ReturnsTrue() {

        String testISBN = "0 471 60695 2";

        boolean expected = true;
        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);
    }


    @Test
    public void isValidISBN_WhenPassedAValidISBN10_DigitsAndHyphens_ReturnsTrue() {

        String testISBN = " 0-306-40615-2";

        String anotherTestISBN = "0-321-14653-0";

        boolean expected = true;


        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);


        actual = ob.validateISBN(anotherTestISBN);

        assertEquals(expected, actual);
    }



    @Test
    public void isValidISBN_WhenPassedAInvalidISBN10_DigitsSpacesHyphen_ReturnsFalse() {

        String testISBN = "0 470-84525-9";

        boolean expected = false;
        boolean actual = ob.validateISBN(testISBN);

        assertEquals(expected, actual);
    }










}












































































