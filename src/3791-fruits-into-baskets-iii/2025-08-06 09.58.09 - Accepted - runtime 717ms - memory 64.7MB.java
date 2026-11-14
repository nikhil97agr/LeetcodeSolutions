class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int ans = 0;
        SegmentTree tree = new SegmentTree(baskets);
        for(int x : fruits){
            ans += find(x, tree, fruits.length);
        }


        return ans;
    }

    private int find(int val, SegmentTree tree, int n){
        int start = 0;
        int end = n -1;
        int ans = -1;

        while(start <= end){
            int mid = (start + end)/2;

            int next = tree.query(0, n-1, 0, mid, 0);

            if(next >= val){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }


        if(ans == -1) return 1;
        else{
            tree.update(0, n-1, ans, 0, 0);
            return 0;
        }
    }

    class SegmentTree{
        int tree[];
        int size;

        public SegmentTree(int arr[]){
            this.size = arr.length*4;
            tree= new int[size+1];

            build(arr, 0, arr.length-1, 0);
        }

        private void build(int arr[], int start, int end, int ind){
            if(start == end){
                tree[ind] = arr[start];
                return;
            }

            int mid = (start+end) /2;

            build(arr, start, mid, 2*ind +1);
            build(arr, mid+1, end, 2*ind + 2);

            tree[ind] = Math.max(tree[2*ind + 1], tree[2*ind +2]);
        }

        private int query(int start, int end, int qstart, int qend, int ind){
            if(qend < start || end < qstart) return 0;

            if(qstart <= start && end <= qend){
                return tree[ind];
            }

            int mid = (start+end)/2;
            return Math.max(query(start, mid, qstart, qend, 2*ind + 1), query(mid+1, end, qstart, qend, 2*ind + 2));
        }

        private void update(int start, int end, int i, int ind, int val){
            if(i < start || i > end) return ;

            if(start == end){
                tree[ind] = val;
                return;
            }

            int mid = (start + end ) /2;
            int left = 0;
            int right = 0;
            if(i<=mid){
                update(start, mid, i, 2*ind + 1, val);
            }else{
                update(mid+1, end, i, 2*ind +2, val);
            }

            tree[ind] = Math.max(tree[2*ind + 1], tree[2*ind + 2]);
        }
    }
}