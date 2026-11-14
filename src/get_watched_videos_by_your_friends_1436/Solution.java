package get_watched_videos_by_your_friends_1436;

import java.util.*;
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        Queue<Integer> que = new LinkedList<>();
        int n = watchedVideos.size();
        boolean vis[] = new boolean[n];
        que.offer(id);
        vis[id] = true;
        while(level > 0 && !que.isEmpty()){
            int size = que.size();
            while(size-- > 0){
                int next = que.poll();
                for(int child : friends[next]){
                    if(!vis[child]){
                        vis[child] = true;
                        que.offer(child);
                    }
                }
            }
            level--;
        }

        Map<String, Integer> map = new HashMap<>();
        for(int user : que){
            for(String video : watchedVideos.get(user)){
                map.merge(video, 1, Integer::sum);
            }
        }

        return map.entrySet().stream().sorted((e1, e2)->{
            if(e1.getValue() == e2.getValue()){
                return e1.getKey().compareTo(e2.getKey());
            }

            return e1.getValue() -e2.getValue();
        }).map(e -> e.getKey()).toList();

    }
}