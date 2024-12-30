class Solution {
    int MOD = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        Arrays.fill(dp, -1);

        long ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + helper(dp, zero, one, i)) % MOD; 
        }

        return (int) ans;  
    }

    private long helper(long[] dp, int zero, int one, int idx) {
        if (idx < 0) {
            return 0;
        }

        if (idx == 0) {
            return 1;
        }

        if (dp[idx] != -1) {
            return dp[idx];
        }

        return dp[idx] = (helper(dp, zero, one, idx - one) + helper(dp, zero, one, idx - zero)) % MOD;
    }
}