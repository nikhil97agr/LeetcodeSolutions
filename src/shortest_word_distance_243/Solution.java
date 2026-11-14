package shortest_word_distance_243;

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        int i1 = getIndex(words, word1, 0);
        int i2 = getIndex(words, word2, 0);

        while(i1 < words.length && i2 < words.length){
            ans = Math.min(ans, Math.abs(i1-i2));

            if(i1<i2){
                i1 = getIndex(words, word1, i1+1);
            }else{
                i2 = getIndex(words, word2, i2+1);
            }
        }

        return ans;
    }

    private int getIndex(String arr[], String w, int start){
        for(int i=start;i<arr.length;i++){
            if(arr[i].equals(w)) return i;
        }
        return arr.length;
    }
}