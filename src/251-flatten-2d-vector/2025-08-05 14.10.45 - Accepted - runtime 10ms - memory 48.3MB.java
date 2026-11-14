class Vector2D {
    int i=0;
    int j=0;
    int v[][];
    public Vector2D(int[][] vec) {
        v =vec;
    }
    
    public int next() {
        
        int ans = v[i][j];
        j++;
        if(j==v[i].length){
            j=0;
            i++;
        }

        return ans;
    }
    
    public boolean hasNext() {
        while( i < v.length && j == v[i].length){
            i++;
            j=0;
        }
        if( i < v.length && j < v[i].length){
            return true;
        }

        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */