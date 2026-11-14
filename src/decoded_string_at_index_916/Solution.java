package decoded_string_at_index_916;

class Solution {
    public String decodeAtIndex(String s, int k) {
        long size = 0;
        int ind = 0;

        while (size < k) {
            char c = s.charAt(ind);
            if (Character.isDigit(c)) {
                size *= (c - '0');
            } else {
                size++;
            }
            ind++;
        }

        for (int j = ind - 1; j >= 0; j--) {
            char c = s.charAt(j);
            if (Character.isDigit(c)) {
                size /= (c - '0');
                k %= size;
            } else {
                if (k == 0 || k == size) {
                    return "" + c;
                }
                size--;
            }
        }
        return "";
    }
}