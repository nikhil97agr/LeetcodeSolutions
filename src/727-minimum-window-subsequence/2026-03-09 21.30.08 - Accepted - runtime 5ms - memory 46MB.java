class Solution {

    public String minWindow(String s1, String s2) {

        char s[] = s1.toCharArray();
        char t[] = s2.toCharArray();

        int len = Integer.MAX_VALUE;
        int startInd = -1;
        int endInd = -1;
        int ind = 0;
        while (ind < s.length) {
            int end = getEnd(ind, s, t);

            if (end == -1) {
                break;
            }

            int start = getStart(end, s, t);

            if (end - start + 1 < len) {
                len = end - start + 1;
                startInd = start;
                endInd = end;
            }
            ind = start + 1;
        }

        if (startInd == -1) {
            return "";
        }

        return s1.substring(startInd, endInd + 1);
    }

    private int getStart(int end, char s[], char t[]) {

        int i = t.length - 1;
        while (end >= 0 && i >= 0) {
            if (t[i] == s[end]) {
                i--;
            }
            end--;
        }
        return end + 1;
    }

    private int getEnd(int ind, char s[], char t[]) {

        int i = 0;
        while (ind < s.length && i < t.length) {
            if (s[ind] == t[i]) {
                i++;

            }
            ind++;
        }
        if (i != t.length) {
            return -1;
        }
        return ind - 1;
    }
}