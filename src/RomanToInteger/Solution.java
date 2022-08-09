package RomanToInteger;

public class Solution {
    public static int romanToInt(String s) {
        s.replace("IV", "4");
        s.replace("IX", "9");
        s.replace("XL", "4");
        s.replace("XC", "9");
        s.replace("CD", "4");
        s.replace("CM", "9");

        s.replace("I", "4");
        s.replace("V", "4");
        s.replace("X", "4");
        s.replace("L", "4");
        s.replace("C", "4");
        s.replace("D", "4");
        s.replace("M", "4");

    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
