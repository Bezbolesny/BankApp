package pl.bankapp.utils;

import java.util.Random;

public class AccountNumberGenerator {

    public static String generate(){

        final Random random = new Random();
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 26; i++){
            int number = random.nextInt(0,10);
            sb.append(number);
        }

        sb.insert(2, " ");
        sb.insert(7, " ");
        sb.insert(12, " ");
        sb.insert(17, " ");
        sb.insert(22, " ");
        sb.insert(27, " ");

        return sb.toString();
    }

}
