class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int ans[] = new int[num_people];
        int ind = 0;
        int next = 1;
        while(candies>0){
            ans[ind] += Math.min(candies, next);
            candies-=next;
            next++;
            ind++;
            ind%=num_people;
        }

        return ans;
    }

}