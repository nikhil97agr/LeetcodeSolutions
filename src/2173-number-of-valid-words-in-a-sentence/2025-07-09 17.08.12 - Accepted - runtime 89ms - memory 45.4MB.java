class Solution {
    public int countValidWords(String sentence) {
        String str[] = sentence.split(" ");


        int ans = 0;
        for(String s : str){
            if(check(s)){
                ans++;
            }
        }
        return ans;
    }

    private boolean check(String s){
        int n = s.length();
        System.out.println(s+":"+n);    
        if(n==0) return false;


        int hyphen = 0;
        int punc = 0;
        int letter = 0;

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c == '-'){
                if(i ==0 || i==n-1) return false;
                if(!Character.isLetter(s.charAt(i-1)) || !Character.isLetter(s.charAt(i+1))) return false;
                hyphen++;
            }else if(c== '!' || c=='.' || c==','){
                if(i!=n-1) return false;
                punc++;
            }else if(Character.isLetter(c)) letter++;
        }

        System.out.println(hyphen+":"+punc+":"+letter);
        return hyphen <= 1 && punc <= 1 && letter + hyphen + punc == n;
    }
}