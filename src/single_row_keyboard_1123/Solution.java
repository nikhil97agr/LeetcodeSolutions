package single_row_keyboard_1123;

class Solution {
    public int calculateTime(String keyboard, String word) {
        int ans =0 ;
        int index[] = new int[26];
        for(int i=0;i<keyboard.length();i++){
            index[keyboard.charAt(i) - 'a'] = i;
        }

        int curr = 0;
        for(char c : word.toCharArray()){
            int ind = index[c-'a'];
            ans += Math.abs(ind - curr);
            curr = ind;
        }
        return ans;
    }
}