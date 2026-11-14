class Solution {
    public String generateTheString(int n) {
        if(n%2==0){
            StringBuilder res = new StringBuilder();
            res.append('a');
            for(int i=0;i<n-1;i++){
                res.append('b');
            }
            return res.toString();
        }
        if(n==1) return "a";
        
        StringBuilder res = new StringBuilder();
        res.append('a');
        res.append('b');
        for(int i=0;i<n-2;i++) res.append('c');
        return res.toString();
        
    }
}