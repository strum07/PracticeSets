package Set1;

import java.util.Scanner;

public class FlipNumber {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a number to reverse: ");

        int number = input.nextInt();

        System.out.println("Reversed : "+ reverse(number) );

        if(isPalindrom(number)){
            System.out.println("Palindrome!!!!!!");
        }
    }

    public static int reverse(int number){
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
        if(number== reverse(number)){
            status = true;
        }
        return status;
    }
}
