class Solution {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        Map<String, Integer> skillMap = new HashMap<>();
        int x = 0;
        int reqMask = 0;
        for(String skill : req_skills){
            skillMap.put(skill, x++);
        }
        reqMask = (1<<x)-1;

        int n = people.size();
        int m = req_skills.length;
        int mask[] = new int[n];
        for(int i=0;i<n;i++){
            for(String s : people.get(i)){
                int ind = skillMap.get(s);
                mask[i] = (mask[i] | (1<<ind));
            }
        }
        solve(0, 0, mask, reqMask, new ArrayList<>());
        return convertToArray(result);

    }

    private int[] convertToArray(List<Integer> result){
        int arr[] = new int[result.size()];
        for(int i=0;i<result.size();i++){
            arr[i] = result.get(i);
        }
        return arr;
    }
    List<Integer> result = new ArrayList<>();

    private void solve(int i, int currSkill, int mask[], int reqMask, List<Integer> temp){
        if(result.size()>0 && temp.size()>=result.size() || i == mask.length){
            return;
        }

        temp.add(i);

        if((currSkill | mask[i])==reqMask){
            result = new ArrayList<>(temp);

        }else if((currSkill | mask[i]) > currSkill){
            solve(i+1, currSkill | mask[i], mask, reqMask, temp);
        }

        temp.remove(temp.size()-1);
        solve(i+1, currSkill, mask, reqMask, temp);


    }
}