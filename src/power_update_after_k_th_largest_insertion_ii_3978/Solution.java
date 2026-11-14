package power_update_after_k_th_largest_insertion_ii_3978;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private int mod = 1_000_000_007;

    public List<Integer> powerUpdate(int[] nums, int p, int[][] queries) {

        Map<Integer, Integer> mm[] = compress(nums, queries);
        Map<Integer, Integer> map = mm[0];
        Map<Integer, Integer> index = mm[1];
        int n = map.size();
        var tree = new SegmentTree(n);

        for(int x : nums){
            int ind = map.get(x);
            tree.add(1, ind, 0, n-1);
        }
        List<Integer> result = new ArrayList<>();
        for(var q : queries){
            int val = q[0];
            int k =q[1];

            int ind = map.get(val);
            tree.add(1, ind, 0, n-1);

            int x = search(k, tree, n);
            int v = index.get(x);
            p = pow(p, v);
            result.add(p);

        }

        return result;
    }

    private int search(int k, SegmentTree tree, int n){
        int start = 0;
        int end = n-1;
        int ind = -1;
        while(start <= end){
            int mid = (start + end)/2;

            int cnt = tree.query(1,mid, n-1, 0, n-1);
            if(cnt >= k){
                ind = mid;
                start = mid + 1;
            }else{
                end = mid - 1;

            }
        }

        return ind;
    }


    private Map<Integer, Integer> []compress(int nums[], int queries[][]) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map[] = new HashMap[]{new HashMap<>(), new HashMap<>()};

        for (var x : nums) {
            list.add(x);
        }
        for (var x : queries) {
            list.add(x[0]);
        }

        Collections.sort(list);
        int ind = 0;
        for(int x : list){
            if(!map[0].containsKey(x)){
                map[0].put(x, ind );
                map[1].put(ind, x);
                ind++;
            }
        }

        return map;
    }


    private int pow(int a, int b){
        int ans = 1;
        while(b > 0){
            if(b%2==1){
                ans = prod(ans, a);
            }

            a = prod(a, a);
            b>>=1;

        }

        return ans;
    }

    private int prod(long a, long b){
        return (int)((a*b)%mod);
    }

    class SegmentTree{
        int tree[];

        public SegmentTree(int n){
            tree = new int[n * 4];

        }

        public void add(int ind, int i, int l, int r){
            if( i < l || r < i) return;

            if( l == r){
                tree[ind]++;
                return;
            }

            int mid = (l + r)/2;

            add(2 * ind, i, l, mid);
            add(2 * ind + 1, i, mid + 1, r);

            tree[ind] = tree[2 * ind] + tree[2 * ind + 1];
        }

        public int query(int ind, int ql, int qr, int l, int r){
            if(qr < l || r < ql || ql > qr){
                return 0;
            }

            if(ql <= l && r <= qr){
                return tree[ind];
            }

            int mid = (l + r)/2;

            return query(2 * ind, ql, qr, l, mid) + query(2 * ind + 1, ql, qr, mid + 1, r);
        }
    }
}