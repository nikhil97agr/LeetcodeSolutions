package minimum_operations_to_transform_string_3999;

class Solution {
    public int minOperations(String s) {
        int ans = 0;
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }

        for(int i=1;i<25;i++){
            if(cnt[i] !=0){
                ans++;
                cnt[i+1] += cnt[i];
            }
        }


        return ans + (cnt[25] ==0 ? 0 : 1);
    }
}