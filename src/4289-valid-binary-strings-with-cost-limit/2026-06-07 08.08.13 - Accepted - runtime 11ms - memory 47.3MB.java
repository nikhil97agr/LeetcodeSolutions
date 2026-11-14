import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateValidStrings(int n, int k) {

        List<String> list = new ArrayList<>();
        solve(list, 0, 0,0, n, k, new StringBuilder());
        return list;
    }

    private void solve(List<String> list, int sum, int i, int prev, int n, int k, StringBuilder sb) {

        if (i == n) {
            if (sum <= k) {
                list.add(sb.toString());
            }

            return;
        }

        if(prev == 0){
            sb.append(1);
            solve(list, sum + i, i+1,  1, n, k, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        
        sb.append(0);
        solve(list, sum, i+1, 0, n, k ,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}