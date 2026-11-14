class Solution {
    public int nthUglyNumber(int n) {
        
        TreeSet<Long> set = new TreeSet<>();
        set.add(1l);

        while(true){
            long next = set.removeFirst();

            if(n==1) return (int)next;
            n--;
            set.add(next*2);
            set.add(next*3);
            set.add(next*5);
        }

    }
}