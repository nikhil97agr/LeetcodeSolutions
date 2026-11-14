package sort_integers_by_the_power_value_1488;

import java.util.*;
class Solution {
    class Pair{
        int val;
        int count;
        public Pair(int val, int count){
            this.count = count;
            this.val = val;
        }
    }
    public int getKth(int low, int high, int k) {
        List<Pair> result = new ArrayList<>();
        for(int i=low ;i<= high;i++){
            int x = i;
            int count = 0;
            while(x>1){
                if((x&(x-1))==0){
                    count += Math.log(x)/Math.log(2);
                    break;
                }

                if(x%2==0) x/=2;
                else x= x*3+1;
                count++;
            }

            result.add(new Pair(i, count));
        }

        Collections.sort(result, (a,b)->{
            if(a.count==b.count) return a.val - b.val;
            return a.count - b.count;
        });

        return result.get(k-1).val;
    }
}