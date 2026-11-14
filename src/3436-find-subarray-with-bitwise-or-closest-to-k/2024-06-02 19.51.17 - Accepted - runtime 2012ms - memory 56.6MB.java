class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;

        Tree tree = new Tree(nums, n);
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int start = i-1;
            int end = n-1;
            
            while(end - start > 1){
                int mid = start + (end - start)/2;
                if(tree.query(0, 0, n-1, i, mid) >= k){
                    start = mid;
                }else{
                    end = mid;
                }
            }

            if(start != i-1){
                ans = Math.min(ans, Math.abs(tree.query(0, 0, n-1, i, start) - k));
            }
                ans = Math.min(ans, Math.abs(k - tree.query(0, 0, n-1, i ,end)));
            

        }
        return ans;
    }

    class Tree{
        int seg[];
        int n;

        public Tree(int arr[], int n){
            this.n = n;
            seg = new int[4*n];

            build(arr, 0, 0, n-1);
        }

        public void build(int arr[], int curr, int start, int end){
            if(start == end){
                seg[curr] = arr[start];
                return;
            }

            int mid = start + (end - start)/2;

            build(arr, 2*curr+1, start, mid);
            build(arr, 2*curr + 2, mid+1, end);

            seg[curr] = seg[2*curr+1] & seg[2*curr+2];
        }

        public int query(int curr, int start, int end, int l, int r){
            if(r < start || end < l){
                return Integer.MAX_VALUE;
            }

            if(l <= start && end <= r){
                return seg[curr];
            }

            int mid = start + (end - start)/2;
            int left = query(2*curr +1, start, mid, l ,r);
            int right = query(2*curr+2, mid+1, end, l, r);
            return left&right;
        }
    }
}