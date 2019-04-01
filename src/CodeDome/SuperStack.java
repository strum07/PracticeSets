package CodeDome;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class SuperStack {
    static Stack<Integer> stack = new Stack<>();
    static HashMap<Integer, Integer> offsetMap = new HashMap<>();

    /*
     * Complete the function below.
     */
    static void superStack(String[] operations) {

        for (int i = 0; i < operations.length; i++) {
            String str = operations[i];
            String[] strArr = str.split(" ");

            switch (strArr[0]) {
                case "push":
                    System.out.println(push(Integer.parseInt(strArr[1])));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "inc":
                    System.out.println(inc(Integer.parseInt(strArr[1]), Integer.parseInt(strArr[2])));
                    break;
            }
        }
    }

    private static int push(int n) {
//     System.out.print("push: ");
//     System.out.println(n);
        stack.push(n);
        offsetMap.put(stack.size()-1,0);

//        System.out.println("Size: "+stack.size());
//        System.out.println("Offset: "+offsetMap);
//        System.out.println("Stack: "+stack);
        return stack.peek()+offsetMap.getOrDefault(stack.size()-1,0);
    }

    private static String pop() {
//  System.out.print("pop: ");
//     System.out.println(stack.peek());
        stack.pop();
        offsetMap.remove(stack.size());

        if (stack.isEmpty()) return "EMPTY";

        else
        System.out.println("Size: "+stack.size());
        System.out.println("Offset: "+offsetMap);
        System.out.println("Stack: "+stack);
            return String.valueOf((stack.peek()+offsetMap.getOrDefault(stack.size()-1,0)));
    }

    private static int inc(int numElements, int increment) {

        for (int i = 0; i < numElements; i++) {
            offsetMap.put(i, offsetMap.getOrDefault(i, 0) + increment);
        }
        System.out.println("Size: "+stack.size());
        System.out.println("Offset: "+offsetMap);
        System.out.println("Stack: "+stack);
        return stack.peek()+(offsetMap.getOrDefault(stack.size()-1, 0));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int operations_size = 0;
        operations_size = Integer.parseInt(in.nextLine().trim());

        String[] operations = new String[operations_size];
        for (int i = 0; i < operations_size; i++) {
            String operations_item;
            try {
                operations_item = in.nextLine();
            } catch (Exception e) {
                operations_item = null;
            }
            operations[i] = operations_item;
        }
        superStack(operations);
    }
}



class Account{

    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public Account() {
    }


    private String deposit(int money) {

        balance = balance + money;
        return "Depositing $"+money;
    }

    private String withdraw(int money) {
        if((balance-money)<0)
        return "Withdrawing $"+money+"(Insufficient Balance)";

        balance = balance - money;

        return "Withdrawing $"+money;

    }

    private int getBalance() {
        return balance;
    }


class Transaction{


    }
}


