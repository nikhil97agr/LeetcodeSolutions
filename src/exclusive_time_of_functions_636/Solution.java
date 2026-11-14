package exclusive_time_of_functions_636;

import java.util.*;
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];
        int prevEndTime = 0;
        for(String l : logs){
            String res[] = l.split(":");

            int id = Integer.parseInt(res[0]);
            int time = Integer.parseInt(res[2]);
        
            if(res[1].equals("start")){
                if(stack.isEmpty()){
                    stack.push(id);
                    prevEndTime = time;
                }else{
                    int i = stack.peek();
                    map.merge(i, time - prevEndTime, Integer::sum);
                    stack.push(id);
                    prevEndTime = time;
                }
            }else{
                stack.pop();
                map.merge(id, time - prevEndTime + 1, Integer::sum );
                prevEndTime = time + 1;
            }
        }

        for(int id : map.keySet()){
            ans[id] = map.get(id);
        }

        return ans;
    }
}