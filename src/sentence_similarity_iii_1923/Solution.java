package sentence_similarity_iii_1923;

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String arr1[] = sentence1.split(" ");
        String arr2[] = sentence2.split(" ");

        if(arr1.length > arr2.length) return areSentencesSimilar(sentence2, sentence1);


        int i=0;
        int n= arr1.length;
        int m = arr2.length;
        while(i < n && arr1[i].equals(arr2[i])){
            i++;
        }
        int j1 = n-1;
        int j2 = m-1;
        while(j1 >=0 && arr1[j1].equals(arr2[j2])){
            j1--;
            j2--;
        }


        return j1 < i;


    }
}