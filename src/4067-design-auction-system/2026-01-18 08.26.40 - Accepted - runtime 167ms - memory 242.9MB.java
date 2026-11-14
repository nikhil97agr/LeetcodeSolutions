class AuctionSystem {
    Map<Integer, Map<Integer, Integer>> user = new HashMap<>();
    Map<Integer, TreeMap<Integer, TreeSet<Integer>>> item = new HashMap<>();
    public AuctionSystem() {
        
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {
        int prev = user.getOrDefault(userId, new HashMap<>()).getOrDefault(itemId, -1);

        if(prev != -1){
            remove(user, userId, itemId, prev);
            removeI(item, prev, userId, itemId);
        }

        add(user, userId, itemId, bidAmount);
        addI(item, bidAmount, userId, itemId);
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        int prev = user.get(userId).get(itemId);
        removeI(item, prev, userId, itemId);
        addI(item, newAmount, userId, itemId);
        remove(user, userId, itemId, prev);
        add(user, userId, itemId, newAmount);
    }
    
    public void removeBid(int userId, int itemId) {
        int val = user.get(userId).get(itemId);

        removeI(item, val, userId, itemId);
        remove(user, userId, itemId, val);
    }
    
    public int getHighestBidder(int itemId) {
        if(!item.containsKey(itemId)) return -1;

        return item.get(itemId).lastEntry().getValue().last();
    }

    private void add(Map<Integer, Map<Integer, Integer>> map, int user, int item, int val){
        map.computeIfAbsent(user, u-> new HashMap<>()).put(item, val);
    }
    private void remove(Map<Integer, Map<Integer, Integer>> map, int user, int item, int val){
        if(!map.containsKey(user)) return;
        Map<Integer, Integer> m = map.get(user);
        if(!m.containsKey(item)) return;
        m.remove(item, val);

        if(m.isEmpty()){
            map.remove(user);
        }
    }
    private void addI(Map<Integer, TreeMap<Integer, TreeSet<Integer>>> map, int val, int user, int item){
        map.computeIfAbsent(item, x-> new TreeMap<>())
            .computeIfAbsent(val, y -> new TreeSet<>()).add(user);
    }

    private void removeI( Map<Integer, TreeMap<Integer, TreeSet<Integer>>> map, int val, int user, int item){
        if(!map.containsKey(item)) return;
        TreeMap<Integer, TreeSet<Integer>> m = map.get(item);
        if(!m.containsKey(val)) return ;
        TreeSet<Integer> set = m.get(val);
        set.remove(user);
        if(set.isEmpty()){
            m.remove(val);
            if(m.isEmpty()){
                map.remove(item);
            }
        }
    }


}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */