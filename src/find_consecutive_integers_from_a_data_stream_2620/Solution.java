package find_consecutive_integers_from_a_data_stream_2620;

import java.util.*;
class DataStream {
    Queue<Integer> que;
    Map<Integer, Integer> map;
    int value;
    int k;
    public DataStream(int value, int k) {
        que = new LinkedList<>();
        map = new HashMap<>();
        this.value = value;
        this.k = k;
    }
    
    public boolean consec(int num) {

        if(que.size()==k){
            int x = que.poll();
            map.put(x, map.get(x)-1);
            if(map.get(x)==0){
                map.remove(x);
            }
            
            map.put(num, map.getOrDefault(num,0)+1);
            que.add(num);

            if(map.size()==1 && num==value){
                return true;
            }
            return false;
        }
        map.put(num , map.getOrDefault(num, 0)+1);
        que.add(num);
        if(que.size()==k && map.size()==1 && num == value){
            return true;
        }
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */