package CodilityChallenges;

public class Something {



    public class ISBNValidator {

        private static final int ISBN_THIRTEEN = 13;

        private static final int ISBN_TEN = 10;



        public boolean isValidISBN(String rawISBN){

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
