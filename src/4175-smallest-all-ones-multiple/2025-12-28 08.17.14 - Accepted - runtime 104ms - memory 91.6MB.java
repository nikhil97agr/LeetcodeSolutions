class Solution {
    public int minAllOneMultiple(int k) {
        if(k%2==0 || k%5==0) return -1;

        int dig = 1;
        int num = 1;
        Set<Integer> vis = new HashSet<>();

        while(true){
            int rem = num%k;
            if(rem == 0) return dig;
            if(vis.contains(rem)) return -1;
            vis.add(rem);
            dig++;
            num = rem *10 + 1;
            
        }

        
    }
}