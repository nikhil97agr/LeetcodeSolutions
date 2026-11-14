class Solution {
        int maxBit = 15;

    public int maxXor(int[] nums, int k) {
        int n= nums.length;
        int pre[] = new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] ^ nums[i];
        }
        var tree = new TreeMap<Integer, Integer>();
        
        int ans = Arrays.stream(nums).max().getAsInt();
        var start =0;
        var end = 0;
        Trie trie = new Trie();
        trie.insert(0, maxBit);
        boolean zeroRemoved = false;
        while(end < n){
            tree.merge(nums[end], 1, Integer::sum);
            trie.insert(pre[end + 1], maxBit);

            while(tree.lastKey() - tree.firstKey() >k){

                remove(tree, nums[start]);
                trie.remove(pre[start ], maxBit);
                start++;
            }

            ans = Math.max(ans, trie.search(pre[end + 1], maxBit));
            end++;
        }

        return ans;
    }

    public void remove(Map<Integer, Integer> map, int val){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);

    }


    class Trie{
        Trie[] trie;
        int cnt = 0;
        public Trie(){
            trie = new Trie[2];
        }

        public void insert(int val, int bit){
            cnt++;
            if(bit == -1){
                return;
            }

            int b = (val >> bit) & 1;
            if(trie[b] ==null){
                trie[b] = new Trie();
            }

            trie[b].insert(val, bit - 1);
        }

        public void remove(int val, int bit){
            cnt--;
            if(bit == -1) return;

            int b = (val >> bit) & 1;
            trie[b].remove(val, bit -1);
            if(trie[b].cnt == 0) trie[b] = null;
        }

        public int search(int val, int bit){
            if(bit ==-1) return 0;

            int b = (val >> bit) & 1;

            int xor = b ^ 1;

            if(trie[xor] !=null){
                return (1 << bit) | trie[xor].search(val, bit -1);
            }

            if(trie[b] !=null){
                return trie[b].search(val, bit - 1);
            }

            return 0;
        }
    }
}

/**


3 - 011
4 - 100

 */