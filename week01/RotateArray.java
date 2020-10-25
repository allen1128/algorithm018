import java.util.Arrays;

public class RotateArray {
    //brute force
    //time complexity: O(n * k)
    //space complexity: O(1)
    public void rotate1(int[] nums, int k) {
        if (nums.length <= 1) return;
        for (int i = 0; i < k; i++) {
            rotateLastEle(nums);
        }
    }

    private void rotateLastEle(int[] nums) {
        int lastEle = nums[nums.length - 1];
        System.arraycopy(nums, 0, nums, 1, nums.length-1);
        nums[0] = lastEle;
    }

    //time complexity: O(n)
    //space compexity: O(1)
    public void rotate2(int[] nums, int k) {
        if (nums.length <= 1) return;
        rotate2(nums, 0, nums.length);
        rotate2(nums, 0, k);
        rotate2(nums, k, nums.length);
    }

    private void rotate2(int[] nums, int start, int end) {
        for (int i = start, j = end - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    //time complexity: 0(n)
    //space complexity: O(n)
    private void rotate3(int [] nums, int k) {
        int[] newnums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newnums[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(newnums, 0, nums, 0, nums.length);
    }


    public static void main(String[] args) {
        RotateArray ra = new RotateArray();
        int[] nums = new int[] {1,2,3,4,5,6,7};
        ra.rotate3(nums, 3);
        System.out.print(Arrays.toString(nums));
    }
}
