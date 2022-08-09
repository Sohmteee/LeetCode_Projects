package RomanToInteger;

public class Solution {
    public static int romanToInt(String s) {
        s.replace("IV", "4");
        s.replace("IX", "9");
        s.replace("XL", "40");
        s.replace("XC", "90");
        s.replace("IV", "4");
        s.replace("IV", "4");
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }
}
