class Solution {
    int months[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int alice[] = new int[]{day(arriveAlice), day(leaveAlice)};
        int bob[] = new int[]{day(arriveBob), day(leaveBob)};

        if(alice[0] > bob[1] || bob[0] > alice[1]) return 0;

        int start = Math.max(alice[0], bob[0]);
        int end = Math.min(alice[1], bob[1]);

        return end - start + 1;
    }

    private int day(String s){
        int day = 0;

        int m = Integer.parseInt(s.substring(0, 2));
        int d = Integer.parseInt(s.substring(3));

        for(int i=0;i<m-1;i++){
            day += months[i];
        }
        
        return day + d;
    }
}