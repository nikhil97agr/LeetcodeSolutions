class Solution {
    public int numberOfPairs(int[][] p) {
        int count = 0;
        Arrays.sort(p, (a,b)->{
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
            
            
        });
        
        int cnt = 0;
        int n = p.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(p[i][1] < p[j][1]){
                    continue;
                }
                boolean overlap = false;
                for(int k=0;k<n;k++){
                    if(k==i || k==j){
                        continue;
                    }
                    
                    if(isOverlap(p[i],p[j], p[k])){
                        overlap = true;
                        break;
                    }
                    
                    
                }
                if(!overlap) cnt++;
            }
        }
        return cnt;
    }
    
    private boolean isOverlap(int p1[], int p2[], int p3[]){
        int x1 = Math.min(p1[0], p2[0]);
        int x2 = Math.max(p1[0], p2[0]);        
        int y1 = Math.min(p1[1], p2[1]);
        int y2 = Math.max(p1[1], p2[1]);
        int x = p3[0];
        int y =p3[1];
        if((x >= x1  && x <= x2) && (y >= y1 && y <= y2)) return true;
        return false;

    }
}