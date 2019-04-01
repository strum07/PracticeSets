package CodeDome;

import java.util.*;

public class ddd {
    public static void main(String[] args) {

        //System.out.println(distinctSubstring("kincenvizh"));
        //System.out.println(distinctSubstring("ghaqjdrmnegmrlrlfpjmnnngpwalzknsencuzwsnhfltwohdgbmvfuwtquosrnyerucntxxkfqehjqygcarxogvcfkljzbzutxphpyykapncjfclnhndzxghelyvzpylazhuutmcquusexzbhsfsmbnlvnlemzvfqbfzwquairhpylnbvyhiyamztlhfchhbwrqddmuzsprfdwuqqchcpeakkexackwwzihkfenwzwckynymgqydvjtovaoezkjjurylqcuonsujycziobnfnmuwnoxcdtahpituykvgpyyshvukrstcbmnsqtjseflwywnslmvnqrtnzkyaddkjamrezprqgoenzsdryygbkeahfiduozpwkrgmatszaxmwodsqiocvagbvxyqotpaujnqvqgjmfxnxhfbwqjpgodlxdrxpjpmzeabpgqrzpxomniknjkdiwtfgyvwvekrnoupwkcbtmpcfamzrghgrznuedkybmfwctdghcfawajlxfkzhdamuygjbcwnyglkjlfmpxfdtovkqbshhrfrnyjrgxgiozsuuncnwofkqzsypwgeikpfbhryhpszegdfajzvqlwwqlnvdtdiuckcvvosrdweohnmawqonjbxyjjhlccuteeshfrxxdhzgakwjqbymnaeudcmibsytyajsgdpfvrutcpglzxdevenevmkgalcrpknuvcrnkuboennhyzirfwvtozzijujsckbxqpocakzrbwgpqgjjmsrtwmvhwyraukbuxfvebeylfpipzwjdzlmgslbtwzataxgqpasrssnfwndldwkdutdqcmcpyanrbdsxrvcvpsywjambtbzlcrvzesuhvyvwwuwwdznigxjxknfajpknqutfvvqynkpvkzgypasevrpxofbymdzcitoqolwqegocuyqsexhumzmckzuuwkamolbltlifongpvkcnrnnuplftqbxpdnegdqlymftqyrxcnzmu"));
    }

    public static long substring(String S){

        HashSet<Character> uniqueCharacters = new HashSet<>();
        for(int i = 0; i<S.length();i++){
            uniqueCharacters.add(S.charAt(i));
        }
        long n = S.length();
        return (n * (n + 1) / 2) - (n - uniqueCharacters.size()) ;

    }


    public static long distinctSubstring(String s)
    {
        Set<String> result = new HashSet<>();

        for (int i = 0; i <= s.length(); i++) {
            for (int j = s.length(); j >=i+1; j--) {
                result.add(s.substring(i, j));
                System.out.println(s.substring(i,j));
            }
        }
        return result.size();
    }


    public static List<String> reformatDate(List<String> dates){
        List<String> formatted = new ArrayList<>();
        HashMap<String,String> monthMap = new HashMap<>();

        monthMap.put("Jan","01");
        monthMap.put("Feb","02");
        monthMap.put("Mar","03");
        monthMap.put("Apr","04");
        monthMap.put("May","05");
        monthMap.put("Jun","06");
        monthMap.put("Jul","07");
        monthMap.put("Aug","08");
        monthMap.put("Sep","09");
        monthMap.put("Oct","10");
        monthMap.put("Nov","11");
        monthMap.put("Dec","12");


        for(int i =0 ; i < dates.size();i++){
            String dateToBeFormatted = dates.get(i);
            String[] splitDateArray = dateToBeFormatted.split("\\s+");
            formatted.add(beatifyDate(splitDateArray, monthMap));
        }

        return formatted;
    }

    private static String beatifyDate(String[] splited, HashMap<String,String> monthMap) {

        String year = splited[2];

        String month = monthMap.get(splited[1]);


        String day = splited[0].replaceAll("[^0-9]", "");
        if(day.length()==1){
            day = "0"+day;
        }

        return year+"-"+month+"-"+day;
    }

    //https://stackoverflow.com/questions/47689164/reformatting-dates-by-using-java
}
