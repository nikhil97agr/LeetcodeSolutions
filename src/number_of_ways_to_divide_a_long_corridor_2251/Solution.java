package number_of_ways_to_divide_a_long_corridor_2251;

import java.util.*;
class Solution {
    class Pair{
        Integer first;
        Integer second;
    }
    public int numberOfWays(String s) {
        long count = 0;
        long mod = (long)1e9+7;
        int n = s.length();
        List<Pair> pair = new ArrayList<>();
        Pair p = new Pair();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='S'){
                count++;
                if(p.first==null){
                    p.first = i;
                }else if(p.second==null){
                    p.second = i;
                    pair.add(p);
                    p = new Pair();
                }
            }
        }
        if(count%2==1 || count==0){
            return 0;
        }
        if(pair.size()==1){
            return 1;
        }
        count = 1;
        n = pair.size();
        for(int i=0;i<n-1;i++){
            Pair p1 = pair.get(i);
            Pair p2 = pair.get(i+1);
            count = count *( (p2.first - p1.second)%mod);
            count%=mod;
        }
        return (int)(count%mod);

    }
}