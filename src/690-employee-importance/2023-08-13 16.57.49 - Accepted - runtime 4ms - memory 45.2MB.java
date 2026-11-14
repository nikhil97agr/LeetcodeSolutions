/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idMap = new HashMap<>();

        for (Employee e : employees) {
            idMap.put(e.id, e);
        }

        Set<Integer> visited = new HashSet<>();

        return solve(idMap, id, visited);
    }

    private int solve(Map<Integer, Employee> idMap, int id, Set<Integer> visited) {

        visited.add(id);
        Employee e = idMap.get(id);
        int imp = e.importance;

        for (int i : e.subordinates) {
            if (!visited.contains(i)) {
                imp += solve(idMap, i, visited);
            }
        }
        return imp;
    }
}