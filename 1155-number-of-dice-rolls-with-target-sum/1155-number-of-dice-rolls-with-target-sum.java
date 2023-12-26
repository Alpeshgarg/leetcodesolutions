class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int diceRollWays[][] = new int[n+1][target + 1];
        diceRollWays[0][0] = 1;
        int mod = 1000000007;
        for(int diceNum = 1; diceNum <= n; diceNum++){
            for(int sum = 1; sum <= target; sum++){
                for(int faceNum = 1; faceNum <= Math.min(sum , k); faceNum++){
                    int prevSum = sum - faceNum;
                        diceRollWays[diceNum][sum] = (diceRollWays[diceNum][sum] % mod  + diceRollWays[diceNum-1][prevSum] % mod) % mod;
                }
            }
        }
        return diceRollWays[n][target];
    }
}