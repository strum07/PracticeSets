package FactoryDemo;

public interface ISBN {

    static final int ISBN_THIRTEEN = 13;

    static final int ISBN_THIRTEEN_MULTIPLE = 10;

    final int ISBN_TEN = 10;

    final int ISBN_TEN_MULTIPLE = 11;

    boolean isValid(String digitsFromString);

}
