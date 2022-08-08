package PalindromeNumber;
public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));

    }

    public static boolean isPalindrome(int x) {
        if (x >= 0) {
            if (x == 0) return true;

            int xDup = x, xRev = 0;

            while (xDup > 0) {
                xRev *= 10;
                xRev += xDup % 10;
                xDup /= 10;
            }

            if (xRev == x) return true;

        }

        return false;
    }
}
