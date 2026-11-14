class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> palindromes = new ArrayList<String>();
        solve(0, s, palindromes, result);
        return result;
    }

    private void solve(int ind, String str, List<String> pals, List<List<String>> result){
        if(ind==str.length()){
            result.add(new ArrayList<String>(pals));
            return;
        }

        for(int i=ind;i<str.length();i++){
            if(isPalindrome(str, ind, i)){
                pals.add(str.substring(ind, i+1));
                solve(i+1, str, pals, result);
                pals.remove(pals.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str, int i, int j){
        while(i<j){
            if(str.charAt(i)!= str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}