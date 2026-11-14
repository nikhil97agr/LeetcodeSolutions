class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int max = Integer.MAX_VALUE;

        for(int g[] : ghosts){
            max = Math.min(max, Math.abs(target[0] - g[0]) + Math.abs(target[1] - g[1]));
        }

        int move = Math.abs(target[0]) + Math.abs(target[1]);


        return move < max;
    }
}