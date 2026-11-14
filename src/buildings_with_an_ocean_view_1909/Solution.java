package buildings_with_an_ocean_view_1909;

import java.util.*;
class Solution {
    public int[] findBuildings(int[] heights) {
        int maxHeight = 0;
        Stack<Integer> list = new Stack<>();
        int n= heights.length;
        for(int i=n-1;i>=0;i--){
            if(heights[i] > maxHeight){
                list.push(i);
            }

            maxHeight = Math.max(maxHeight, heights[i]);
        }

        int ans[] = new int[list.size()];

        for(int i=0;i<ans.length;i++){
            ans[i] = list.pop();
        }

        return ans;
    }
}