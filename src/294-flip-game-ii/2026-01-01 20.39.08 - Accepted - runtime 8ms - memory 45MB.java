class Solution {
    public boolean canWin(String currentState) {
        if(currentState.length() < 2) return false;
        return solve(currentState.toCharArray(), new HashMap<>(), 0);
    }

    private boolean solve(char ch[], Map<String, Boolean> dp, int turn){
        String key = new String(ch)+":"+turn;

        if(dp.containsKey(key)){
            return dp.get(key);
        }

        for(int i=0;i<ch.length -1;i++){
            if(ch[i] == '+' && ch[i+1] == '+'){
                ch[i] = ch[i+1] = '-';
                if(turn ==0){
                    if(solve(ch, dp, 1)){
                        dp.put(key, true);
                        ch[i] = ch[i+1] = '+';
                        return true;
                    }
                }else if(turn == 1 ){
                    if(!solve(ch, dp, 0)){
                        dp.put(key, false);
                        ch[i] = ch[i+1] = '+';
                        return false;
                    }
                }
                ch[i] = ch[i+1] = '+';
            }
        }

        dp.put(key, turn ==1);
        return turn == 1;
    }


}