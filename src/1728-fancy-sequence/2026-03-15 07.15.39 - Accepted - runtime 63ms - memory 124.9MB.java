class Fancy {
    List<Integer> list = new ArrayList<>();
    int sum = 0;
    int mul = 1;
    long mod = (long )1e9 + 7;
    public Fancy() {
        
    }
    
    public void append(int val) {
        int adjustedVal = prod(add(val, -sum), pow(mul, mod- 2));
        list.add(adjustedVal);
    }
    
    public void addAll(int inc) {
        sum = add(sum ,inc);
    }
    
    public void multAll(int m) {
        mul = prod(mul, m);
        sum = prod(sum, m);
    }
    
    public int getIndex(int idx) {
        if(idx >= list.size()) return -1;
        int val = list.get(idx);
        val = prod(val, mul);
        val=add(val, sum);

        return val;
    }

    private int pow(long a, long b){
        if(a ==1 || b==0) return 1;
        if(a==0 || b==1) return prod(a,1);


        int p = pow(a, b/2);
        p = prod(p,p);
        if(b%2==1){
            p = prod(p, a);
        }
        return p;
    }

    private int add(long a, long b){
        return (int)((a+b+mod)%mod);
    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */