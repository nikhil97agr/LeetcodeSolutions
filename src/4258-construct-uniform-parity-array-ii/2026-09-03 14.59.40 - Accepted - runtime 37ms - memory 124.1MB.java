class Solution {
    public boolean uniformArray(int[] nums1) {
        Arrays.sort(nums1);
        int n = nums1.length;
        if(n==1) return true;

        boolean odd = false;
        boolean e[] = new boolean[n];
        boolean o[] = new boolean[n];
        for(int i=0;i<n;i++){
            int val = nums1[i];
            if(val%2==0){
                e[i] = true;
                if(odd){
                    o[i] = true;
                }

                
            }else{
                o[i] = true;
                if(odd && nums1[0] < nums1[i]){
                    e[i] = true;
                }

                odd = true;
            }
        }

        int ec = 0, oc = 0;
        for(int i=0;i<n;i++){
            if(e[i]) ec++;
            if(o[i]) oc++;
        }
        return ec == n || oc == n;
    }
}