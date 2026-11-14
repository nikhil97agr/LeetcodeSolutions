class ExamRoom {
    int n;
    TreeSet<Integer> set;
    public ExamRoom(int n) {
        this.n = n;
        set =new TreeSet<>();
    }
    
    public int seat() {
        if(set.isEmpty()){
            set.add(0);
            return 0;
        }

        int prev = -1;
        int dist = set.first();
        int requiredSeat= 0;

        for(int s : set){
            if(prev==-1){
                prev = s;
            }else{
                int d = (s - prev)/2;
                if(d > dist){
                    dist= d;
                    requiredSeat = prev + d;
                }
                prev = s;
            }
        }

        int last = set.last();

        if((n-1) - last > dist){
            requiredSeat = n-1;
        }

        set.add(requiredSeat);
        return requiredSeat;


    }
    
    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */