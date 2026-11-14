/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        Arrays.sort(words);
        while(true){
            Random random  = new Random();
            int min = 0;
            int max = words.length-1;
            String word = null;
            if(max==min){
                word = words[0];
            }else{

            int num = random.nextInt(max-min)+min;
             word = words[num];
            }
            int cnt = master.guess(word);
            if(cnt==6) return;

            words = check(words, word, cnt);
        }
    }

    private String[] check(String words[] ,String word, int count){
        List<String> result = new ArrayList<>();
        for(String s : words){
            if(!s.equals(word)){
                int cnt = 0;
                for(int i=0;i<6;i++){
                    if(s.charAt(i)==word.charAt(i)) cnt++;
                }

                if(cnt == count){
                    result.add(s);
                }
            }
        }

        return result.toArray(new String[result.size()]);
    }
}