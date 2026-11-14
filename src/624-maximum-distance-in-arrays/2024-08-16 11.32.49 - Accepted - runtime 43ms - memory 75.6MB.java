class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int max1=Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE, min2=Integer.MAX_VALUE;

        for(List<Integer>list : arrays){
            int min = list.get(0);
            int max = list.get(list.size()-1);

            if(min <= min1){
                min2 = min1;
                min1= min;

            }else if(min <= min2){
                min2 = min;
            }

            if(max >= max1){
                max2 = max1;
                max1 =max;
            }else if(max >=max2){
                max2 = max;
            }
        }
        int ans = 0;
        for(List<Integer> list : arrays){
            int min = list.get(0);
            int max = list.get(list.size()-1);

            ans = max(
                ans,
                abs(min - ((min1 == min) ? min2 : min1)),
                abs(min - ((max1==min || max1 == max) ? max2 : max1)),
                abs(max - ((max1 == max) ? max2 : max1)),
                abs(max - ((min1 == max || min1 == min)? min2 : min1))
            );
        }

        return ans;

    }

    private int abs(int x) { return Math.abs(x); }
    
    private int max(int...arr) { return Arrays.stream(arr).max().getAsInt(); }

}