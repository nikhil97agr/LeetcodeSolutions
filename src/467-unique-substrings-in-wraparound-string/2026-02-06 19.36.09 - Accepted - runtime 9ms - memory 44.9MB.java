class Solution {
    public int findSubstringInWraproundString(String s) {
        int n = s.length();
        int len = 1;
        int ans = 0;
        int arr[] = new int[26];
        for(int i=0;i<n;i++){
            if(i ==0){
                int ind = s.charAt(i) - 'a';
                ans++;
                arr[ind] = len;
                continue;
            }
            int ind1 = (s.charAt(i) - 'a');
            int ind2 = (s.charAt(i-1) - 'a');
            if((ind2 + 1)%26 == ind1){
                len++;
                ans += Math.max(0, len -arr[ind1]);
                arr[ind1] = Math.max(arr[ind1], len);
            }else{
                len = 1;
                if(arr[ind1] ==0){
                    ans++;
                    arr[ind1] = 1;
                }
            }
        }
        return ans;
    }
}