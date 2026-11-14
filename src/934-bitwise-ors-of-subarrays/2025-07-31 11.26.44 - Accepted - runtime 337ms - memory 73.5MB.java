class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> curr = new HashSet<>();
        for(int x : arr){
            Set<Integer> next = new HashSet<>();

            for(int y : curr){
                next.add(y | x);

            }

            next.add(x);
            set.addAll(next);
            curr = next;
        }

        return set.size();
    }
}