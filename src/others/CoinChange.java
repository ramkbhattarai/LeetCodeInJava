package others;
/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind of coin.

 

Example 1:

Input: amount = 5, coins = [1, 2, 5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
Example 2:

Input: amount = 3, coins = [2]
Output: 0
Explanation: the amount of 3 cannot be made up just with coins of 2.
Example 3:

Input: amount = 10, coins = [10] 
Output: 1
 * @author ramkrishnabhattarai
 *
 */

public class CoinChange {
	
	public int change(int amount, int[] coins) {
        int arr[] = new int[amount+1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        for(int c : coins)
            for(int i = c; i <= amount; i++)
                arr[i] += arr[i-c];
        return arr[amount];
    }
	
	
	public int change2(int amount, int[] coins) {
		int[][] dp = new int[coins.length + 1][amount + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= coins.length; i++) {
			dp[i][0] = 1;
			for (int currAmt = 1; currAmt <= amount; currAmt++) {
				int coinVal = coins[i - 1];
				int leaveThisCoin = dp[i - 1][currAmt];
				if (coinVal > currAmt) {
					dp[i][currAmt] = leaveThisCoin;
				} else {
					int takeThisCoin = dp[i][currAmt - coinVal];
					dp[i][currAmt] = leaveThisCoin + takeThisCoin;
				}
			}
		}
		return dp[coins.length][amount];
	}

}
