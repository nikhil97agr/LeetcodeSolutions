package gcd_sort_of_an_array_2125;

import java.util.*;
class Solution {
    public boolean gcdSort(int[] nums) {
        int n = nums.length;
        int par[] = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
        }


        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = nums[i];
            for(int j=2;j<=Math.sqrt(val);j++){
                if(val%j==0){
                    map.computeIfAbsent(j, x-> new ArrayList<>()).add(i);
                    while(val%j==0){
                        val/=j;
                    }

                
                }
            }
            if(val > 1){
                map.computeIfAbsent(val, x-> new ArrayList<>()).add(i);
            }
        }

        for(List<Integer> list: map.values()){
            int first = list.get(0);
            for(int i=1;i<list.size();i++){
                int p1 = find(par, first);
                int p2 = find(par, list.get(i));

                if(p1 != p2){
                    par[p1] = p2;
                }
            }
        }
        Map<Integer, PriorityQueue<Integer>> parents= new HashMap<>();
        for(int i=0;i<n;i++){
            int p = find(par, i);
            parents.computeIfAbsent(p, x-> new PriorityQueue<>()).offer(nums[i]);
        }

        int sorted[] = new int[n];

        for(int i=0;i<n;i++){
            int p = find(par, i);
            sorted[i] = parents.get(p).poll();
        }

        for(int i=1;i<n;i++){
            if(sorted[i] < sorted[i-1]) return false;

        }

        return true;
    }



    private int find(int par[], int p){
        if(par[p] == p) return p;

        return par[p] = find(par, par[p]);
    }
}