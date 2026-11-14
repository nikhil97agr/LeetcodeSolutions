package sequentially_ordinal_rank_tracker_2207;

import java.util.*;
class SORTracker {
    List<Scene> list = new ArrayList<>();
    int next = 0;
    public SORTracker() {
        
    }
    
    public void add(String name, int score) {
        Scene scene = new Scene(score, name);
        int index = getIndex(scene);
        if(index == list.size()){
            list.add(scene);
        }else{
            list.add(index, scene);
        }

    }

    private int getIndex(Scene scene ){
        int index = list.size();
        int start = 0;
        int end = list.size() - 1;

        while(start <= end){
            int mid = (start + end)/ 2;
            Scene s = list.get(mid);
            if(s.score > scene.score){
                index = mid + 1;
                start = mid + 1;
            }else if(s.score < scene.score){
                index = mid;
                end = mid -1;
            }else{
                if(s.name.compareTo(scene.name) > 0){
                    index= mid;
                    end = mid - 1;
                }else if(s.name.compareTo(scene.name) < 0){
                    index = mid + 1;
                    start = mid + 1;
                }else{
                    return mid;
                }
            }
        }

        return index;
    }
    
    public String get() {
        next++;
        return list.get(next-1).name;
    }

    class Scene{
        String name;
        int score;

        public Scene(int score, String name){
            this.score = score;
            this.name = name;
        }

        public String toString(){
            return name+":"+score;
        }
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */