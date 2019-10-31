package cinimex.utils;

import java.util.Random;

public class NumberGenerator {
    private final static int LENGTH_OF_NUMBER_BALANCE = 20;

    public static String generateNumberOfBalance() {
        String numberOfBalance = "";
        Random numeral = new Random();
        for (int i = 0; i < LENGTH_OF_NUMBER_BALANCE; i++) {
            numberOfBalance += numeral.nextInt(10);
        }
        return numberOfBalance;
    }
}
