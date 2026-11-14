package find_a_value_of_a_mysterious_function_closest_to_target_1645;

import java.util.*;
import java.util.Arrays;

class Solution {
    public int closestToTarget(int[] arr, int target) {
        int n= arr.length;
        SegmentTree tree = new SegmentTree(n, arr);
        int ans= Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            ans = Math.min(ans, calc(i, n-1, tree, target, n));
        }

        return ans;

    }

    private int calc(int start, int end, SegmentTree tree, int target, int n){
        int ans = Integer.MAX_VALUE;
        int s = start;
        while(start <= end){
            int mid = (start + end)/2;
            int val = tree.query(1, 0, n-1, s, mid);
            if(val == target) return 0;
            if(val < target){
                ans = Math.min(ans, target -val);
                end = mid - 1;
            }else{
                ans = Math.min(ans, val - target);
                start = mid + 1;
            }
        }

        return ans;

    }


    class SegmentTree{
        int tree[];
        public SegmentTree(int n, int arr[]){
            tree = new int[n*4];
            Arrays.fill(tree, (1<< 22) -1 );
            buildTree(1, arr, 0, n-1);
        }

        public int query(int node, int arrStart, int arrEnd, int qStart, int qEnd){
            if(qEnd < arrStart || arrEnd < qStart){
                return (1<<22) -1;
            }

            if(qStart <= arrStart && arrEnd <= qEnd){
                return tree[node];
            }

            int mid = (arrStart + arrEnd)/2;
            return query(2 * node, arrStart, mid, qStart, qEnd) & query(2 * node + 1, mid + 1, arrEnd, qStart, qEnd);
        }

        private void buildTree(int node, int arr[], int start, int end){
            if(start > end) return;

            if(start == end){
                tree[node] = arr[start];
                return;
            }

            int mid = (start + end)/2;
            buildTree(2 * node , arr, start, mid);
            buildTree(2 * node + 1, arr, mid + 1, end);

            tree[node] = tree[2 * node] & tree[2 * node + 1];
        }
    }
}