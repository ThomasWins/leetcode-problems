class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        int max = 0;

        //long * dp = calloc(sizeof(long long), 200001);
        ///////////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < n; i++){
            max = Math.max(max, questions[i][1]);
        }

        long[] dp = new long[max + n+1];
        ///////////////////////////////////////////////////////////////////////////////

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(questions[i][0] + dp[questions[i][1] + i + 1], dp[i + 1]);
        }
        return dp[0];
    }
}
