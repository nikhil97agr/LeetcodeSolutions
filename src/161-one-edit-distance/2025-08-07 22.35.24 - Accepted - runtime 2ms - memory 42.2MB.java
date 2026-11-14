class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) return false;
        if(s.isEmpty() && t.length() ==1) return true;
        if(t.isEmpty() && s.length() == 1) return true;

        if(s.isEmpty() || t.isEmpty()) return false;
        int i=0;
        int j=0;
        boolean change =false;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(change) break;

            change = true;
            j++;

        }

        if(i==s.length() && j==t.length() && change) return true;
        if(s.length()==i && j == t.length() -1 && !change) return true;

        change= false;
        i=0;
        j=0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                continue;
            }

            if(change) break;

            change= true;
            i++;
        }
        if(i==s.length() && j==t.length() && change) return true;
        if(j==t.length() && i==s.length() -1 && !change) return true;
        change= false;
        i=0;
        j=0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
                continue;
            }
            if(change) break;
            change= true;
            i++;
            j++;
        }

        return i==s.length() && j == t.length() && change;
    }
}