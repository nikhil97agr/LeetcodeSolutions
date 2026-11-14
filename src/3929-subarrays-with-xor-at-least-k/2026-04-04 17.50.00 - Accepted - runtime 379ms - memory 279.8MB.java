class Solution {
    public long countXorSubarrays(int[] nums, int k) {
        Trie trie = new Trie();
        int xor = 0;
        trie.insert(0);

        long ans = 0;
        for(int x : nums){
         xor ^= x;
         ans += trie.query(xor, k);

         trie.insert(xor);
        }

        return ans;
    }
    class Trie{
        Trie trie[];
        int cnt;
        public Trie(){
            trie = new Trie[2];
            cnt = 0;
        }

        public void insert(int val){
            Trie root= this;

            for(int i=31;i>=0 ;i--){
                int bit = (val >> i) & 1;

                if(root.trie[bit] ==null){
                    root.trie[bit] = new Trie();
                }

                root = root.trie[bit];
                root.cnt++;
            }

        }

        public int query(int prefix, int k){
            Trie root = this;

            int ans = 0;
            for(int i=31;i>=0 && root !=null;i--){
                int prefixBit = (prefix >> i) & 1;
                int kBit = (k >> i) & 1;

                if(kBit == 1){
                    root = root.trie[1 - prefixBit];
                }else{
                    if(root.trie[1- prefixBit] !=null){
                       ans += root.trie[1- prefixBit].cnt;
                    }

                    root = root.trie[prefixBit];
                }
            }

            if(root != null){
                ans += root.cnt;
            }

            return ans;
        }
    }
}