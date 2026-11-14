class Solution {
    public int minimumCardPickup(int[] cards) {

        
        int n = cards.length;
        if(n==1){
            return -1;
        }
        if(n==2){
            if(cards[0]==cards[1]){
                return 2;
            }
        }
        HashMap<Integer, Integer>map = new HashMap();
        map.put(cards[0], 0);
        int min_length = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            
            if(map.containsKey(cards[i])){
                min_length = Math.min(min_length, i-map.get(cards[i])+1);
                map.put(cards[i], i);
            }else{
                map.put(cards[i], i);
            }
            
        }
        if(min_length == Integer.MAX_VALUE){
            return -1;
        }
        return min_length;
    }
}