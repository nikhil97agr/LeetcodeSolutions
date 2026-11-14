class Solution {
    public int[] decimalRepresentation(int n) {
        int pow = 0;

        List<Integer> list = new ArrayList<>();

        while(n > 0){
            int dig = n%10;
            int num = dig * (int)Math.pow(10, pow);
            if(num!=0){
                list.add(num);
            }
            pow++;
            n/=10;
        }

        int ans[] = new int[list.size()];

        for(int i=0,j=list.size()-1;j>=0;i++,j--){
            ans[j] = list.get(i);
        }

        return ans;
        
    }
}