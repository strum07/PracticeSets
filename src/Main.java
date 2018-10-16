import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

import static java.nio.file.Files.size;

public class Main {

    public static void main(String[] args) {
       /* System.out.println("Hello World!");


        int a = 123 % 10;
        int b = 123 / 1000;

        System.out.println(a);
        System.out.println(b);

        int reversenum =0;

        System.out.println("Input your number and press enter: ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();

        while( num != 0 )
        {
            reversenum = reversenum * 10;
            reversenum = reversenum + num%10;
            num = num/10;
        }
        System.out.println("reverse of input number is: "+reversenum);

        */



       int[] a = {1,1,0};
       int[] b = new int[a.length];
        int z =0;

       for(int i=a.length-1;i>=0;i--){
           int temp = a[i];
           if(temp==0){
               b[z] = 1;
           }else{
               b[z] = 0;
           }
           z++;
       }
       System.out.println(Arrays.toString(b));

    }
}
