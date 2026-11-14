package count_vowel_strings_in_ranges_2691;

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
      boolean vowels[] = new boolean[26];
              vowels[0] = true;
                      vowels['e'-'a'] = true;
                              vowels['i'-'a'] = true;
                                      vowels['o'-'a'] = true;
                                              vowels['u'-'a'] = true;
                                                      int n = words.length;
                                                              int count[] = new int[n];
                                                                      int total = 0;
                                                                              for(int i=0;i<n;i++){
                                                                                          int m = words[i].length();
                                                                                                      if(vowels[words[i].charAt(0)-'a'] && vowels[words[i].charAt(m-1)-'a']){
                                                                                                                      total++;
                                                                                                                                  }

                                                                                                                                                          count[i] = total;
                                                                                                                                                                  }
                                                                                                                                                                          n = queries.length;
                                                                                                                                                                                  int result[] = new int[n];
                                                                                                                                                                                          for(int i=0;i<n;i++){
                                                                                                                                                                                                      if(queries[i][0]==0){
                                                                                                                                                                                                                      result[i] = count[queries[i][1]];
                                                                                                                                                                                                                                  }else{
                                                                                                                                                                                                                                                  result[i] = count[queries[i][1]] - count[queries[i][0]-1];
                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                                                              return result;  
    }
}