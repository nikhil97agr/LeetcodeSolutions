class Solution {
    public int countOfSubstrings(String word, int k) {
        int n =word.length();
        int cnt = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            cnt = 0;
        Map<Character, Integer> map = new HashMap<>();

            for(int j=i;j<n;j++){
                if(isVowel(word.charAt(j))){
                    add(map, word.charAt(j));
                }else{
                    cnt++;
                }

                if(map.size() == 5 && cnt ==k){
                    ans++;
                }
                if(cnt > k) break;
            }
        }

        return ans;
        
    }

    private void add(Map<Character, Integer> map, char ch){
        map.merge(ch, 1, Integer::sum);
    }


    private boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i'|| c=='o' || c=='u';
    }
}