class Solution {
    public int passwordStrength(String password) {
        int sum = 0;
        boolean vis[] = new boolean[256];

        for(var c : password.toCharArray()){
            if(vis[c]) continue;
            vis[c] = true;
            if(Character.isLowerCase(c)){
                sum++;
            }else if(Character.isUpperCase(c)){
                sum += 2;
            }else if(Character.isDigit(c)){
                sum += 3;
            }else if(c == '!' || c=='@' || c=='#'|| c== '$'){
                sum += 5;
            }
        }

        return sum;

    }
}