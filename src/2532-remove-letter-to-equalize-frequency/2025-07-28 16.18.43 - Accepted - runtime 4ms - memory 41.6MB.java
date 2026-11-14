class Solution {
    public boolean equalFrequency(String word) {
        for(int i=0;i<word.length();i++){
            int cnt[] =new int[26];
            for(int j=0;j<word.length();j++){
                if(i!=j){
                    cnt[word.charAt(j)-'a']++;
                }
            }

            Set<Integer> set = new HashSet<>();

            for(int x : cnt) if(x!=0) set.add(x);

            if(set.size() ==1) return true;
        }

        return false;
    }
}