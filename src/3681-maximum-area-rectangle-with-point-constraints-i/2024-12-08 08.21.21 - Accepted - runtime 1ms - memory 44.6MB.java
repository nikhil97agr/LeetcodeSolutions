class Solution {
    public int maxRectangleArea(int[][] points) {
        int ans = -1;

        int n = points.length;
        if(n < 4) return -1;
        for(int i=0;i<n;i++){
            int p1[] = points[i];
            for(int j=0;j<n;j++){
                if(i!=j){
                    int p2[] = points[j];
                    if(p1[1] == p2[1] && p1[0] < p2[0]){
                        for(int k=0;k<n;k++){
                            int p3[] = points[k];
                            if(i!=k && k!=j){
                                if(p3[0] == p1[0] && p1[1] < p3[1]){
                                    for(int l=0;l<n;l++){
                                        int p4[] = points[l];
                                        
                                        if(l!=i && l!=j && l!=k){
                                            if(p2[0] == p4[0] && p4[1] == p3[1]){
                                                if(n ==4 || !between(p1, p2, p3, p4, points, i,j,k,l)){
                                                    int x = p2[0] - p1[0];
                                                    int y = p3[1] - p1[1];
                                                    ans = Math.max(ans, x*y);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
    
    private boolean between(int p1[], int p2[], int p3[], int p4[], int points[][], int i, int j, int k, int l){
        for(int ind =0;ind<points.length;ind++){
            if(ind !=i && ind !=j && ind !=k && ind !=l){
                int x1 = p1[0];
                int x2 = p2[0];
                int y1 = p1[1];
                int y2 = p3[1];
                int p[] = points[ind];
                if(p[0] >= x1 && p[0] <= x2 && p[1] >= y1 && p[1] <= y2) return true;
            }
            
        }
        
        return false;
    }
}