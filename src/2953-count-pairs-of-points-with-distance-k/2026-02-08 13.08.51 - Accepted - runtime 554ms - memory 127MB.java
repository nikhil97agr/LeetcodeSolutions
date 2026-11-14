import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        int ans = 0;
        Map<Pair, Integer> map = new HashMap<>();
        
        List<Pair> list = new ArrayList<>();
        for(List<Integer> l : coordinates){
            Pair pair =new Pair(l.get(0), l.get(1));
            list.add(pair);
            map.merge(pair, 1, Integer::sum);
        }
        
        for(Pair pair : list){
            int x= pair.x;
            int y = pair.y;
            map.merge(pair, -1, Integer::sum);
            if(map.get(pair) ==0) map.remove(pair);
            for(int sum = 0;sum <= k; sum++){
                int a = sum;
                int b = k - sum;
                int x1 = x ^ a;
                int y1 = y ^ b;
                Pair p = new Pair(x1, y1);
                ans += map.getOrDefault(p, 0);
            }
        }
        return ans;
    }

    class Pair{
        int x;
        int y;

        public Pair(int x, int y) {

            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }
}