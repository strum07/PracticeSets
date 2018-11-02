package FactoryDemo;

public class ExtractDigits {

    public static String extractDigitsFromString(String inputString) {

        StringBuilder sb = new StringBuilder();

        if(inputString == null || inputString.isEmpty()) {
            return "";
        }

        for(char c : inputString.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
