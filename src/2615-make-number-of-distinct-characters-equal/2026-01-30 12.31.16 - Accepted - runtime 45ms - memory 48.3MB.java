class Solution {
    public boolean isItPossible(String word1, String word2) {
        Map<Character, Integer> m1 = getCnt(word1);
        Map<Character, Integer> m2 = getCnt(word2);

        for (char c1 : m1.keySet()) {

            for (char c2 : m2.keySet()) {
                if(c1 ==c2){
                    if(m1.size() == m2.size()) return true;
                    continue;
                }
                int cnt1 = m1.size();
                int cnt2 = m2.size();
                if (m1.get(c1) == 1)
                    {
                        cnt1--;
                    }
                if (!m2.containsKey(c1))
                    cnt2++;
                if (m2.get(c2) == 1)
                    cnt2--;
                if (!m1.containsKey(c2))
                    cnt1++;

                if (cnt1 == cnt2)
                    return true;


                    
            }
        }

        return false;
    }

    private Map<Character, Integer> getCnt(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        return map;
    }
}