class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        solve(new StringBuilder(), word.toCharArray(), 0, result);
        return result;
    }

    private void solve(StringBuilder sb, char word[], int i, List<String> list){
        if(i == word.length){
            list.add(sb.toString());
            return;
        }
        int len = sb.length();
        int cnt = 0;
        sb.append(word[i]);
        len++;
        solve(sb, word, i+1, list);
        sb.deleteCharAt(len-1);
        len--;
        while(i < word.length){
            cnt++;
            sb.append(cnt);
            if(cnt >= 10){
                len++;
            }
            len++;
            if(i+1 < word.length){
                sb.append(word[i+1]);
                len++;
                solve(sb, word, i+2, list);
                sb.deleteCharAt(len - 1);
                len--;
            }else{
                solve(sb, word, i+1, list);
            }
            sb.deleteCharAt(len - 1);
            len--;
            if(cnt >=10){
                sb.deleteCharAt(len - 1);
                len--;
            }
            i++;
        }


    }
}