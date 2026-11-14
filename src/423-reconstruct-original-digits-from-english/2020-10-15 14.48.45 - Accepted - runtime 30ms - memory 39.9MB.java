class Solution {
    public String originalDigits(String s) {
        HashMap<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray())
        {
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)+1);
            }
            else
            {
                map.put(c, 1);
            }
        }
        String result = "";
        result += solve(map, 'z', "zero", '0');
        result += solve(map, 'w', "two", '2');
        result += solve(map, 'x', "six", '6');
        result += solve(map, 's', "seven", '7');
        result += solve(map, 'g', "eight", '8');
        result += solve(map, 'h', "three", '3');
        result += solve(map, 'u', "four", '4');
        result += solve(map, 'f', "five", '5');
        result += solve(map, 'o', "one", '1');
        result += solve(map, 'i', "nine", '9');
        char temp[] = result.toCharArray();
        Arrays.sort(temp);
        result = new String(temp);
        return result;
    }
    
    public String solve(HashMap<Character,Integer> map, char c1, String number, char digit)
    {
        if(!map.containsKey(c1)||map.get(c1)<=0)
        {
            return "";
        }
        int count = map.get(c1);
        String result = "";
        for(int i=0;i<count;i++)
        {
            result+=digit;
        }
        for(char c : number.toCharArray())
        {
            map.put(c, map.get(c)-count);
        }
        return result;
        
    }
}