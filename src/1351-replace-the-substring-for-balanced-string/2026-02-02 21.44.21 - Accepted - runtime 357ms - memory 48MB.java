class Solution {
    public int balancedString(String s) {
        int ans = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            add(c, map);
        }

        if (map.size() == 4) {
            boolean flag = true;
            for (int val : map.values()) {
                if (val != n / 4) {
                    flag = false;
                    break;
                }
            }

            if (flag)
                return 0;
        }
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (possible(mid, s.toCharArray(), n, n / 4)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean possible(int k, char ch[], int n, int req) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (char c : ch) {
            add(c, m1);
        }

        if(k == 1){
            System.out.println("THIS");

        }

        for (int i = 0, j = 0; i < n; i++) {
            add(ch[i], m2);
            remove(ch[i], m1);
            if (i - j + 1 == k) {
                if (isValid(m1, req))
                    return true;
                remove(ch[j], m2);
                add(ch[j], m1);
                j++;
            }
        }

        return false;
    }

    private boolean isValid(Map<Character, Integer> map, int cnt) {


        for (int val : map.values()) {
            if (val > cnt)
                return false;
        }

        return true;
    }

    private void add(char ch, Map<Character, Integer> map) {
        map.merge(ch, 1, Integer::sum);
    }

    private void remove(char ch, Map<Character, Integer> map) {
        map.merge(ch, -1, Integer::sum);
        if (map.get(ch) == 0) {
            map.remove(ch);
        }
    }
}