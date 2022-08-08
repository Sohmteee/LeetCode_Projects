package StringtoInteger;

public class Main {
    public static void main(String[] args) {
        System.out.println(myAtoi("words and 97"));
    }

    public static int myAtoi(String s) {
        boolean isWhiteSpace = true, isNegative = false;
        char[] sToChar = s.toCharArray();
        String finalInteger = "";

        try {
            for (int i = 0; i < s.length(); i++) {
                if (isWhiteSpace & sToChar[i] == ' ') continue;
                else if (isWhiteSpace & sToChar[i] != ' ') {
                    if (sToChar[i] == '-') isNegative = true;
                    else if (sToChar[i] == '+') isNegative = true;

                    isWhiteSpace = false;

                    if (Character.isDigit(sToChar[i])) finalInteger += sToChar[i];

                    continue;
                }

                if (!isWhiteSpace) {
                    if (!Character.isDigit(sToChar[i])) break;
                    else  finalInteger += sToChar[i];
                }

            }

            if (isNegative) return -Integer.parseInt(finalInteger);
            else return Integer.parseInt(finalInteger);
        } catch (Exception e) {
            if (Integer.parseInt(s) > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if (Integer.parseInt(s) < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            else return 0;
        }

    }
}
