import java.util.Arrays;

class Solution {

    public int maximumStrongPairXor(int[] nums) {

        var trie = new Trie();
        Arrays.sort(nums);
        int n = nums.length;
        var ans = 0;
        var j = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int y = 2 * x;
            while (j < n && nums[j] <= y) {
                trie.add(nums[j], 20);
                j++;
            }

            ans = Math.max(ans, trie.query(x, 20));
            trie.remove(nums[i], 20);
        }

        return ans;
    }

    class Trie {

        Trie trie[];
        int cnt ;

        public Trie() {

            trie = new Trie[2];
            int cnt = 0;

        }

        public int query(int num, int bit) {

            if (bit == -1) {
                return 0;
            }

            int b = (num >> bit) & 1;

            int req = b ^ 1;
            if (trie[req] != null) {
                return (1 << bit) | trie[req].query(num, bit - 1);
            } else if (trie[b] != null) {
                return trie[b].query(num, bit - 1);
            }

            return 0;
        }
        
        public void remove(int num, int bit){
            cnt--;
            if(bit == -1){
                return;
            }
            
            var b = (num >> bit) & 1;
            
            trie[b].remove(num, bit - 1);
            if(trie[b].cnt == 0){
                trie[b] = null;
            }
            
        }

        public void add(int num, int bit) {
            cnt++;
            if (bit == -1) {
                return;
            }

            int b = (num >> bit) & 1;
            if (trie[b] == null) {
                trie[b] = new Trie();
            }

            trie[b].add(num, bit - 1);
        }
    }
}

/**

x <= y

=> y - x <= x
=> y <= 2*x

 */