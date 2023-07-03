
💡 **Question 3**

Given two strings word1 and word2, return *the minimum number of **steps** required to make* word1 *and* word2 *the same*.

In one **step**, you can delete exactly one character in either string.

**Example 1:**

**Input:** word1 = "sea", word2 = "eat"

**Output:** 2

**Explanation:** You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

soln : //time complexity:O(m*n);
      //space complexity:O(m*n);
    class Solution {
    public int minDistance(String word1, String word2) {
       int m = word1.length();
        int n = word2.length();
        
        int[][] dp = new int[m+1][n+1];
        
        // Initialize the first row and first column
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        
        // Fill the dp array
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                }
            }
        }
        
        return dp[m][n];
    }
}