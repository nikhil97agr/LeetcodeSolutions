package stream_of_characters_1097;

import java.util.*;
class StreamChecker {
    Stack<Character> stack;
    Trie trie;
    public StreamChecker(String[] words) {
        stack = new Stack<>();
        trie = new Trie();
        for(String s : words){
            trie.add(s.toCharArray(), s.length() - 1);
        }
    }
    
    public boolean query(char letter) {
        stack.push(letter);

        return trie.check(stack);
    }
}

class Trie{
    Trie trie[];
    boolean isLast;
    public Trie(){
        trie = new Trie[26];
    }

    public void add(char ch[], int i){
        if(i < 0){
            isLast = true;
            return;
        }
        int ind = ch[i] - 'a';
        if(trie[ind] == null) trie[ind ] = new Trie();

        trie[ind].add(ch, i-1);
    }

    public boolean check(Stack<Character> stack){
        if(stack.isEmpty()) return isLast;

        if(isLast) return true;
        char ch = stack.pop();
        int ind = ch - 'a';

        if(trie[ind] == null){
            stack.push(ch);
            return false;
        }

        boolean res = trie[ind].check(stack);
        stack.push(ch);
        return res;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */