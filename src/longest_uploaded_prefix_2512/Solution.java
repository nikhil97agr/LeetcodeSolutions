package longest_uploaded_prefix_2512;

class LUPrefix {
    boolean add[];
    int current;
    int n;
    public LUPrefix(int n) {
        this.n = n;
        add = new boolean[n+1];
        current = 1;
        
    }
    
    public void upload(int video) {
        add[video] = true;
        while(current<=n&&add[current]){
            current++;
        }
    }
    
    public int longest() {
        return current-1;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */