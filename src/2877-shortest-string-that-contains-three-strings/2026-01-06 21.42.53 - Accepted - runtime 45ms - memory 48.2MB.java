class Solution {
    public String minimumString(String a, String b, String c) {
        List<String> list = new ArrayList<>();
        String s[] = new String[] { a, b, c };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i != j && j != k && k != i) {
                        list.add(str(s[i], s[j], s[k]));
                    }
                }
            }
        }
        String res = "";
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            String st = list.get(i);
            if (st.length() < len) {
                len = st.length();
                res = st;
            } else if (st.length() == len && st.compareTo(res) < 0) {
                res = st;
            }
        }

        return res;
    }

    private String str(String a, String b, String c) {
        String s = "";
        if (a.contains(b)) {
            s = a;
        } else {
            for (int i = 0; i < a.length(); i++) {
                if (b.startsWith(a.substring(i))) {
                    int len = a.substring(i).length();
                    s = a + b.substring(len);
                    break;
                }
            }
        }

        if (s.isEmpty()) {
            s = a + b;
        }
        String s2 = "";

        if (s.contains(c)) {
            s2 = s;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (c.startsWith(s.substring(i))) {
                    int len = s.substring(i).length();
                    s2 = s + c.substring(len);
                    break;
                }
            }
        }

        if (s2.isEmpty()) {
            s2 = s + c;
        }

        return s2;
    }
}