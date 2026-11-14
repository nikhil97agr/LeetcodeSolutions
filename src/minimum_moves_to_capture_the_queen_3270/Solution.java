package minimum_moves_to_capture_the_queen_3270;

class Solution {
    public int minMovesToCaptureTheQueen(int a, int b1, int c, int d, int e, int f) {
        int r[] = new int[]{a,b1};
        int b[] = new int[]{c,d};
        int q[] = new int[]{e,f};
        
        if(r[0] == q[0]){
            if(b[0]!=r[0] || !(b[1] > Math.min(r[1], q[1]) && b[1] < Math.max(r[1], q[1]))) return 1;
            else return 2;
        }
        
        if(r[1] == q[1]){
            if(b[1]!=r[1] || !(b[0] > Math.min(r[0], q[0]) && b[0] < Math.max(r[0], q[0]))) return 1;
            else return 2;
        }
            
        
        int x = b[0];
        int y = b[1];
        
        while(x>0 && y>0){
            if(x==r[0] && y==r[1]) break;
            if(x== q[0] && y==q[1]) return 1;
            x--;
            y--;
        }
        
        x = b[0];
        y = b[1];
        while(x >0 && y <=8){
            if(x==r[0] && y==r[1]) break;
            if(x==q[0] && y==q[1]) return 1;
            x--;
            y++;
        }
        
        x = b[0];
        y = b[1];
        while(x <= 8 && y <= 8){
            if(x==r[0] && y==r[1]) break;
            if(x==q[0] && y==q[1]){
                return 1;
            }
            x++;
            y++;
        }
        
        x = b[0];
        y = b[1];
        while(x <=8 && y>0){
            if(x==r[0]&&y==r[1]) break;
            if(x==q[0] && y==q[1]) return 1;
            x++;
            y--;
        }
        
        return 2;
    }
    
}