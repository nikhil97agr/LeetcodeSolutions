package get_equal_substrings_within_budget_1321;

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int max = 0;
        int count = 0;
        int start = 0;
        int cost = 0;
        int n = s.length();
        char sarr[] = s.toCharArray();
        char tarr[] = t.toCharArray();
        for(int i=0;i<n;i++){
            if(sarr[i]!=tarr[i]){
                int diff = Math.abs(sarr[i]-tarr[i]);
                
                if(cost+diff>maxCost){
                max = Math.max(count, max);
                                    count++;
                    cost += diff;

                    while(start<=i&&cost>maxCost){
                        int temp = Math.abs(sarr[start]-tarr[start]);
                        cost -= temp;
                        start++;
                        count--;
                    }
                }else{
                    cost += diff;
                    count++;
                }

           
            }
            else{
                count++;
                
            }
        }
        return Math.max(count, max);
    }
}