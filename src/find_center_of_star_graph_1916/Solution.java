package find_center_of_star_graph_1916;

class Solution {
    public int findCenter(int[][] edges) {
        int u = edges[0][0];
        int v = edges[0][1];

        if(u == edges[1][0] || u== edges[1][1]){
            return u;
        }
        return v;
    }
}