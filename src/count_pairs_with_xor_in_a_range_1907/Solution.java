package count_pairs_with_xor_in_a_range_1907;

class Solution {
    public int countPairs(int[] nums, int low, int high) {
        int ans = 0;
        Trie trie = new Trie();
        for(int x : nums){
            trie.add(x, 15);
        }

        for(int x : nums){
            trie.remove(x, 15);
            ans += trie.search(x, high,  15) - trie.search(x, low-1,  15);
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

        public int search(int val, int limit,  int bitIndex){
            if(bitIndex == -1){
                return cnt;
            }

            int b1 = (val >> bitIndex) & 1;
            int lim = (limit >> bitIndex) & 1;
            if(lim == 1){
                int ans = 0;
                if(trie[b1]!=null){
                    ans += trie[b1].cnt;
                }

                if(trie[1-b1]!=null){
                    ans += trie[1-b1].search(val, limit, bitIndex - 1);
                }

                return ans;
            }else{
                if(trie[b1] != null){
                    return trie[b1].search(val, limit, bitIndex - 1);
                }

                return 0;
            }
        }

        public void add(int val, int bitIndex){
            cnt++;
            if(bitIndex == -1){
                return;
            }


            int bit = (val >> bitIndex ) & 1;
            if(trie[bit] == null){
                trie[bit] = new Trie();
            }

            trie[bit].add(val, bitIndex - 1);
        }

        public void remove(int val, int bitIndex){
            cnt--;
            if(bitIndex == -1){
                return;
            }

            int bit = (val >> bitIndex) & 1;
            trie[bit].remove(val, bitIndex-1);
            if(trie[bit].cnt == 0){
                trie[bit] = null;
            }
        }
    }
}