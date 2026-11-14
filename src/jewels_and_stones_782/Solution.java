package jewels_and_stones_782;

class Solution {
    public int numJewelsInStones(String J, String S) {
        int count[] = new int[256];
        for(char c : S.toCharArray())
        {
            count[c]++;
        }
        int total = 0;
        for(char c : J.toCharArray())
        {
            total += count[c];
        }
        return total;
    }
}