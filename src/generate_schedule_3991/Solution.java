package generate_schedule_3991;

import java.util.*;
class Solution {
    public int[][] generateSchedule(int n) {

        if (n < 5) {
            return new int[][] {};
        }

        int[][] ans = null;
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    String key = i + "-" + j;
                    list.add(key);
                }
            }
        }

        while (true) {
            ans = new int[n * (n - 1)][2];
            shuffleMapping(ans, new ArrayList<>(list));
            if (!anyEleZero(ans)) {
                break;
            }
        }

        return ans;
    }

    private boolean anyEleZero(int[][] ans) {
        for (int[] arr : ans) {
            if (arr[0] == 0 && arr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    private void shuffleMapping(int[][] ans, List<String> list) {
        int index = 1;
        ans[0] = new int[] { 0, 1 };
        
        Collections.shuffle(list, new Random());
        list.remove(0 + "-" + 1);
        
        for (int i = 1; i < ans.length; i++) {

            String prevI = ans[i - 1][0] + "";
            String prevJ = ans[i - 1][1] + "";

            for (String ele : list) {
                String[] elArray = ele.split("-");

                if (index < ans.length
                        && !prevI.equals(elArray[0])
                        && !prevI.equals(elArray[1])
                        && !prevJ.equals(elArray[0])
                        && !prevJ.equals(elArray[1])) {
                    ans[index] = new int[] { Integer.parseInt(elArray[0]), Integer.parseInt(elArray[1]) };
                    list.remove(ele);
                    index++;
                    break;
                }
            }
        }
    }
}