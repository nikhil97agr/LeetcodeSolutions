package count_complete_substrings_3223;

class Solution {
    public int countCompleteSubstrings(String word, int k) {
        int n = word.length();
        int ans = 0;
        char ch[]= word.toCharArray();
        for(int distChar = 1;distChar <= 26 && k * distChar <= n; distChar++){
            var map = new int[26];
            var freq = new int[n+1];
            var distinctCnt = 0;
            int start = 0;
            int end = 0;
            for(;end < n;end++){
                if(end > 0 && Math.abs(ch[end-1] - ch[end] ) > 2){
                    while(start < end){
                        distinctCnt += remove(freq,map, ch[start]);
                        start++;
                    }

 
                }
                distinctCnt += add(freq, map, ch[end]);
                
                while(distinctCnt > distChar || map[ch[end] -'a']> k){
                    distinctCnt += remove(freq, map, ch[start]);
 
                    start++;
                }

                if(distinctCnt == distChar && freq[k] == distChar){
                    ans++;
                }
            }
        }

        return ans;
    }


    private int add(int freq[], int map[], char c){
        int ind = c- 'a';
        if(map[ind]!=0){
            freq[map[ind]]--;
        }

        map[ind]++;
        freq[map[ind]]++;
        if(map[ind] ==1 ) return 1;
        return 0;
    }

    private int remove(int freq[], int map[], char c){
        int ind = c - 'a';
        freq[map[ind]]--;
        map[ind]--;
        if(map[ind] !=0){
            freq[map[ind]]++;
            return 0;
        }
        return -1;
    }

}