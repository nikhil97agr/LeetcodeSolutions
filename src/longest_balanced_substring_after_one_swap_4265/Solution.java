package longest_balanced_substring_after_one_swap_4265;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public int longestBalanced(String s) {

        var map = new HashMap<Integer, List<Integer>>();
        var n = s.length();
        int arr[] = new int[n];
        int onePre[] = new int[n + 1];
        int zeroPre[] = new int[n + 1];
        map.computeIfAbsent(0, x -> new ArrayList<>()).add(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                arr[i] = -1;
                onePre[i + 1] = onePre[i];
                zeroPre[i + 1] = zeroPre[i] + 1;
            } else {
                arr[i] = 1;
                onePre[i + 1] = onePre[i] + 1;
                zeroPre[i + 1] = zeroPre[i];
            }
        }

        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum).get(0));
            }

            int newSum = sum - 2;
            if (map.containsKey(newSum)) {
                if (zeroPre[n] - zeroPre[i + 1] > 0) {
                    ans = Math.max(ans, i - map.get(newSum).get(0));
                } else {
                    List<Integer> list = map.get(newSum);
                    int start = 0;
                    int end = list.size() - 1;
                    if (list.get(start) == -1) {
                        start++;
                    }

                    while (start <= end) {
                        int mid = (start + end) / 2;

                        int ind = list.get(mid);
                        if (zeroPre[ind + 1] > 0) {
                            ans = Math.max(ans, i - ind);
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                }
            }
  
            newSum = sum + 2;
            if (map.containsKey(newSum)) {
                if (onePre[n] - onePre[i + 1] > 0) {
                    ans = Math.max(ans, i - map.get(newSum).get(0));
                } else {
                    List<Integer> list = map.get(newSum);
                    int start = 0;
                    int end = list.size() - 1;
                    if (list.get(start) == -1) {
                        start++;
                    }

                    while (start <= end) {
                        int mid = (start + end) / 2;

                        int ind = list.get(mid);
                        if (onePre[ind + 1] > 0) {
                            ans = Math.max(ans, i - ind);
                            end = mid - 1;
                        } else {
                            start = mid + 1;
                        }
                    }
                }
            }

            map.computeIfAbsent(sum, x -> new ArrayList<>()).add(i);
        }

        return ans;
    }
}