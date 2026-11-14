package cinema_seat_allocation_1487;

import java.util.*;
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int r[] : reservedSeats){
            if(!map.containsKey(r[0])) n--;
            map.computeIfAbsent(r[0], x-> new HashSet<>()).add(r[1]);
        }

        int ans = n *2 ;
        for(Set<Integer> key : map.values()){
            if(check(key, 2,3,4,5,6,7,8,9)){
                ans += 2;
            }else if(check(key, 2, 3,4,5) || check(key, 6,7,8,9)){
                ans++;
            }else if(check(key, 4,5,6,7)){
                ans++;
            }
        }

        return ans;
    }

    private boolean check(Set<Integer> key, int...arr){
        for(int x : arr){
            if(key.contains(x)) return false;
        }
        return true;
    }
}