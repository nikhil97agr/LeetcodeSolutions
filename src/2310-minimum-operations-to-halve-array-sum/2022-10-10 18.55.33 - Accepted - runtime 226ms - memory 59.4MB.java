class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> q = new PriorityQueue((a,b)->{
           if((double)b>(double)a){
               return 1;
           }
            return -1;
        });
        double sum = 0;
        for(int x : nums){
            sum += x;
            q.offer((double)x);
        }
double req = sum/2d;        int count = 0;
        while(req>0){
            double x = q.poll();
            x /=2;
            req-=x;
            q.offer(x);
           ++count; 
        }
        return count;
    }
}