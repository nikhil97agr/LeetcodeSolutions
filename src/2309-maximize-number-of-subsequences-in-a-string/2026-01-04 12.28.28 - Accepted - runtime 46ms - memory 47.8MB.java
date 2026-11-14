class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int c1 = 0;
        int c2= 0 ;
        long total = 0;
        int n = text.length();
        int m = pattern.length();
        for(int i=n-1;i>=0;i--){
            if(text.charAt(i) == pattern.charAt(1)){
                c2++;
            }
        }

        for(int i=0;i<n;i++){

            if(text.charAt(i) == pattern.charAt(1)){
                c2--;
            }

            if(text.charAt(i) == pattern.charAt(0)){
                total += c2;
            }


        }



        long ans = total;

        for(int i=n-1;i>=0;i--){
            if(text.charAt(i) == pattern.charAt(1)){
                c2++;
            }
        }

        for(int i=0;i<n;i++){
            ans = Math.max(ans,
            Math.max(total + c2, total + c1));

            if(text.charAt(i) == pattern.charAt(0)) c1++;
            if(text.charAt(i) == pattern.charAt(1)) c2--;
        }

        ans = Math.max(ans,
        Math.max(total + c1, total + c2));
        return ans;
    }
}