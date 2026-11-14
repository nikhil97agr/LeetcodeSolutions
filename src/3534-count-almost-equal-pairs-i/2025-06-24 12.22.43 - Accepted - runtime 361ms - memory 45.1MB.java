class Solution {
    public int countPairs(int[] nums) {
        int ans = 0;
        int n= nums.length;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++){
                if(check(nums[i], nums[j])){
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean check(int x, int y){
        if(x==y) return true;
        char c1[] = (""+x).toCharArray();
        char c2[] = (""+y).toCharArray();

        if(c2.length > c1.length){
            return check(y, x);
        }

        for(int i=0;i<c1.length;i++){
            for(int j=i+1;j<c1.length;j++){
                char a = c1[i];
                char b = c1[j];

                c1[i] = b;
                c1[j] = a;

                int num = Integer.parseInt(new String(c1));

                if(num == y) return true;

                c1[i] = a;
                c1[j] = b;
            }
        }

        return false;
    }
}