package AddTwoNumbers;

public class Main {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        for (int c : twoSum(nums, target)) {
            System.out.println(c);
        }

    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((nums[i] + nums[j] == target) & (i != j)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
