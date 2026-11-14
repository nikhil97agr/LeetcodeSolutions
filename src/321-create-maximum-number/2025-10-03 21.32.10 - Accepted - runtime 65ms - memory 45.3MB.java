class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int res[] = new int[k];

        for(int i=0;i<=k;i++){
            int j = k - i;

            if( i > nums1.length || j > nums2.length) continue;

            int a[] = subseq(nums1, i);
            int b[] = subseq(nums2, j);

            int merge[] = new int[k];

            int i1= 0;
            int i2 = 0;
            int i3 = 0;
            while(i1 < a.length && i2 < b.length){
                if(check(a, b, i1, i2)){
                    merge[i3++] = a[i1++];
                }else{
                    merge[i3++] = b[i2++];
                }
            }

            while(i1 < a.length){
                merge[i3++] = a[i1++];
            }

            while(i2 < b.length){
                merge[i3++] = b[i2++];
            }
            if(isGreater(merge, res)){
                res = merge;
            }
        }

        return res;
    }

    private boolean check(int a[], int b[], int i1, int i2){
        while(i1 < a.length && i2 < b.length && a[i1] == b[i2]){
            i1++;
            i2++;
        }

        if(i1 == a.length && i2 == b.length) return true;

        if(i1 == a.length) return false;
        if(i2 == b.length) return true;

        return a[i1] > b[i2];
    }

    private int[] subseq(int arr[], int len){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++){

            while(!stack.isEmpty() && stack.peek() < arr[i] && len - stack.size() <= (n-i-1)){
                stack.pop();
            }

            if(stack.size() < len) stack.push(arr[i]);
        }

        int ans[] =new int[len];

        for(int i=len - 1 ;i >=0;i--){
            ans[i] = stack.pop();
        };

        return ans; 
    }

    private boolean isGreater(int merge[], int res[]){
        int i=0;
        while(i < merge.length){
            if(merge[i] == res[i]){
                i++;
            }else{
                break;
            }
        }

        if(i==merge.length) return true;

        if(merge[i] > res[i]) return true;
        return false;
    }
}