import java.util.ArrayList;

class Solution {

    public int[] minDeletions(String s, int[][] queries) {

        char ch[] = s.toCharArray();

        int n = ch.length;
        var tree = new SegmentTree(n);
        for (int i = 1; i < n; i++) {
            if (ch[i] == ch[i - 1]) {
                tree.add(1, i, 1, 0, n - 1);
            }
        }

        var result = new ArrayList<Integer>();

        for (var q : queries) {
            if (q[0] == 2) {
                int l = q[1];
                int r = q[2];
                if (l == r) {
                    result.add(0);
                }else{
                    int cnt = tree.query(1, l, r, 0, n - 1);
                if (l - 1 >= 0 && ch[l] == ch[l - 1]) {
                    cnt--;
                }
                result.add(cnt);
                }

                
                continue;
            }

            var ind = q[1];
            char prev = ch[ind];
            char next = prev == 'A' ? 'B' : 'A';

            if(ind - 1 >=0){
                if(ch[ind-1] == next){
                    tree.add(1, ind, 1, 0, n-1);
                }else{
                    tree.add(1, ind, 0, 0, n-1);
                }
            }

            if(ind + 1 < n){
                if(ch[ind + 1] == next){
                    tree.add(1, ind + 1, 1, 0, n-1);
                }else{
                    tree.add(1, ind + 1, 0, 0,n-1);
                }
            }
            ch[ind] = next;

        }
        var ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    class SegmentTree {

        int tree[];

        public SegmentTree(int n) {

            tree = new int[n * 4];
        }

        public void add(int treeInd, int ind, int val, int start, int end) {

            if (ind < start || ind > end) {
                return;
            }
            if (start == end) {
                tree[treeInd] = val;
                return;
            }

            int mid = (start + end) / 2;

            add(2 * treeInd, ind, val, start, mid);
            add(2 * treeInd + 1, ind, val, mid + 1, end);

            tree[treeInd] = tree[2 * treeInd] + tree[2 * treeInd + 1];
        }

        public int query(int treeInd, int qs, int qe, int start, int end) {

            if (qe < start || qs > end) {
                return 0;
            }

            if (qs <= start && end <= qe) {
                return tree[treeInd];
            }

            int mid = (start + end) / 2;

            return query(2 * treeInd, qs, qe, start, mid) + query(2 * treeInd +1, qs, qe, mid + 1, end);
        }
    }
}