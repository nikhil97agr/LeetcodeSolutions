package find_palindrome_with_fixed_length_1375;

class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int n = queries.length;
        long ans[] = new long[n];
        if(intLength == 1){
            for(int i=0;i<n;i++){
                int len = queries[i];
                if(len > 9)ans[i] = -1;
                else ans[i] = len;
            }

            return ans;
        }
        int half = (intLength + 1)/2;

        int total = 9 * (int)Math.pow(10, half - 1);
        
        for(int i=0;i<n;i++){
            if(queries[i] > total){
                ans[i] =-1;
                continue;
            }
            String firstHalf = getNum(queries[i], (intLength+1)/2);
            StringBuilder sb =new StringBuilder(firstHalf);
            String s1 = sb.toString();
            if(intLength%2==1){
                sb.deleteCharAt(sb.length()-1);

            }
            sb.reverse();
            String s2 = sb.toString();
            ans[i]= Long.parseLong(s1 + s2);
        }

        return ans;
    }
    private String getNum(int total, int len){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<len;i++){
            int left = len -1 - i;
            int cnt = (int)Math.pow(10, left);
            for(int dig = (i==0 ? 1 : 0);dig <= 9;dig++){
                if(total > cnt){
                    total -= cnt;
                }else{
                    res.append(dig);
                    break;
                }
            }
        }
        return res.toString();
    }
}



/**
 *
 *
 * ind -1 -> 9 number (1-9)
 * ind > 1 -> 10 number ( 0-9)
 */