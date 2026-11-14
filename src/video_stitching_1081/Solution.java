package video_stitching_1081;

import java.util.*;
class Solution {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (x, y) -> {
            if (x[0] == y[0])
                return y[1] - x[1];

            return x[0] - y[0];
        });
        int ans = 0;
        int minStart = time + 1;
        int maxEnd = -1;
        for (int c[] : clips) {
            minStart = Math.min(minStart, c[0]);
            maxEnd = Math.max(maxEnd, c[1]);
        }

        if (minStart != 0 || maxEnd < time)
            return -1;
        int currEnd = 0;
        int i = 0;
        int n = clips.length;
        while (i < n && currEnd < time) {
            boolean found = false;
            maxEnd = 0;

            while (i < n && clips[i][0] <= currEnd) {
                maxEnd = Math.max(maxEnd, clips[i][1]);
                found = true;

                i++;
            }
            ans++;
            currEnd = maxEnd;
            if (i < n && !found)
                return -1;

        }

        return ans;
    }
}