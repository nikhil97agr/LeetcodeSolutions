class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        for(int start =1;start<=9;start++){
            generate(result, start, low, high);
        }

        Collections.sort(result);
        return result;
    }

    private void generate(List<Integer> list, long start, int low, int high){
        long next = start + 1;
        if(check(start, low, high)){
            list.add((int)start);
        }
        while(next < 10 && start < high){
            start = start * 10 + next;
            next++;
            if(check(start, low, high)){
                list.add((int)start);
            }
        }
    }

    private boolean check(long num, int low, int high){
        return low <= num && num <= high;
    }
}