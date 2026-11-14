class NumArray {

    int seg[];
    int size;
    int nums[];
    int n;
    public NumArray(int[] nums) {
        int n = nums.length;
        this.n = n;
        this.nums = nums;
        if((n&(n-1))==0){
            size = n*2-1;
        }else{
            int x = (int)(Math.log(n)/Math.log(2));
            x++;
            size = ((int)Math.pow(2, x)*2)-1;
        }
        seg = new int[size];
        buildTree(nums, 0, n-1, 0);
        
    }
    
    public void buildTree(int nums[], int start, int end, int pos){
        if(start==end){
            seg[pos] = nums[start];
            return;
        }
        int mid = (start+end)/2;
        
         buildTree(nums, start, mid, 2*pos+1);
       buildTree(nums, mid+1, end, 2*pos+2);
        
        seg[pos] = seg[2*pos+1] + seg[2*pos+2];
    }
    
    public void update(int index, int val) {
        updateTree(index, val, 0, n-1, 0);
        
    }
    
    public void updateTree(int index, int val, int start, int end, int pos){
        if(start==end){
            seg[pos] = val;
            return;
        }
        int mid = (start+end)/2;
        if(index<start || index>end){
            return;
        }
        
        if(index>=start && index<=mid)
    updateTree(index, val, start, mid, 2*pos+1);
else
    updateTree(index, val, mid+1, end, 2*pos+2);

        seg[pos] = seg[2*pos+1] + seg[2*pos+2];
        
    }
    
    public int sumRange(int left, int right) {
        return query(left, right, 0, n-1,0);
    }
    
    public int query(int qStart, int qEnd, int start, int end, int pos){
        if(qStart>end || qEnd<start){
            return 0;
        }
        if(qStart<=start && qEnd >=end){
            return seg[pos];
        }
        int mid = (start+end)/2;
        int left = query(qStart, qEnd, start, mid, 2*pos+1);
        int right = query(qStart, qEnd, mid+1, end, 2*pos+2);
        
        return left + right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */