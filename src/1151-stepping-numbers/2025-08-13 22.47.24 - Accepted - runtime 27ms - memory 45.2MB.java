class Solution {
    public List<Integer> countSteppingNumbers(int low, int high) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<=9;i++){
            generate(i,i, set, low, high);
        }

        return set.stream().sorted().toList();
    }

    private void generate(int curr, int prevDigit, Set<Integer> set, int low, int high){
        if(curr >= low && curr <= high){
            set.add(curr);
        }
        if(prevDigit > 0){
            long next = 1l*curr*10 + (prevDigit-1);
            if( next <= high){
                generate((int)next, prevDigit - 1, set, low, high);
            }
        }

        if(prevDigit < 9){
            long next = 1l*curr*10 + (prevDigit + 1);
            if( next <= high){
                generate((int)next, prevDigit + 1, set, low, high);
            }
        }
    }
}