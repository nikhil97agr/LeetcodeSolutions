package my_calendar_iii_732;

import java.util.*;
class MyCalendarThree {
    TreeMap<Integer, Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int startTime, int endTime) {
        map.merge(startTime, 1, Integer::sum);
        map.merge(endTime, -1, Integer::sum);

        int ans = 0;
        int total =0;
        for(int v :map.values()){
            total += v;
            ans = Math.max(ans, total);
        }

        return ans;


    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */