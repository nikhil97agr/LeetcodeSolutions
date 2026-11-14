class Solution {
    public boolean canConvert(String str1, String str2) {
        if(str1.equals(str2)) return true;
        Set<Integer> set = new HashSet<>();
        int map[] = new int[26];
        Arrays.fill(map, -1);

        for(int i=0;i<str1.length();i++){
            int i1= str1.charAt(i) - 'a';
            int i2 = str2.charAt(i) - 'a';

            if(map[i1] !=-1 && map[i1] != i2) return false;

            map[i1] = i2;
            set.add(i2);
        }

        return set.size() != 26;
    }
}