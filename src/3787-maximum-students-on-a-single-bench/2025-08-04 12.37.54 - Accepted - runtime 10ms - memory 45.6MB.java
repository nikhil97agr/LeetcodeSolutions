class Solution {
    public int maxStudentsOnBench(int[][] students) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        if(students.length ==0 ) return 0;
        for(int s[] : students){
            map.computeIfAbsent(s[1], x -> new HashSet<>()).add(s[0]);
        }

        return map.values().stream().map(x -> x.size()).max(Integer::compareTo).get();
    }
}