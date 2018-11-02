package FactoryDemo;

public class ClientImplementation {

    public static void main(String[] args) {

        ISBNValidationFactory ob = new ISBNValidationFactory();

        System.out.println(ob.validateISBN("0471958697"));

    }
}
