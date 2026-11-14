package peaks_in_array_ii_4336;

import java.util.*;
class Solution {
    public long[] countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        List<Long> result = new ArrayList<>();
        boolean peak[] = new boolean[n];
        for(int i=1;i<n-1;i++){
            if(isPeak(i,nums)){
                peak[i] = true;
            }
        }

        var tree = new SegmentTree(n, peak);


        for(var q : queries){
            var type = q[0];
            var l = q[1];
            var r = q[2];
            if(type == 1){
                if(r - l < 2){
                    result.add(0l);
                    continue;
                }

                var res = tree.query(1, l, r, 0, n-1);

                if(res.first == -1){
                    result.add(0l);
                    continue;
                }

                if(res.first ==res.last){
                    long cnt = res.first;

                    result.add((cnt - l) * (r - cnt));
                    continue;
                }

                long a = res.first;
                long b = res.last;

                long total = (a - l) * (r - a) + 1l * r * (b - a) - res.sum;
                result.add(total);
            }else{
                if(nums[l] ==r) continue;

                nums[l] = r;
                for(int i = l - 1;i <= l + 1;i++){
                    var state = isPeak(i, nums);
                    if(i >=0 && i <= nums.length-1 && state != peak[i]){
                        peak[i] = state;
                        tree.update(1, 0, n-1, i, peak);
                    }
                }
            }
        }
        long ans[] = new long[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i] = result.get(i);
        }

        return ans;
    }

    private boolean isPeak(int i, int nums[]){
        if( i <=0 || i >= nums.length - 1) return false;
        return nums[i] > nums[i -1] && nums[i]> nums[i + 1];
    }

    class Node{
        int first = -1;
        int last = -1;
        long sum = 0;
    }
    class SegmentTree{
        Node[] tree;

        public SegmentTree(int n, boolean isPeak[]){
            tree = new Node[n * 4];
            build(1, 0, n-1, isPeak);
        }

        private void build(int ind, int l, int r, boolean isPeak[]){
            if(l == r){
                tree[ind] = new Node();
                if(isPeak[l]){
                    tree[ind].first = l;
                    tree[ind].last = l;
                    tree[ind].sum = 0;
                }

                return;
            }

            var mid = (l + r)/2;

            build(2 * ind, l, mid, isPeak);
            build(2 * ind + 1, mid + 1, r, isPeak);

            tree[ind] = merge(tree[2 * ind], tree[2 * ind + 1]);
        }

        private Node merge(Node left, Node right){
            if(left.first == -1) return right;
            if(right.first == -1) return left;
            Node ans = new Node();
            ans.first = left.first;
            ans.last = right.last;
            long total = 1l * (right.first - left.last) * right.first;
            ans.sum = left.sum + right.sum +  total;

            return ans;
        }

        public void update(int ind, int l, int r, int i, boolean isPeak[]){

            if( i < l || r < i) return;
            if(l == r){
                if(isPeak[l]){
                    tree[ind].first = l;
                    tree[ind].last = l;
                    tree[ind].sum = 0;
                }else{
                    tree[ind].first = -1;
                    tree[ind].last = -1;
                    tree[ind].sum = 0;
                }

                return;
            }

            var mid = (l + r)/2;
            update(2 * ind, l, mid, i, isPeak);
            update(2 * ind + 1, mid + 1, r, i, isPeak);

            tree[ind] = merge(tree[ 2 * ind], tree[2 * ind + 1]);
            
        }

        public Node query(int ind, int ql, int qr, int l, int r){
            if(qr < l || r < ql){
                return new Node();
            }

            if(ql <= l && r <= qr){
                return tree[ind];
            }

            int mid = ( l + r ) /2;

            Node left = query(2 * ind, ql, qr, l , mid);
            Node right = query(2 * ind + 1, ql, qr, mid + 1, r);


            return merge(left, right);
        }
        
    }
}