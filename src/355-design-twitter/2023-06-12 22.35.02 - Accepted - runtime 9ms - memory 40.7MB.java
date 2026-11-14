class Twitter {

    class Tweet{
        int time;
        int tweetId;
        public Tweet(int time, int tweetId){
            this.time = time;
            this.tweetId = tweetId;
        }
    }
    static int timeStamp;
    HashMap<Integer, Set<Integer>> followers;
    HashMap<Integer, List<Tweet>> tweets;
    public Twitter() {
        followers = new HashMap<>();
        timeStamp = 0;
        tweets = new HashMap<>();

    }
    
    public void postTweet(int userId, int tweetId) {
        if(!tweets.containsKey(userId)){
            tweets.put(userId, new ArrayList<>());
            follow(userId, userId);
        }

        tweets.get(userId).add(0, new Tweet(timeStamp++, tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> followee = followers.get(userId);
        if(followee ==null) return result;
        PriorityQueue<Tweet> tweet = new PriorityQueue<>((a,b)-> a.time - b.time);
        for(int f : followee){
            List<Tweet> list = tweets.get(f);
            if(list==null) continue;
            for(Tweet t : list){
                if(tweet.size()<10) {
                    tweet.add(t);
                    continue;
                }
                if(t.time >tweet.peek().time){
                    tweet.poll();
                    tweet.add(t);
                }
            }
        }
        while(!tweet.isEmpty()){
            result.add(0,tweet.poll().tweetId);
        }
        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
        followers.computeIfAbsent(followerId, (id)->(new HashSet<>()));
        followers.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followers.get(followerId)==null || followerId==followeeId) return;
        followers.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */