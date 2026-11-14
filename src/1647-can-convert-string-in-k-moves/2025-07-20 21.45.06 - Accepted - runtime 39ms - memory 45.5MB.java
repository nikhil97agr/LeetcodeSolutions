import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        new Solution().canConvertString("iqssxdlb", "dyuqrwyr", 40);
    }
    public boolean canConvertString(String s, String t, int k) {
        if(s.length() != t.length()) return false;

        int n = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i) != t.charAt(i)){

                map.merge(getMove(s.charAt(i), t.charAt(i)), 1, Integer::sum);
            }
        }

        for(int key : map.keySet()){
            int next = key;

            for(int i=0;i<map.get(key);i++){
                if(next <=k){
                    next += 26;
                }else{
                    return false;
                }
            }
        }

        return true;
    }

    private int getMove(char c1, char c2){
        if(c2 >= c1){
            return c2 - c1;
        }

        int cnt = 'z' - c1;
        return cnt + (c2- 'a')+1;
    }
}