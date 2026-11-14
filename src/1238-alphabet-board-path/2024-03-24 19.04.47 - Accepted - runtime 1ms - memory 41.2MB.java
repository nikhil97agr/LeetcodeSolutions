class Solution {
    public String alphabetBoardPath(String target) {
        Map<Character, Pair> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int ind = ch - 'a';
            int r = ind / 5;
            int c = ind % 5;
            map.put(ch, new Pair(r, c));
        }
        StringBuilder res = new StringBuilder();
        Pair curr = new Pair(0, 0);
        for (char c : target.toCharArray()) {
            Pair pair = map.get(c);
            int diffR = pair.r - curr.r;
            int diffC = pair.c - curr.c;
            if (c == 'z') {
                if (diffC < 0) {
                    for (int i = 0; i < Math.abs(diffC); i++) {
                        res.append('L');
                    }
                } else {
                    for (int i = 0; i < diffC; i++) {
                        res.append('R');
                    }
                }
                if (diffR < 0) {
                    for (int i = 0; i < Math.abs(diffR); i++) {
                        res.append('U');
                    }
                } else {
                    for (int i = 0; i < diffR; i++) {
                        res.append('D');
                    }
                }
                res.append('!');

                curr = pair;
                continue;

            }
            if (diffR < 0) {
                for (int i = 0; i < Math.abs(diffR); i++) {
                    res.append('U');
                }
            } else {
                for (int i = 0; i < diffR; i++) {
                    res.append('D');
                }
            }

            if (diffC < 0) {
                for (int i = 0; i < Math.abs(diffC); i++) {
                    res.append('L');
                }
            } else {
                for (int i = 0; i < diffC; i++) {
                    res.append('R');
                }
            }
            res.append('!');

            curr = pair;
        }

        return res.toString();
    }

    class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;

        }
    }
}