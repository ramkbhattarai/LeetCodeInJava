package others;

public class WordBreak {
	
	public boolean wordBreak1(String s, List<String> wordDict) {        
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1]; // Don't forget +1 or you'll get an index out of bounds error for dp[s.length()]
        dp[0] = true;
        
        for (int end = 0; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && dict.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break; // Optional: Prevents unneccesary cycles after solution is found
                }
            }
        }
        
        return dp[s.length()];
    }

}
