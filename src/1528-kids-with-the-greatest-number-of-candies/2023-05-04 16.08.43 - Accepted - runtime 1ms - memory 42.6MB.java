class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result= new ArrayList<>(candies.length);
        int max = 0;
        for(int x : candies){
            max = Math.max(x, max);
        }

        for(int x : candies){
            if(x+extraCandies>=max){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;

    }
}