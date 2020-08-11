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
	
	
	
	public boolean wordBreak(String s, List<String> wordDict) {        
        return bckTrck(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }
    
    public boolean bckTrck(String s, Set<String> dict, int idx, Boolean[] memo) {
        if (idx == s.length()) return true;
        
        if (memo[idx] != null) return memo[idx];
        
        for (int end = idx + 1; end <= s.length(); end++) {
            if (dict.contains(s.substring(idx, end)) && bckTrck(s, dict, end, memo)){
                memo[idx] = true;
                return true;
            } 
        }
        
        memo[idx] = false;
        return false;
    }
    
    
    public boolean wordBreak(String s, List<String> wordDict) {        
        Set<String> dict = new HashSet<>(wordDict);
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        q.offer(0);
        
        while(!q.isEmpty()) {
            int start = q.poll();
            
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dict.contains(s.substring(start, end))) {  
                        if (end == s.length()) return true;
                        
                        q.offer(end);
                    }
                }
                
                visited[start] = true;
            }
        }
        
        return false;
    }

}
