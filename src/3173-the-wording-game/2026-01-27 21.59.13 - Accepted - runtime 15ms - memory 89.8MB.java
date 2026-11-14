class Solution {
    public boolean canAliceWin(String[] a, String[] b) {
        boolean turn = false;
        int alice = 0;
        int bob = 0;
        while(alice < a.length && bob < b.length){
            if(turn){
                while(alice < a.length && !check(b[bob], a[alice])){
                    alice++;
                }

                if(alice < a.length){
                    bob++;
                    turn = false;
                }else{
                    return false;
                }
            }else{
                while(bob < b.length && !check(a[alice], b[bob])){
                    bob++;
                }

                if(bob < b.length){
                    alice++;
                    turn = true;
                }else{
                    return true;
                }
            }
        }

        return !turn;
    }

    private boolean check(String src, String dest){
        int i1 = 0;
        int i2 = 0;
        if(src.compareTo(dest) > 0) return false;
        char c1 = src.charAt(0);
        char c2 = dest.charAt(0);

        return c1 == c2  || c1 +1 == c2;
    }
}