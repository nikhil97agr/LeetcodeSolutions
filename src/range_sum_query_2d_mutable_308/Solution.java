package range_sum_query_2d_mutable_308;


class NumMatrix {
    int n;
    int m;
    SegmentTree tree[];
    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        tree= new SegmentTree[n];
        for(int i=0;i<n;i++){
            tree[i] = new SegmentTree(m, matrix[i]);
        }
        
        
    }

    public void update(int row, int col, int val) {
        tree[row].update(1, col, val, 0, m-1);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for(int i=row1;i<=row2;i++){
            ans += tree[i].query(1, 0, m-1, col1, col2);
        }
        
        return ans;
    }
}

class SegmentTree{
    int tree[];
    
    public SegmentTree(int n, int arr[]){
        tree = new int[n*4];
        
        build(1, 0, arr.length - 1, arr);
    }
    
    private void build(int treeNode, int start, int end, int arr[]){
        if(start > end){
            return;
        }
        if(start == end){
            tree[treeNode] = arr[start];
            
            return;
        }
        
        int mid = (start + end)/2;
        
        build(2 * treeNode, start, mid, arr);
        build(2 * treeNode + 1, mid+1, end, arr);
        
        tree[treeNode] = tree[2 * treeNode + 1] + tree[2 * treeNode];
        
        
    }
    
    public int query(int node, int start, int end, int ql, int qr){
        if(qr < start || ql > end) return 0;
        
        if(ql <= start && end <= qr){
            return tree[node];
        }
        
        int mid = (start +end)/2;
        return query(2 * node, start, mid, ql, qr) + query(2 * node + 1, mid +1, end, ql, qr);
    }
    
    public void update(int node, int idx, int val, int start, int end){
        if(start == end){
            tree[node] = val;
            return;
        }
        
        int mid = (start + end)/2;
        
        if(idx <= mid){
            update(node * 2, idx, val ,start, mid);
        }else{
            update(2 * node + 1, idx, val, mid + 1, end);
        }
        
        tree[node] = tree[2 * node] + tree[2 * node + 1];
    }
}
