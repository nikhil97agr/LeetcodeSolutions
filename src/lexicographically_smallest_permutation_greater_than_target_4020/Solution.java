package lexicographically_smallest_permutation_greater_than_target_4020;

class Solution {

    public static void main(String[] args) {
        new Solution().lexGreaterPermutation("aab", "aba");
    }
    public String lexGreaterPermutation(String s, String target) {
        StringBuilder result = new StringBuilder();
        int n =s.length();
        int cnt[] = new int[26];
        for(char c : s.toCharArray()){
            cnt[c-'a']++;
        }
        for(int i=0;i<n;i++){
            for(char c = 'a';c<='z';c++){
                if(cnt[c-'a']==0) continue;

                cnt[c-'a']--;
                result.append(c);

                String prefix= result.toString();

                if(pos(prefix, target.substring(0, i+1), cnt, target)){
                    break;
                }else{
                    cnt[c-'a']++;
                    result.deleteCharAt(result.length() - 1);
                }

                if(c=='z') return "";
            }
        }

        String ans =result.toString();

        if(ans.compareTo(target) > 0) return ans;

        return "";
    }

    private boolean pos(String prefix, String targetPre, int cnt[], String target){
        if(prefix.compareTo(targetPre) > 0) return true;

        if(prefix.compareTo(targetPre) < 0) return false;
        int temp[] = cnt.clone();
        for(int i=targetPre.length();i<target.length();i++){
            char c = target.charAt(i);

            for(char ch = (char)(c+1);ch <= 'z';ch++){
                if(temp[ch-'a'] > 0) return true;
            }
            
            if(temp[c-'a'] ==0 ){
                return false;
            }
            
            temp[c-'a']--;
        }

        return false;
    }
}