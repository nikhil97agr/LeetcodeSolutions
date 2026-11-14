package jump_game_iv_1447;

import java.util.*;
class Solution {
    public int minJumps(int[] arr) {
        var map = new HashMap<Integer, List<Integer>>();
        var n =arr.length;
        for(int i=0;i<n;i++){
            map.computeIfAbsent(arr[i], x-> new ArrayList<>()).add(i);
        }

        var vis = new HashSet<Integer>();
        var que = new LinkedList<Integer>();
        int total = 0;

        que.offer(0);
        vis.add(0);


        while(!que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int next = que.poll();
                if(next == n-1) return total;
                int val = arr[next];

                if(next + 1 < n && !vis.contains(next + 1)){
                    vis.add(next +1);
                    que.offer(next + 1);
                }

                if(next -1 >=0 && !vis.contains(next - 1)){
                    vis.add(next - 1);
                    que.offer(next - 1);
                }

                if(!map.containsKey(val)) continue;

                for(var ind : map.get(val)){
                    if(!vis.contains(ind)){
                        vis.add(ind);
                        que.offer(ind);
                    }
                }

                map.remove(val);
            }
            total++;
        }


        return -1;
    }
}