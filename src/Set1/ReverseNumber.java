package Set1;

import java.util.Scanner;

public class ReverseNumber {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number to reverse: ");

        int number = input.nextInt();

        System.out.println("Reversed : "+ReverseNumber(number) );

        if(isPalindrom(number)){
            System.out.println("Palindrome!!!!!!");
        }
    }

    public static int ReverseNumber(int number){
        int reversedNum = 0;
        while(number!=0){
            reversedNum = reversedNum * 10;
            reversedNum = reversedNum + (number%10);
            number = number/10;
        }
        return reversedNum;
    }


    public static boolean isPalindrom(int number){
        boolean status = false;
        if(number==ReverseNumber(number)){
            status = true;
        }
        return status;
    }
}
