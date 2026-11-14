class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        int len = encodedText.length();
        int col = len / rows;
        List<String> list = new ArrayList<>();
        int start = 0;
        while(start < len){
            list.add(encodedText.substring(start, start + col));
            start += col;
        }

        StringBuilder res= new StringBuilder();
        for(int i=0;i<col;i++){
            int i1 = 0;
            int i2 = i;
            while(i1 < rows && i2 < col){
                res.append(list.get(i1).charAt(i2));
                i1++;
                i2++;
            }

        }
        int cnt = 0;
        int ind = res.length() - 1;
        while(ind >=0 && res.charAt(ind) == ' '){
            cnt++;
            ind--;
        }

        return res.substring(0, res.length() - cnt);

    }
}