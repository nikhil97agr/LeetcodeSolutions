package online_election_947;

import java.util.*;
class TopVotedCandidate {
    TreeMap<Integer, Integer> winner;
    Map<Integer, Integer> personMap;
    int currMax;
    public TopVotedCandidate(int[] persons, int[] times) {
        winner = new TreeMap<>();
        personMap = new HashMap<>();
        int currMax= 0;
        int prevWinner = 0;

        for(int i=0;i<persons.length;i++){
            int p = persons[i];
            int t = times[i];
            
            if(!personMap.containsKey(p)){
                personMap.put(p, 1);
                if(currMax <= 1){
                    currMax = 1;
                    winner.put(t, p);
                    prevWinner = p;
                }else{
                    winner.put(t, prevWinner);
                }

            }else{
                personMap.merge(p, 1, Integer::sum);
                int cnt = personMap.get(p);

                if(currMax <= cnt){
                    winner.put(t, p);
                    currMax = cnt;
                    prevWinner = p;
                }else{
                    winner.put(t, prevWinner);
                }
            }
        }
    }
    
    public int q(int t) {
        return winner.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */