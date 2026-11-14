class Solution {
    public String getSmallestString(String s, int k) {
        int n = s.length();
        int cnt[] = new int[n];
        char res[] = new char[n];
        int total = 0;
        Arrays.fill(res, 'a');
        for(int i=0;i<n;i++){
            cnt[i] = dist(s.charAt(i), 'a');
            total += cnt[i];
        }
       int i = n-1;
       while(i>=0 && total - cnt[i] > k){
            res[i] = s.charAt(i);
            total -= cnt[i];
            i--;
       }

       if( i >= 0){
         char start = 'a';
         while(start <= s.charAt(i)){
            int dist = dist(start, s.charAt(i));

            if(total - cnt[i] + dist <= k){
                res[i] = start;
                break;
            }
            start++;
         }
       }
        return new String(res);
    }

    private int dist(char a, char b){
        char min = (char)Math.min(a,b);
        char max = (char)Math.max(a,b);

        int d1 = max - min;

        int d2 = (min - 'a') + ('z' -max) + 1;
        return Math.min(d1, d2);
    }
}