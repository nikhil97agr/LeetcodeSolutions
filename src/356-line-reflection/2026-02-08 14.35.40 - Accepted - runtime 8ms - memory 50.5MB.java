import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
    public boolean isReflected(int[][] points) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int n = points.length;
        if(n==1) return true;
        Map<Pair, Integer> map = new HashMap<>();
        for(int p[] : points){
            minX = Math.min(minX, p[0]);
            maxX = Math.max(maxX, p[0]);
            Pair pair = new Pair(p[0], p[1]);
            map.merge(pair, 1, Integer::sum);
        }
        
        int sum = maxX + minX;

        
        for(int p[] : points){
            int x = p[0];
            int y = p[1];

            x = sum - x;
            Pair pair = new Pair(x, y);
            if(!map.containsKey(pair)) return false;

            
        }
        
        return true;
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