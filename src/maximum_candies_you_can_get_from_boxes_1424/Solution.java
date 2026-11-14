package maximum_candies_you_can_get_from_boxes_1424;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Set<Integer> keyFound = new HashSet<>();
        Set<Integer> boxFound = new HashSet<>();

        for(int x : initialBoxes){
            boxFound.add(x);
        }

        for(int i=0;i<status.length;i++){
            if(status[i] == 1)keyFound.add(i);
        }
        Set<Integer> visited = new HashSet<>();
        return solve(keyFound, boxFound,  candies, keys, containedBoxes,visited);
    }

    private int solve(Set<Integer> keyFound, Set<Integer> boxFound, int candies[], int keys[][], int containedBoxes[][], Set<Integer> visited){

        Set<Integer> set =  Set.copyOf(boxFound);
        int total= 0;
        for(int box : set){
            if(keyFound.contains(box)){
                visited.add(box);
                keyFound.remove(box);
                boxFound.remove(box);
                total += candies[box];
                candies[box] =0;

                for(int key : keys[box]){
                    if(!visited.contains(key))
                    keyFound.add(key);
                }

                for(int b : containedBoxes[box]){
                    if(!visited.contains(b))
                    boxFound.add(b);
                }
                total += solve(keyFound, boxFound, candies, keys, containedBoxes, visited);
            }
        }

        return total;
    }
}