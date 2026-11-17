package average_waiting_time_1803;

class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long total = 0;
        int next = 0;
        for(int cust[] : customers){
            if(cust[0] >= next){
                total += cust[1];
                next = cust[0] + cust[1];
            }else{
                total += (next- cust[0]) + cust[1];
                next += cust[1];
            }
        }

        return (1d*total)/(1d*n);
    }
}