package sequence_reconstruction_444;

import java.util.*;
class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();

        for(List<Integer> list : sequences){
            if(list.size()==1){
                map.computeIfAbsent(list.get(0), ele -> new HashSet<>());
                degree.putIfAbsent(list.get(0), 0);
                continue;
            }

            for(int i=0;i<list.size()-1;i++){
                int src = list.get(i);
                int dest = list.get(i+1);

                map.computeIfAbsent(list.get(i), ele -> new HashSet<>());
                map.computeIfAbsent(list.get(i+1), ele -> new HashSet<>());

                degree.putIfAbsent(list.get(i), 0);
                degree.putIfAbsent(dest, 0);
                if(!map.get(src).contains(dest)){
                    map.get(src).add(dest);
                    degree.put(dest, degree.get(dest)+1);
                }
            }
        }
        int n = nums.length;
        if(map.size()!=n) return false;
        Queue<Integer> que = new LinkedList<>();
        int ind = 0;
        for(int i=1;i<=n;i++){
            if(degree.get(i)==0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            if(que.size()>1) return false;

            int x = que.poll();

            if(nums[ind++]!=x) return false;

            for(int ele : map.get(x)){
                degree.put(ele, degree.get(ele)-1);
                if(degree.get(ele)==0){
                    que.add(ele);

                }
            }
        }

        return ind==n;
    }
}