class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int s1 = source[0] + source[1];
        int s2 = target[0] + target[1];
        if(s1%2 != s2%2) return -1;

        int x1 = source[0], x2 = target[0];
        int y1 = source[1], y2 = target[1];

        if(Math.abs(x1 - x2) == Math.abs(y1 - y2)) return 1;

        return 2;
    }
}