package path_crossing_1619;

import java.util.*;
class Solution {
    public boolean isPathCrossing(String path) {
        Set<Pair> set = new HashSet<>();
        int x = 0;
        int y =0;
        Pair p = new Pair(x,y);
        set.add(p);
        for(char c : path.toCharArray()){
            switch(c){
                case 'N':y++;
                break;
                case 'S':y--;
                break;
                case 'E':x++;
                break;
                case 'W': x--;
                break;
            }

            p = new Pair(x, y);
            if(set.contains(p)) return true;
            set.add(p);
        }
        return false;
    }

    class Pair{
        int x; 
        int y;
        public Pair(int x, int y){
            this.x = x;
             this.y = y;
        }

        public int hashCode(){
            return ("" + x +":"+y).hashCode();
        }

        public boolean equals(Object obj){
            Pair pair = (Pair)obj;
            return pair.x == x && pair.y == y;
        }
    }
}