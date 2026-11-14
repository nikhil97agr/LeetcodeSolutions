package minimize_the_total_price_of_the_trips_2739;

import java.util.*;
import java.util.LinkedList;

class Solution {

    int freq[];
    LinkedList<Integer> adjList[];
    int price[];
    int n;
    Integer dp[][];

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        dp = new Integer[n][2];
        freq = new int[n];
        adjList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
        }
        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        this.price = price;
        this.n = n;
        for (var t : trips) {

            dfs(t[0], -1, t[1]);

            System.out.println(Arrays.toString(freq));
        }
        return dfs2(0, -1, 0);

    }

    private int dfs2(int curr, int par, int change) {

        if(dp[curr][change] !=null) return dp[curr][change];
        int a = (price[curr] * freq[curr]) / 2;
        int b = price[curr] * freq[curr];
        
        for(int child : adjList[curr]){
            if(child == par) continue;
            b += dfs2(child, curr, 0);
        }
        
        if(change == 1) return dp[curr][change] = b;
        
        for(int child : adjList[curr]){
            if(child == par) continue;
            a += dfs2(child, curr, 1);
        }
        
        return dp[curr][change] = Math.min(a,b);
    }

    private boolean dfs(int curr, int par, int end) {

        freq[curr]++;
        if (curr == end) {
            return true;
        }

        for (int child : adjList[curr]) {
            if (child == par) {
                continue;
            }
            if (dfs(child, curr, end)) {
                return true;
            }
        }

        freq[curr]--;
        return false;


    }
}