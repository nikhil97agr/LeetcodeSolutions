class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int ans = 0;
        Trie root = new Trie();
        int n = nums.length;
        for(int i=0;i<n;i++){
            Trie curr = root;
            int cnt = 0;
            for(int j=i;j<n;j++){
                int val = nums[j];
                                if(val%p==0){
                    cnt++;
                }
                if(curr.map.containsKey(val)){
                    curr = curr.map.get(val);
                }else{
                    curr.map.put(val, new Trie());
                    if(cnt <= k) ans++;
                    curr= curr.map.get(val);
                }

            }
        }
        return ans;

    }

    class Trie {
        Map<Integer, Trie> map;
        public Trie(){
            map = new HashMap<>();
        }
    }
}