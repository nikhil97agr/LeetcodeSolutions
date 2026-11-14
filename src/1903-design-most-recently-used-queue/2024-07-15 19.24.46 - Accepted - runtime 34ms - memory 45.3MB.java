class MRUQueue {

    int[] a;
    public MRUQueue(int n) {
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = i+1;
        }
    }
    
    public int fetch(int k) {
        int e = a[k-1];
        for(int i=k;i<a.length;i++){
            a[i-1] = a[i];
        }
        a[a.length-1] = e;
        return e;
    }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */