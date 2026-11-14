class Solution {
    public String maxValue(String n, int x) {
        if (n.startsWith("-")) {
            StringBuilder res = new StringBuilder("-");
            for (int i = 1; i < n.length(); i++) {
                int dig = n.charAt(i) - '0';
                if (x < dig) {
                    res.append(x);
                    res.append(n.substring(i));
                    return res.toString();
                }

                res.append(dig);

            }
            res.append(x);
            return res.toString();

        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n.length(); i++) {
            int dig = n.charAt(i) - '0';
            if (x > dig) {
                res.append(x);
                res.append(n.substring(i));
                return res.toString();
            }

            res.append(dig);

        }
        res.append(x);
        return res.toString();
    }
}