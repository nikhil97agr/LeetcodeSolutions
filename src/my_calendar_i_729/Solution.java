package my_calendar_i_729;

import java.util.*;
class MyCalendar {

    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        map = new TreeMap<Integer, Integer>();
    }
    
    public boolean book(int start, int end) {
        
        Integer floorKey = map.floorKey(start);
        Integer ceilKey = map.ceilingKey(start);
        
        if(floorKey==null && ceilKey==null){
            map.put(start, end);
            return true;
        }
        if(floorKey !=null)
        {
            int s = floorKey;
            int e = map.get(s);
            if(e>start){
                return false;
            }
        }
        if(ceilKey!=null){
            int s = ceilKey;
            int e = map.get(s);
            if(s<end){
                return false;
            }
        }
        map.put(start, end);
        return true;
        
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */