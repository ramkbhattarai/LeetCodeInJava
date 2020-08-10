package others;

public class MinChange {
	
	public static int coinChange(int[] coins, int amount) {
	    if (amount < 1) return 0;
	    return coinChange(coins, amount, new int[amount]);
	  }

	  private static int coinChange(int[] coins, int rem, int[] count) {
//		 for (int i = 0; i < count.length; i++) {
//			System.out.println(count[i]);
//		}
//		 System.out.println("next iteration");
	    if (rem < 0) return -1;
	    if (rem == 0) return 0;
	    if (count[rem - 1] != 0) return count[rem - 1];
	    int min = Integer.MAX_VALUE;
	    for (int coin : coins) {
//	    	System.out.println("coin" + coin);
//	    	System.out.println("rem"+ rem);
	      int res = coinChange(coins, rem - coin, count);
	      if (res >= 0 && res < min)
	        min = 1 + res;
//	      System.out.println("min="+ min);
	    }
	    count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
	    return count[rem - 1];
	  }
	  
	  public static void main(String[] args) {
		  int[] coins = new int[] {1,4,5};
		System.out.println("ans is" + coinChange(coins, 8));
	}

}
