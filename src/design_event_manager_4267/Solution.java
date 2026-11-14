package design_event_manager_4267;

import java.util.*;
class EventManager {
    TreeMap<Integer, TreeSet<Integer>> map;
    Map<Integer, Integer> old;
    public EventManager(int[][] events) {


        map = new TreeMap<>();
        old = new HashMap<>();

        for(int e[] : events){
            old.put(e[0], e[1]);
            map.computeIfAbsent(e[1], x-> new TreeSet<>()).add(e[0]);
        }

        
    }
    
    public void updatePriority(int eventId, int newPriority) {
        int prev = old.get(eventId);
        map.get(prev).remove(eventId);
        if(map.get(prev).isEmpty()) map.remove(prev);
        map.computeIfAbsent(newPriority, x-> new TreeSet<>()).add(eventId);
        old.put(eventId, newPriority);
    }
    
    public int pollHighest() {
        if(map.isEmpty()){
            return -1;
        }

        var last = map.lastEntry();
        int event = last.getValue().removeFirst();


        old.remove(event);
        if(map.get(last.getKey()).isEmpty()){
            map.remove(last.getKey());
        }

        return event;
    }
}

/**
 * Your EventManager object will be instantiated and called as such:
 * EventManager obj = new EventManager(events);
 * obj.updatePriority(eventId,newPriority);
 * int param_2 = obj.pollHighest();
 */