class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();
        char temp[] = new char[s.length()];
        solve(temp, result, n, s, 0);
        return result;
    }

    private void solve(char temp[],List<String> result, int n, String s, int i){
        if(i==n){
            result.add(String.valueOf(temp));
            return;
        }
        if(s.charAt(i)>='0' && s.charAt(i)<='9'){
            temp[i] = s.charAt(i);
            solve(temp, result, n, s, i+1);
            return;
        }
        temp[i] = Character.toUpperCase(s.charAt(i));
        solve(temp, result, n, s, i+1);
        temp[i] = Character.toLowerCase(s.charAt(i));
        solve(temp,result,n,s,i+1);
    }
}