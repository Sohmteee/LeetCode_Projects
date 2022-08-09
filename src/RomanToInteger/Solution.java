package RomanToInteger;

public class Solution {
    public static int romanToInt(String s) {
        s.replace("IV", "4");
        s.replace("IX", "9");
        s.replace("XL", "4");
        s.replace("XC", "9");
        s.replace("CD", "4");
        s.replace("CM", "9");

        s.replace("I", "1");
        s.replace("V", "5");
        s.replace("X", "1");
        s.replace("L", "5");
        s.replace("C", "1");
        s.replace("D", "5");
        s.replace("M", "1");

        return Integer.parseInt(s);

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("I"));
    }
}
