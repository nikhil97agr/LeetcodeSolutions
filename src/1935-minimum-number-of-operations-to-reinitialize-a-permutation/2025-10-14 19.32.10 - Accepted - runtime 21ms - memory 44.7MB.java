class Solution {
    public int reinitializePermutation(int n) {
        int ans = 0;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i;
        }
        int perm[] = arr.clone();
        
        while(true){
            int temp[] = perm.clone();
            ans++;
            for(int i=0;i<n;i++){
                if(i%2==0){
                    temp[i] = perm[i/2];

                }else{
                    temp[i] = perm[n/2 + (i-1)/2];
                }
            }

            if(Arrays.equals(temp, arr))return ans;

            perm = temp;
        }

    }
}