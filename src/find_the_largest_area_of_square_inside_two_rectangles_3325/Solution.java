package find_the_largest_area_of_square_inside_two_rectangles_3325;

class Solution {
    public long largestSquareArea(int[][] b, int[][] t) {
        long ans = 0;
        int n = b.length;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int b1[] = b[i];
                int b2[] = b[j];
                int t1[] = t[i];
                int t2[] = t[j];
                
                int bot[] = new int[]{max(b1[0], b2[0]), max(b1[1], b2[1])};
                int top[] = new int[]{min(t1[0], t2[0]), min(t1[1], t2[1])};
                
                if(top[0] < bot[0] || top[1] < bot[1]) continue;
                
                int h = Math.abs(top[0] - bot[0]);
                int v = Math.abs(top[1] - bot[1]);
                int s = Math.min(h,v);
                ans = Math.max(ans, 1L*s*s);
            }
        }
        
        return ans;
    }
    
    private int max(int a, int b){
        return Math.max(a,b);
    }
    
    private int min(int a, int b){
        return Math.min(a,b);
    }
}