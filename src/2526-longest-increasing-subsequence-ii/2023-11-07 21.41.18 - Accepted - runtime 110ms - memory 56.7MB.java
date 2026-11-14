class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        if(nums.length==1) return 1;
        SegmentTree tree = new SegmentTree(max+1);
        int dp[] = new int[max+1];
        int ans = Integer.MIN_VALUE;
        for(int x : nums){
            int start = Math.max(0, x-k);
            int end = x-1;

            int maxLen = tree.query(start, end, 0, max, dp, 0);

            dp[x] = Math.max(dp[x], maxLen + 1);

            ans = Math.max(ans, dp[x]);

            tree.update(x, 0, 0, max ,dp, dp[x]);
        }

        return ans;
    }
}

class SegmentTree{
    int tree[];
    int size;

    public SegmentTree(int n){
        this.size = 4*n;

        tree = new int[size];
    }

    public void update(int i, int treeInd, int start, int end, int dp[],int val){
        if(start > end) return ;
        if(start==end){
            tree[treeInd] = val;
            return;
        }

        int mid = (start+end)/2;
        if(i<=mid){
            update(i, treeInd*2+1, start, mid, dp, val);
        }else{
            update(i, treeInd*2+2, mid+1, end, dp, val);
        }

        tree[treeInd] = Math.max(tree[treeInd*2+1], tree[treeInd*2+2]);
    }

    public int query(int qStart, int qEnd, int l, int r, int dp[], int treeInd){
        if(r < qStart || l > qEnd) return 0;

        if(qStart <= l && r<=qEnd) return tree[treeInd];

        int mid = (l+r)/2;

        return Math.max(query(qStart, qEnd, l, mid, dp, treeInd*2+1), query(qStart, qEnd, mid+1, r, dp ,treeInd*2+2));

    }
}