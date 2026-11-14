package open_the_lock_753;

import java.util.*;
class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> que = new LinkedList<>();
        que.offer("0000");
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if (visited.contains("0000"))
            return -1;

        visited.add("0000");
        int ans = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            while (size-- > 0) {
                int i = 0;
                StringBuilder sb = new StringBuilder(que.poll());

                while (i < 4) {

                    if (sb.toString().equals(target))
                        return ans;
                    char ch = sb.charAt(i);

                    sb.setCharAt(i, (ch == '9') ? '0' : (char) (ch + 1));
                    if (!visited.contains(sb.toString())) {
                        visited.add(sb.toString());
                        que.offer(sb.toString());
                    }

                    sb.setCharAt(i, (ch == '0') ? '9' : (char) (ch - 1));

                    if (!visited.contains(sb.toString())) {
                        visited.add(sb.toString());
                        que.offer(sb.toString());
                    }
                    sb.setCharAt(i, ch);
                    i++;
                    

                }

            }
            ans++;
        }
        return -1;
    }
}