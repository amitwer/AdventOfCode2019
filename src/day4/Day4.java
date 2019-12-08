package day4;

public class Day4 {

    public static void main(String[] args) {
        var min = 172930;
        var max = 683082;
        var validPasswords = getValidPasswordsNum(min, max);
        System.out.println(validPasswords);


    }

    private static int getValidPasswordsNum(int min, int max) {
        var counter = 0;
        for (int i = min; i <= max; ++i) {
            if (isMatchingRules(i)) {
                counter++;
            }
        }
        return counter;
    }

    private static boolean isMatchingRules(int candidate) {
        return hasDoubleDigits(candidate) && isNotDecreasing(candidate) && hasSinglePair(candidate);
    }

    private static boolean hasSinglePair(int candidate) {
        char[] chars = Integer.toString(candidate).toCharArray();
        var counter = 0;
        char current = 'x';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != current) {
                if (counter == 2) {
                    return true;
                }
                current = chars[i];
                counter = 1;
            } else {
                counter++;
            }
        }
        return counter == 2;
    }

    private static boolean isNotDecreasing(int candidate) {
        char[] chars = Integer.toString(candidate).toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] > chars[i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasDoubleDigits(int candidate) {
        char[] chars = Integer.toString(candidate).toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                return true;
            }

        }
        return false;
    }
}
