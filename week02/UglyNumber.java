public class UglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a1 = 0, a2 = 0, a3 = 0;

        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(dp[a1] * 2, dp[a2] * 3), dp[a3] * 5);
            dp[i] = min;
            if (dp[a1] * 2 == min) a1++;
            if (dp[a2] * 3 == min) a2++;
            if (dp[a3] * 5 == min) a3++;
        }
        return dp[n-1];
    }
}
