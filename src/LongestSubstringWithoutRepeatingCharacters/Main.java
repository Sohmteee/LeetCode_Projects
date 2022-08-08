package LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String s = "pwwkew";
        lengthOfLongestSubstring(s);

    }

    public static int lengthOfLongestSubstring(String s) {
        char[] sChar = s.toCharArray();

        ArrayList<Character> aaa = new ArrayList<>();

        for (char c : sChar) {
            aaa.add(c);
            for (int i = 0; i < aaa.size() - 1; i++) {
                if (c == aaa.get(i)) aaa.remove(i);
            }
        }

        return aaa.size();
    }
}

