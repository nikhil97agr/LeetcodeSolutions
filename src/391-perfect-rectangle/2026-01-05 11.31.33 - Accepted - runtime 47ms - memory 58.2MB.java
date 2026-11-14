import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {

        TreeMap<Integer, List<Pair>> add = new TreeMap<>();
        TreeMap<Integer, List<Pair>> remove = new TreeMap<>();
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        TreeMap<Integer, Integer> height = new TreeMap<>();

        for(int r[] : rectangles){
            int x = r[0];
            int y = r[1];
            int a = r[2];
            int b = r[3];

            add.computeIfAbsent(x, x1 -> new ArrayList<>()).add(new Pair(y, b));
            remove.computeIfAbsent(a, a1 -> new ArrayList<>()).add(new Pair(y,b));



        }
        TreeSet<Integer> keys = new TreeSet<>(add.keySet());
        keys.addAll(remove.keySet());
        int first = keys.pollFirst();

        if(!add(add.get(first), height)){
            return false;
        }

        if(height.size() !=1){
            return false;
        }

        min = height.firstKey();
        max = height.get(min);

        while(!keys.isEmpty()){
            int next = keys.pollFirst();

            remove(remove.getOrDefault(next, new ArrayList<>()), height);
            if(!add(add.getOrDefault(next, new ArrayList<>()), height)){
                return false;
            }
            if(!keys.isEmpty()){
                if(height.size() != 1) return false;
                int lower =height.firstKey();
                int higher = height.get(lower);
                if(lower != min || higher !=max) return false;
            }


        }

        return true;
    }

    private void remove(List<Pair> list, TreeMap<Integer, Integer> height){
        for(Pair pair : list){
            int bottom = pair.bottom;
            int top = pair.top;

            Integer lower = height.floorKey(bottom);
            int end = height.get(lower);

            if(lower == bottom){
                if(end == top){
                    height.remove(lower);
                }else{
                    height.remove(lower);
                    height.put(top, end);
                }
            }else{
                height.remove(lower);
                height.put(lower, bottom);
                if(end != top){
                    height.put(top, end);
                }
            }
        }
    }

    private boolean add(List<Pair> list, TreeMap<Integer, Integer> height){
        for(Pair pair : list){
            int bottom = pair.bottom;
            int top = pair.top;

            if(height.isEmpty()){
                height.put(bottom, top);
                continue;
            }

            Integer lower = height.floorKey(bottom);
            if(lower != null){
                int end = height.get(lower);
                if(bottom <end ) return false;
                if(bottom == end){
                    bottom = lower;
                    height.remove(lower);
                }
            }

            Integer higher = height.ceilingKey(bottom);
            if(higher !=null){
                int end = height.get(higher);
                if(top > higher){
                    return false;
                }
                if(top == higher){
                    top = Math.max(top, end);
                    height.remove(higher);
                }
            }

            height.put(bottom, top);


        }

        return true;
    }



    class Pair{
        int top;
        int bottom;

        Pair(int bottom, int top){
            this.top = top;
            this.bottom = bottom;
        }
    }
}