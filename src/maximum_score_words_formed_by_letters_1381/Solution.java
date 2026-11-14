package maximum_score_words_formed_by_letters_1381;

class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int count[] = new int[26];
        for(char c : letters){
            count[c-'a']++;
        }
        int n = words.length;
        return solve(words, score, count, 0, n);
    }

    private int solve(String words[], int score[], int count[], int i, int n){
        if(i==n){
            return 0;
        }

        int wordScore = 0;
        int nextCount[] = count.clone();

        for(char c : words[i].toCharArray()){
            if(nextCount[c-'a']==0){
                wordScore = 0;
                break;
            }
            wordScore += score[c-'a'];
            nextCount[c-'a']--;
        }

        if(wordScore>0){
            wordScore = solve(words, score, nextCount, i+1, n) + wordScore;
        }

        wordScore = Math.max(solve(words, score, count, i+1, n), wordScore);
        return wordScore;
    }
}