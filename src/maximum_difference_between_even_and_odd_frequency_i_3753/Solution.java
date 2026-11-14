package maximum_difference_between_even_and_odd_frequency_i_3753;

class Solution {
    public int maxDifference(String s) {
        int cnt[] = new int[26];
        for(char c : s.toCharArray()) cnt[c-'a']++;
        int odd = 0;
        int even = 100000;
        for(int x : cnt){
            if(x%2==0 && x!=0){
                even = Math.min(even, x);
            }else if(x%2==1){
                odd = Math.max(odd, x);
            }
        }

        return odd -even;
    }
}