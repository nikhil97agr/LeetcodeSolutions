package crawler_log_folder_1720;

class Solution {
    public int minOperations(String[] logs) {
        int folder = 0;
        for(String s : logs){
            if(s.startsWith("..")){
                folder = Math.max(0, folder-1);
            }else if(!s.startsWith(".")){
                folder++;
            }
        }

        return folder;
    }
}