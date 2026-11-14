class Solution {
    int prefix[];
    int size;
    int total;
    Random random;
    public Solution(int[] w) {
        size = w.length;
        prefix = new int[size];
        total = 0;
        for(int i=0;i<size;i++){
            total +=w[i];
            prefix[i] = total;
        }
        random = new Random();
    }
    
    public int pickIndex() {
        double rand =total*Math.random();

        int start = 0;
        int end = size-1;
        while(start < end){
            int mid = (start+end)/2;

            if(rand > prefix[mid]){
                start = mid+1;
            }else{
                end = mid;
            }
        }

        return start;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */