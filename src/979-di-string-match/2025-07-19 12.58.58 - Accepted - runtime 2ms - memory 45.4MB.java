class Solution {
    public int[] diStringMatch(String s) {
      int n = s.length();

      int ans[] = new int[n+1];
      int start = 0;
      int end = n; 

      for(int i=0;i<n;i++){
        char c = s.charAt(i);
        if(c== 'I'){
            ans[i] = start++;;
        }else{
            ans[i] = end--;
        }
      } 

      ans[n] = start;

      return ans;
    }

}