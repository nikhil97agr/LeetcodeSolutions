package minimum_cost_to_make_two_binary_strings_equal_4156;

class Solution {
    public long minimumCost(String s, String t, int flipCost, int swapCost, int crossCost) {
        long a= 0;
        long b = 0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) != t.charAt(i)){
                if(s.charAt(i) == '0') a++;
                else b++;
            }
        }
        long min = Math.min(a,b);
        long c1 = min *Math.min(2 * flipCost, swapCost);
        a -= min;
        b -= min;

        long req = Math.abs(a-b);

        long c2 = (req/2) * Math.min( 2 * flipCost, crossCost + swapCost);

        return c1 + c2 + (req%2==1 ? flipCost: 0);
    }
}