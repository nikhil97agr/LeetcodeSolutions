class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char temp[] = new char[n];
        int j =-1;
        int count[] = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<n;i++){
            char c = findNextSmall(count);
            while(j>=0&&temp[j]<=c){
                result.append(temp[j]);
                j--;
            }
            temp[++j] = s.charAt(i);
            count[s.charAt(i)-'a']--;
        }
        while(j>=0){
            result.append(temp[j]);
            j--;
        }
            return result.toString();
    }
    
    public char findNextSmall(int count[]){
        for(int i=0;i<26;i++){
            if(count[i]>0){
                return (char)('a'+i); 
            }
        }
        return 'a';
    }
}