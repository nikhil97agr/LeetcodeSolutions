import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        if(Arrays.equals(nums1, nums2)) return 0;
        int ans = 0;
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int x : nums1) l1.add(x);
        for(int x : nums2) l2.add(x);

        int n = nums1.length;
        Queue<List<Integer>> que = new LinkedList<>();

        Set<String> vis = new HashSet<>();

        que.offer(l1);
        vis.add(l1.toString());
        while(!que.isEmpty()){
            int size= que.size();
            while(size-->0){
                List<Integer> list = que.poll();
                if(list.equals(l2)) return ans;
                for(int l=0;l<n;l++){
                    for(int r=l;r<n;r++){
                        List<Integer> left = List.copyOf(list.subList(0, l));
                        List<Integer> mid = List.copyOf(list.subList(l, r+1));
                        List<Integer> right = List.copyOf(list.subList(r+1, n));

                        List<Integer> res = new ArrayList<>(left);
                        res.addAll(right);

                        for(int ind = 0;ind <= res.size();ind++){
                            List<Integer> next = new ArrayList<>(res);
                            next.addAll(ind, mid);
                            String str= next.toString();
                            if(!vis.contains(str)){
                                vis.add(str);
                                que.offer(next);
                            }
                        }
                    }
                }
            }
            ans++;
        }

        return -1;

        
        
    }
}