package find_the_divisibility_array_of_a_string_2713;

class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int ans[] = new int[n];
        long num = 0;
        for(int i=0;i<n;i++){
            num = num*10 + (word.charAt(i)-'0');
            num = num%m;
            if(num==0){
                ans[i] = 1;
            }
        }
        return ans;
    }
}