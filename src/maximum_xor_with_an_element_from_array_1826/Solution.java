package maximum_xor_with_an_element_from_array_1826;

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        for(int x : nums){
            trie.build(x, 30);
        }
        int q= queries.length;

        int ans[] = new int[q];
        for(int i=0;i<q;i++){
            int x= queries[i][0];
            int m= queries[i][1];

            ans[i] = trie.search(x, m, 0, 30);
        }
        
        return ans;
    }

    class Trie{
        Trie trie[];


        public Trie(){
            trie = new Trie[2];
        }

        public void build(int a, int bitIndex){
            if(bitIndex == -1){
                return ;
            }

            int bit = (a >> bitIndex) & 1;
            if(trie[bit]==null){
                trie[bit] = new Trie();
            }

            trie[bit].build(a, bitIndex-1);
        }

        private int search(int x, int m, int curr, int bitIndex){
            if(bitIndex == -1){
                return x ^ curr;
            }

            int bit = (x >> bitIndex) & 1;
            if(bit == 1){
                if(trie[0] !=null){
                    int ans = trie[0].search(x, m, curr, bitIndex - 1);
                    if(ans != -1){
                        return ans;
                    }
                }

                if(trie[1] !=null){
                    int newVal = curr | (1<< bitIndex);
                    if(newVal <= m){
                        return trie[1].search(x, m, newVal, bitIndex - 1);
                    }
                }

                return -1;
            }else{
                if(trie[1] != null){
                    int newVal = curr | (1<< bitIndex);
                    if(newVal <= m){
                        int ans = trie[1].search(x, m, newVal, bitIndex - 1);
                        if(ans != -1) return ans;
                    }
                }
                
                if(trie[0] != null){
                    return trie[0].search(x, m, curr, bitIndex - 1);
                }
                
                return -1;
            }
        }
    }
}