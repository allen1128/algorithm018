public class RemoveDuplicatesFromSortedArray {

    //time complexity O(n)
    //space complexity O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int curr = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[curr]) {
                nums[++curr] = nums[i];
            }
        }
        return curr+1;
    }
}
