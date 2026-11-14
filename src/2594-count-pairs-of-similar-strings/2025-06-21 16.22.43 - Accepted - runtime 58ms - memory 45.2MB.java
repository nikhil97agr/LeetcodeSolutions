class Solution {
    public int similarPairs(String[] words) {
        int ans = 0;

        int n = words.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int c1[] = getCnt(words[i]);
                int c2[] = getCnt(words[j]);
                boolean possible = true;
                for(int k=0;k<26;k++){
                    if(!((c1[k] ==0 && c2[k] ==0) || (c1[k] > 0 && c2[k] > 0))){
                        possible= false;
                        break;
                    }
                }

                if(possible){
                    ans++;
                }
            }
        }

        return ans;
    }

    private int[] getCnt(String s){
        int c[] = new int[26];

        for(char ch :s.toCharArray()){
            c[ch-'a']++;
        }

        return c;
    }
}