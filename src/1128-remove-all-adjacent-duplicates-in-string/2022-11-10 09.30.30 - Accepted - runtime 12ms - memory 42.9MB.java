class Solution {
    public String removeDuplicates(String s) {
        LinkedList<Character> list = new LinkedList();
        for(char c : s.toCharArray()){
            if(list.isEmpty()){
                list.add(c);
                continue;
            }
            if(list.getLast()==c){
                list.removeLast();
            }else{
                list.add(c);
            }
        }
        char ch[] = new char[list.size()];
        Iterator<Character> it =  list.iterator();
        int i=0;
        while(it.hasNext()){
            ch[i++] = it.next();
        }

        return new String(ch);
    }
}