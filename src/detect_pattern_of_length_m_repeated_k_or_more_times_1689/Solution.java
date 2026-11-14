package detect_pattern_of_length_m_repeated_k_or_more_times_1689;

class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int cnt = 0;
        String prev = "";
        int n = arr.length;
        for(int i=0;i<n;i++){
            int j=i;
            int len = 0;
            prev = "";
            cnt = 0;
            while(j < n){
                len = 0;
                StringBuilder sb = new StringBuilder();
                while(j < n && len < m){
                    sb.append(arr[j]);
                    sb.append(":");
                    len++;
                    j++;
                }

                if(len == m){
                    String s = sb.toString();
                    if(prev.equals(s)){
                        cnt++;
                    }else{
                        prev = s;
                        cnt = 1;
                    }
                }

                if(cnt == k) return true;
            }
        }
        return false;
    }
}