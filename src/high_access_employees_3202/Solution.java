package high_access_employees_3202;

import java.util.*;
class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> result = new ArrayList<>();

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        for(List<String> list : access_times){
            String id = list.get(0);
            int min = minute(list.get(1));

            map.computeIfAbsent(id, x -> new PriorityQueue<>()).add(min);
        }
        System.out.println(map);
        for(String id : map.keySet()){
            PriorityQueue<Integer> que = map.get(id);
            Queue<Integer> q = new LinkedList<>();
            while(!que.isEmpty()){
                int next = que.poll();
                q.offer(next);
                while(q.size() >= 3 && q.peek() <= next - 60) q.poll();
                if(q.size() >=3){
                    result.add(id);
                    break;
                }
            }
        }

        return result;
    }

    private int minute(String s){
        int hr = (s.charAt(0) - '0')*10 + (s.charAt(1) - '0');
        int min = (s.charAt(2) - '0')*10 + (s.charAt(3) - '0');

        return hr * 60 + min;
    }
}