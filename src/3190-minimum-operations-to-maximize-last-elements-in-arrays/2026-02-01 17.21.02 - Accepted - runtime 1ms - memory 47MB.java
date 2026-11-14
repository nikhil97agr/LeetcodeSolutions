class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int a =  check(nums1, nums2);

        return a == Integer.MAX_VALUE ? -1 : a;
    }

    private int check(int a[], int b[]) {
        int n = a.length;
        int c1 = 0;
        int c2 = 1;
        int m1 = a[n-1];
        int m2 = b[n-1];

        for(int i=0;i<n-1;i++){
            int m = Math.max(a[i], b[i]);
            if(m <= m1 && m <= m2){
                continue;
            }

            if(a[i] <= m1 && b[i] <= m2){
                continue;
            }

            if(b[i] <= m1 && a[i] <= m2){
                c1++;
                continue;
            }
            c1 = Integer.MAX_VALUE;
            break;
        }

        m1 = b[n-1];
        m2 = a[n-1];
        for(int i=0;i<n-1;i++){
            int m = Math.max(a[i], b[i]);
            if(m <= m1 && m <= m2) continue;

            if(a[i] <= m1 && b[i] <= m2) continue;
            if(b[i] <= m1 && a[i] <= m2) {
                c2++;
                continue;
            }
            c2 = Integer.MAX_VALUE;
            break;
        }
        return Math.min(c1, c2);
    }
}