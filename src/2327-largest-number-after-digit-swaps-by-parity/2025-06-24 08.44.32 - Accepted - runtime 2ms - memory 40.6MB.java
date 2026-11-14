class Solution {
    public int largestInteger(int num) {
        char ch[]= (""+num).toCharArray();

        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for(char c : ch){
            int dig = c-'0';
            if(dig%2==0) even.add(dig);
            else odd.add(dig);
        }

        Collections.sort(even);
        Collections.sort(odd);

        int res = 0;
        int i = even.size()-1;
        int j = odd.size()-1;

        for(char c : ch){
            if(isEven(c)){
                res = res*10 + even.get(i--);
            }else{
                res = res*10 + odd.get(j--);
            }
        }


        return res;

    }

    private boolean isEven(char c){
        int dig = c-'0';

        return dig%2==0;
    }
}