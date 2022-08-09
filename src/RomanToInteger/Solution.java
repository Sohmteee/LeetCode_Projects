package RomanToInteger;

public class Solution {
    public static int romanToInt(String s) {
        s = s.replace("IV", "4");
        s = s.replace("IX", "9");
        s = s.replace("XL", "4");
        s = s.replace("XC", "9");
        s = s.replace("CD", "4");
        s = s.replace("CM", "9");

        s = s.replace("I", "1");
        s = s.replace("V", "5");
        s = s.replace("X", "1");
        s = s.replace("L", "5");
        s = s.replace("C", "1");
        s = s.replace("D", "5");
        s = s.replace("M", "1");

        return Integer.parseInt(s);

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
