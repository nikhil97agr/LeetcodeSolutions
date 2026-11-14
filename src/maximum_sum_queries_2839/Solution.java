package maximum_sum_queries_2839;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {

        int n = nums1.length;
        int q = queries.length;
        int ans[] = new int[q];
        SegmentTree tree = new SegmentTree(n);
        Map<Integer, Integer> sortedIndexMap =new HashMap<>();

        int a[][] = new int[n][2];
        int b[][] = new int[n][2];
        for(int i=0;i<n;i++){
            a[i] = new int[]{nums1[i], i};
            b[i] = new int[]{nums2[i], i};
        }

        Arrays.sort(a, (x,y) -> x[0] - y[0]);

        Arrays.sort(b, (x,y) -> x[0] - y[0]);
        for(int i=0;i<n;i++){
            int ind= a[i][1];
            sortedIndexMap.put(ind, i);
            tree.add(1, nums1[ind] + nums2[ind], i, 0, n-1);
        }

        int query[][] = new int[q][];
        for(int i=0;i<q;i++){
            query[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.fill(ans, -1);
        Arrays.sort(query, (x,y) -> x[1] - y[1]);
        
        for(int i=0, i1=0;i<q;i++){
            int x = query[i][0];
            int y = query[i][1];
            int ind = query[i][2];
            
            while(i1 < n && b[i1][0] < y){
                int ii = sortedIndexMap.get(b[i1][1]);
                tree.add(1, -1, ii, 0, n-1);
                i1++;
            }
            
            if(i1 == n){
                break;
            }
            
            int searchIndex = binarySearch(a, x);
            if(searchIndex == -1){
                ans[ind] = -1;
                continue;
            }
            
            ans[ind] = tree.search(1, searchIndex, n-1, 0, n-1);
        }

        return ans;
    }
    
    private int binarySearch(int arr[][], int val){
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            
            if(arr[mid][0] < val){
                start = mid + 1;
            }else{
                ans = mid;
                end = mid - 1;
            }
        }
        
        return ans;
    }

    class SegmentTree {

        int tree[];

        public SegmentTree(int n) {

            tree = new int[n * 4];
            Arrays.fill(tree, -1);
        }

        public void add(int ind, int val, int i, int start, int end) {
            if (i < start || i > end) {
                return;
            }
            if (start == end) {
                tree[ind] = val;
                return;
            }


            int mid = (start + end) / 2;

            add(2 * ind, val, i, start, mid);
            add(2 * ind + 1, val, i, mid + 1, end);

            tree[ind] = Math.max(tree[2 * ind], tree[2 * ind + 1]);


        }

        public int search(int ind, int ql, int qr, int l, int r) {

            if (ql > r || qr < l) {
                return -1;
            }

            if (ql <= l && r <= qr) {
                return tree[ind];
            }

            int mid = (l + r) / 2;

            return Math.max(search(2 * ind, ql, qr, l, mid), search(2 * ind + 1, ql, qr, mid + 1, r));
        }
    }
}