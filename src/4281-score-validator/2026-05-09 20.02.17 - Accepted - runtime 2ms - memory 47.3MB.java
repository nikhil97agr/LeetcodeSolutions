class Solution {
    public int[] scoreValidator(String[] events) {
        int counter = 0;
        int score = 0;

        for(String s : events){
            if(s.equals("W")){
                counter++;
            }else if(s.equals("WD")){
                score++;
            }else if(s.equals("NB")){
                score++;
            }else{
                score += Integer.parseInt(s);
            }

            if(counter == 10) break;
        }


        return new int[]{score, counter};
    }
}