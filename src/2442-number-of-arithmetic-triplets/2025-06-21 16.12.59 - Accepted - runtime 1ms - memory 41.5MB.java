class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int c1[] = new int[201];
        int c2[] =new int [201];

        for(int x : nums){
            c1[x]++;
        }
        int ans = 0;

        for(int x : nums){
            int a= x - diff;
            int b = x + diff;;
            int a1 = 0;
            c1[x]--;
            if(a >=0){
                a1 = c2[a];
            }

            int a2 = 0;
            if(b < 201){
                a2 = c1[b];
            }

            ans += a1*a2;
            c2[x]++;
        }

        return ans;
    }
}