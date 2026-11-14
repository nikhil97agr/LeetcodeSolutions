class RLEIterator {
    int encoding[];
    int i;
    int size;
    public RLEIterator(int[] encoding) {
        i=0;
        size = encoding.length;
        this.encoding = encoding;
    }
    
    public int next(int n) {
        while(i<size && n>0){
            if(encoding[i]<n){
                n-= encoding[i];
                encoding[i] = 0;
                i+=2;
            }else{
                encoding[i] -= n;
                n=0;
                return encoding[i+1];
            }
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */