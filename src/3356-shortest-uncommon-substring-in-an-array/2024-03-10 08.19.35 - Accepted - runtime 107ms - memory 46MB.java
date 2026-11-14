class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String ans[] = new String[n];
        
        Set<String> set[] = new HashSet[n];
        for(int i=0;i<n;i++)
        {
            set[i] = new HashSet<>();
            String s = arr[i];
            for(int j=0;j<s.length();j++){
                String temp = "";
                for(int k=j;k<s.length();k++){
                    temp += s.charAt(k);
                    set[i].add(temp);
                }
            }
        }
       for(int i=0;i<n;i++){
           for(String s : set[i]){
               boolean found = false;
               if(ans[i] != null && s.length() > ans[i].length()) continue;
               for(int j=0;j<n;j++){
                   if(i!=j && set[j].contains(s)){
                       found = true;
                       break;
                   }
               }
               if(!found ){
                   if(ans[i] == null){
                       ans[i] = s;
                   }else if(ans[i].length() > s.length()){
                       ans[i] = s;
                   }
                   else if(ans[i].compareTo(s) >0){
                       ans[i] = s;
                   }
                   
               }
           }
           if(ans[i] == null){
               ans[i] = "";
           }
       }
        return ans;
    }
}