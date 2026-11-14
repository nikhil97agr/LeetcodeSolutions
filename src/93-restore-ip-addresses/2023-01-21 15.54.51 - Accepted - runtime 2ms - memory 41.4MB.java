class Solution {
    public List<String> restoreIpAddresses(String s) {
        if(s.length()>12){
            return new ArrayList<String>();
        }

        List<String> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(s, 0, result, temp);
        return result;
    }

    private void solve(String s, int i, List<String> result, List<String> temp){
        if(temp.size()==4){
            if(i==s.length()){
                result.add(String.join(".", temp));
            }
            return;
        }

        for(int j=i;j<=i+2 && j<s.length();j++){
            String next = s.substring(i, j+1);
            if((next.equals("0") || !next.startsWith("0")) && Integer.parseInt(next)<=255){
                temp.add(next);
                solve(s, j+1, result, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}