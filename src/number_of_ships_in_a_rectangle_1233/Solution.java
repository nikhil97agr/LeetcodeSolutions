package number_of_ships_in_a_rectangle_1233;

import java.util.*;
// This is Sea's API interface.
// You should not implement it, or speculate about its implementation
abstract class Sea {
    public abstract boolean hasShips(int[] topRight, int[] bottomLeft);
}

class Solution {
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        boolean has = sea.hasShips(topRight, bottomLeft);

        if(!has) return 0;

        if(Arrays.equals(topRight, bottomLeft)) return 1;

        int y = (topRight[1] + bottomLeft[1]) / 2;
        int x = (topRight[0] + bottomLeft[0]) / 2;

        // if(topRight[0] == bottomLeft[0]){
        //     return countShips(sea, new int[]{x, y}, new int[]{x, bottomLeft[1]}) + countShips(sea, new int[]{x, topRight[1]}, new int[]{x, y+1});
        // }

        // if(topRight[1] == bottomLeft[1]){
        //     return countShips(sea, new int[]{x, y}, new int[]{bottomLeft[0], y}) + countShips(sea, new int[]{topRight[0], y}, new int[]{x+1, y});
        // }
        return countShips(sea, new int[]{x,y},  bottomLeft)
        + countShips(sea, new int[]{x, topRight[1]}, new int[]{bottomLeft[0], y + 1})
        + countShips(sea, new int[]{topRight[0], y}, new int[]{x + 1, bottomLeft[1]})
        + countShips(sea, topRight, new int[]{x+1, y+1});

    }
}