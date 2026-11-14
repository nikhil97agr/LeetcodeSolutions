import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        SegmentTree tree = new SegmentTree(n);

        int ans = 0;
        for(int i=0;i<n;i++){
            int val = nums[i];
            int diff= nums[i]%2==0 ?  1 : -1;

            if(map.containsKey(val)){
                int ind= map.get(val);
                tree.update(1, 0, n-1, 0, ind, -diff);
            }
            tree.update(1, 0, n-1, 0, i, diff);
            map.put(val, i);

            int leftIndex = tree.search(1, 0, n-1);

            if(leftIndex !=-1){
                ans = Math.max(ans, i - leftIndex + 1);
            }

        }

        return ans;
    }

    class SegmentTree{
        int min[];
        int max[];
        int lazy[];

        public SegmentTree(int n){
            min = new int[n*4];
            max = new int[n*4];
            lazy = new int[n*4];
        }

        private void pushToChild(int node, int arrStart, int arrEnd){
            if(lazy[node] != 0){
                min[node] += lazy[node];
                max[node] += lazy[node];

                if(arrStart != arrEnd){
                    lazy[2 * node] += lazy[node];
                    lazy[2*node + 1] += lazy[node];
                }
                lazy[node] =0;
            }
        }

        public void update(int node, int arrStart, int arrEnd, int qStart, int qEnd,  int val){
            pushToChild(node, arrStart, arrEnd);

            if(qStart > arrEnd || qEnd < arrStart){
                return;
            }

            if(qStart <= arrStart && arrEnd <= qEnd){
                lazy[node] += val;
                pushToChild(node, arrStart, arrEnd);
                return;
            }

            int mid = (arrStart + arrEnd) / 2;

            update(2 * node, arrStart, mid, qStart, qEnd, val);
            update(2 * node + 1, mid + 1, arrEnd, qStart, qEnd, val);

            min[node] = Math.min(min[2 * node], min[2 * node + 1]);
            max[node] = Math.max(max[2 * node], max[2 * node + 1]);
        }

        public int search(int node, int qStart, int qEnd){
            pushToChild(node, qStart, qEnd);
            if(min[node] > 0 || max[node] < 0) return -1;
            if(qStart == qEnd){
                return min[node] ==0 ? qStart : -1;
            }

            int mid = (qStart + qEnd)/2;
            
            int leftVal = search(2 * node, qStart, mid);
            if(leftVal !=-1) return leftVal;
            
            return search(2 * node + 1, mid + 1, qEnd);

        }
    }
}