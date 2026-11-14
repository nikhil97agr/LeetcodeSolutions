package random_flip_matrix_913;

class Solution {
    int i;
    int j;
    int m;
    int n;
    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        i = j =0;
    }
    
    public int[] flip() {
        int pi = i;
        int pj = j;
        j++;
        if(j==n){
            j=0;
            i++;
        }

        if(i==m){
            i=0;
            j=0;
        }
        return new int[]{pi, pj};
    }
    
    public void reset() {
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */