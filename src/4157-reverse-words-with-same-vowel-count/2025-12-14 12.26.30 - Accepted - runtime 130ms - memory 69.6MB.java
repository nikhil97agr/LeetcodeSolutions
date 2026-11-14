class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder(arr[0]);
        int cnt = getCnt(arr[0]);

        for(int i=1;i<arr.length;i++){
            if(cnt == getCnt(arr[i])){
                sb.append(" "+reverse(arr[i]));
            }else{
                sb.append(" "+arr[i]);
            }
        }

        return sb.toString();
    }

    int getCnt(String s){
        Set<Character> set = Set.of('a','e','i','o','u');

        int cnt= 0;
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                cnt++;
            }
        }

        return cnt;
    }

    String reverse(String s){
        StringBuilder sb = new StringBuilder(s);

        return sb.reverse().toString();
    }
}