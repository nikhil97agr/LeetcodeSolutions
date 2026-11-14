package largest_merge_of_two_strings_1880;

class Solution {
    public String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        int j=0;
        int n = word1.length();
        int m = word2.length();

        while(i< n && j < m){
            if(word1.charAt(i) > word2.charAt(j)){
                sb.append(word1.charAt(i));
                i++;
            }else if(word1.charAt(i) < word2.charAt(j)){
                sb.append(word2.charAt(j));
                j++;
            }else{
                int res = check(i, j, n, m, word1.toCharArray(), word2.toCharArray());

                if(res==1){
                    sb.append(word1.charAt(i));
                    i++;
                }else{
                    sb.append(word2.charAt(j));
                    j++;
                }
            }
        }

        while(i < n){
            sb.append(word1.charAt(i));
            i++;
        }

        while(j < m){
            sb.append(word2.charAt(j));
            j++;
        }

        return sb.toString();
    }

    private int check(int i, int j, int n, int m, char a[], char b[]){
        while(i < n && j < m && a[i] == b[j]){
            i++;
            j++;
        }

        if(i ==n) return -1;
        if(j==m) return 1;

        if(a[i] > b[j]) return 1;
        return -1;
    }
}