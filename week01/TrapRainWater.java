public class TrapRainWater {
    public int trap(int[] height) {
        int[] dp = new int[height.length];
        int leftMax = 0;
        for (int i = 0; i < height.length; i++) {
            dp[i] = leftMax;
            leftMax = Math.max(leftMax, height[i]);
        }

        int total = 0, rightMax = 0;
        for (int i = height.length -1; i >= 0; i--) {
            if (Math.min(rightMax, dp[i]) > height[i]) {
                total += Math.min(rightMax, dp[i]) - height[i];
            }
            rightMax = Math.max(rightMax, height[i]);
        }

        return total;
    }
}
