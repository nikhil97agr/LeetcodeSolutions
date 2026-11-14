class Bitset {
    int setCount;
    int bits[];
    int n;
    boolean flip;
    public Bitset(int size) {
        this.n = size;
        bits = new int[n];
        setCount = 0;
        flip = false;
    }
    
    public void fix(int idx) {
        if(flip){
            if(bits[idx]==1){
                setCount++;
                bits[idx]=0;
            }
        }else{
            if(bits[idx]==0){
                setCount++;
                bits[idx] = 1;
            }
        }
    }
    
    public void unfix(int idx) {
        if(flip){
            if(bits[idx]==0){
                setCount--;
                bits[idx] = 1;
            }
        }else{
            if(bits[idx] == 1){
                setCount--;
                bits[idx] = 0;
            }
        }
    }
    
    public void flip() {
        flip = !flip;
        setCount = n-setCount;
    }
    
    public boolean all() {
        if(setCount==n){
            return true;
        }
        return false;
    }
    
    public boolean one() {
        if(setCount>0){
            return true;
        }
        return false;
    }
    
    public int count() {
        return setCount;
    }
    
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int x : bits){
            if(flip){
                if(x==1){
                    result.append(0);
                    
                }else{
                    result.append(1);
                }
                continue;
                
            }
            result.append(x);
        }
        return result.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */