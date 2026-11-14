package split_message_based_on_limit_2563;

class Solution {
    public String[] splitMessage(String message, int limit) {
        int ans = -1;
        int next = 1;
        while(next < 100000 && ans == -1){
            
            int start = next;
            next *= 10;
            int end = next-1 ;

            while (start <= end) {
                int mid = (start + end) / 2;
                if (check(message, mid, limit)) {
                    ans = mid;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        if (ans == -1)
            return new String[0];
        System.out.println(ans);
        String result[] = new String[ans];

        int ind = 0;
        int cnt = 1;
        int l = 3 + ("" + ans).length();
        int i = 0;
        while (ind < ans) {
            int len = ("" + cnt).length() + l;
            int left = limit - len;
            StringBuilder sb = new StringBuilder();

            while (i < message.length() && left-- > 0) {
                sb.append(message.charAt(i));
                i++;
            }
            sb.append("<");
            sb.append(cnt);
            sb.append("/");
            sb.append(ans);
            sb.append(">");
            result[ind] = sb.toString();
            cnt++;
            ind++;
        }

        return result;

    }

    private boolean check(String message, int parts, int limit) {
        int cnt = 1;
        int ind = 0;
        int n = message.length();
        int l1 = ("" + parts).length() + 3;
        if (l1 >= limit)
            return false;
        while (ind < n && cnt <= parts) {
            int len = ("" + (cnt)).length() + l1;
            if (len >= limit)
                return false;
            int left = limit - len;
            ind += left;
            cnt++;
        }

        return ind >= n;
    }
}