class Leaderboard {
    Map<Integer, Integer> playerMap;
    Map<Integer, Integer> scoreMap;
    public Leaderboard() {
        playerMap = new HashMap<>();
        scoreMap = new TreeMap<>(Collections.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        if(playerMap.containsKey(playerId)){
            int prev = playerMap.get(playerId);

            scoreMap.merge(prev, -1, Integer::sum);
            if(scoreMap.get(prev) ==0) scoreMap.remove(prev);
            playerMap.put(playerId, prev + score);
            scoreMap.merge(prev + score, 1, Integer::sum);
        }else{
            scoreMap.merge(score, 1, Integer::sum);
            playerMap.put(playerId, score);
        }
    }
    
    public int top(int k) {
        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : scoreMap.entrySet()){
            int cnt = Math.min(k, entry.getValue());

            k -= cnt;
            ans += cnt * entry.getKey();
            if(k==0) break;
        }

        return ans;
    }
    
    public void reset(int playerId) {
        int score= playerMap.get(playerId);

        playerMap.remove(playerId);

        scoreMap.merge(score, -1, Integer::sum);
        if(scoreMap.get(score) ==0) scoreMap.remove(score);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */