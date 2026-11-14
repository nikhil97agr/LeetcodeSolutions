package design_a_file_sharing_system_1640;

import java.util.*;
class FileSharing {
    Map<Integer, List<Integer>> user;
    Map<Integer, TreeSet<Integer>> chunk;
    PriorityQueue<Integer> id;
    int next = 1;
    public FileSharing(int m) {
        user = new HashMap<>();
        chunk =new HashMap<>();
        id = new PriorityQueue<>();

    }
    
    public int join(List<Integer> ownedChunks) {
        int nextId= next;
        if(!id.isEmpty()){
            nextId = id.poll();
        }else{
            next++;
        }

        user.put(nextId, ownedChunks);

        for(int c : ownedChunks){
            chunk.computeIfAbsent(c, x-> new TreeSet<>()).add(nextId);
        }


        return nextId;
    }
    
    public void leave(int userId) {
        if(!user.containsKey(userId)) return;
        List<Integer> chunks = user.get(userId);
        user.remove(userId);
        id.offer(userId);

        for(int c : chunks){
            chunk.get(c).remove(userId);
            if(chunk.get(c).isEmpty()){
                chunk.remove(c);
            }
        }
    }
    
    public List<Integer> request(int userId, int chunkId) {
        if(!user.containsKey(userId) || !chunk.containsKey(chunkId)) return new ArrayList<>();

        TreeSet<Integer> set = chunk.get(chunkId);
        List<Integer> result = new ArrayList<>(set);
        set.add(userId);
        if(!user.get(userId).contains(chunkId))
            user.get(userId).add(chunkId);

        return result;
    }
}

/**
 * Your FileSharing object will be instantiated and called as such:
 * FileSharing obj = new FileSharing(m);
 * int param_1 = obj.join(ownedChunks);
 * obj.leave(userID);
 * List<Integer> param_3 = obj.request(userID,chunkID);
 */