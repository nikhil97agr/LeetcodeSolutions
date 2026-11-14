import java.util.*;

class Solution {
    public int distinctPoints(String s, int k) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        if(n ==k) return 1;
        map.put('U', 0);
        map.put('L', 0);
        map.put('R', 0);
        map.put('D', 0);

        for(char c : s.toCharArray()){
            map.merge(c, 1, Integer::sum);
        }

        Set<Pair> set = new HashSet<>();
        for(int i=0;i<k;i++){
            char c= s.charAt(i);
            map.merge(c, -1, Integer::sum);
        }
        char seq[] = new char[]{'U', 'L', 'R', 'D'};
        int start = 0;
        int end = k;

        while(end < n){
            int x = 0;
            int y =0;
            for(char c : seq){
                int cnt = map.get(c);

                switch(c){
                    case 'U':
                        y+= cnt;
                        break;
                    case 'L':
                        x -= cnt;
                        break;
                    case 'D':
                        y -= cnt;
                        break;
                    case 'R':
                        x += cnt;
                        break;
                        

                }
            }
            
            set.add(new Pair(x, y));


            map.merge(s.charAt(start), 1, Integer::sum);
            map.merge(s.charAt(end), -1, Integer::sum);
            start++;
            end++;
        }

        int x = 0;
        int y =0;
        for(char c : seq){
            int cnt = map.get(c);

            switch(c){
                case 'U':
                    y+= cnt;
                    break;
                case 'L':
                    x -= cnt;
                    break;
                case 'D':
                    y -= cnt;
                    break;
                case 'R':
                    x += cnt;
                    break;


            }
        }

        set.add(new Pair(x, y));

        return set.size();
    }



    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return first == pair.first && second == pair.second;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}