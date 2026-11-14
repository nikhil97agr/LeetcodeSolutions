package design_authentication_manager_1905;

import java.util.*;
class AuthenticationManager {
    int life;
    Map<String, Integer> map;
    int unexpired;
    public AuthenticationManager(int timeToLive) {
        life = timeToLive;
        map = new HashMap<>();
        unexpired = 0;
    }
    
    public void generate(String tokenId, int currentTime) {
        cleanup(currentTime);
        if(!map.containsKey(tokenId)){
            unexpired++;
        }

        map.put(tokenId, currentTime + life);
    }
    
    public void renew(String tokenId, int currentTime) {
        cleanup(currentTime);
        if(map.containsKey(tokenId)){
            map.put(tokenId, currentTime + life);
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        cleanup(currentTime);
        return unexpired;
    }

    public void cleanup(int current){
        List<String> list = new ArrayList<>(map.keySet());

        for(String key : list){
            if( map.get(key) <= current){
                map.remove(key);
                unexpired--;
            }
        }
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */