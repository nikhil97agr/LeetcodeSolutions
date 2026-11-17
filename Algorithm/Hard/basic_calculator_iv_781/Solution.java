package basic_calculator_iv_781;

import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {

        var map = new HashMap<String, Integer>();
        for (var i = 0; i < evalvars.length; i++) {
            map.put(evalvars[i], evalints[i]);
        }

        return parse(expression).evaluate(map).toList();
    }

    public Polynomial parse(String exp){
        var list = new ArrayList<Polynomial>();
        var symbols = new ArrayList<Character>();
        int n= exp.length();
        var i = 0;
        while(i < n){
            if(exp.charAt(i) == '('){
                var j =i;
                var balance = 0;
                for(;j<n;j++){
                    if(exp.charAt(j) == '(') balance++;
                    else if(exp.charAt(j) == ')') balance--;
                    if(balance==0) break;
                }

                list.add(parse(exp.substring(i+1, j)));
                i = j;
                i++;
                continue;
            }

            if (Character.isLetterOrDigit(exp.charAt(i))) {
                var j = i;
                boolean flag = false;
                for(;j< n;j++){
                    if(exp.charAt(j) == ' '){
                        list.add(make(exp.substring(i, j)));
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    list.add(make(exp.substring(i)));
                }
                i = j;
                i++;
                continue;
            }

            if(exp.charAt(i) != ' '){
                symbols.add(exp.charAt(i));
            }

            i++;
        }

        for(var ind = symbols.size() -1;ind >=0;ind--){
            if(symbols.get(ind) == '*'){
                var p1 = list.get(ind);
                var p2 = list.remove(ind + 1);
                list.set(ind, combine(p1, p2, '*'));
                symbols.remove(ind);
            }
        }

        if(list.isEmpty()) return new Polynomial();
        var result = list.get(0);
        for(var ind = 0;ind < symbols.size();ind++){
            result = combine(result, list.get(ind + 1), symbols.get(ind));
        }

        return result;
        
    }

    private Polynomial make(String s){
        Polynomial result = new Polynomial();
        List<String> list = new ArrayList<>();
        if(Character.isDigit(s.charAt(0))){
            result.update(list, Integer.parseInt(s));
        }else{
            list.add(s);
            result.update(list, 1);
        }

        return result;
    }

    private Polynomial combine(Polynomial p1, Polynomial p2, char symbol){
        if(symbol == '*'){
            return p1.prod(p2);
        }
        if(symbol == '-') return p1.sub(p2);

        return p1.add(p2);
    }
}

class Polynomial {

    Map<List<String>, Integer> map;

    public Polynomial() {

        map = new HashMap<>();

    }

    public void update(List<String> key, int val) {

        map.merge(key, val, Integer::sum);
    }

    public Polynomial add(Polynomial other) {

        var result = new Polynomial();
        for (var entry : map.entrySet()) {
            result.update(entry.getKey(), entry.getValue());
        }

        for (var entry : other.map.entrySet()) {
            result.update(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public Polynomial sub(Polynomial other) {

        var result = new Polynomial();
        for (var entry : map.entrySet()) {
            result.update(entry.getKey(), entry.getValue());
        }

        for (var entry : other.map.entrySet()) {
            result.update(entry.getKey(), -entry.getValue());
        }

        return result;
    }

    public Polynomial prod(Polynomial other) {

        var result = new Polynomial();

        for (var e1 : map.entrySet()) {
            for (var e2 : other.map.entrySet()) {
                var mergeKeys = new ArrayList<String>(e1.getKey());
                mergeKeys.addAll(e2.getKey());
                Collections.sort(mergeKeys);

                result.update(mergeKeys, e1.getValue() * e2.getValue());
            }
        }

        return result;
    }

    public Polynomial evaluate(Map<String, Integer> variableMap) {

        var result = new Polynomial();

        for (var entry : map.entrySet()) {
            var variables = new ArrayList<String>();
            var val = entry.getValue();

            for (var key : entry.getKey()) {
                if (variableMap.containsKey(key)) {
                    val *= variableMap.get(key);
                } else {
                    variables.add(key);
                }
            }
            result.update(variables, val);
        }
        return result;

    }

    public int compare(List<String> l1, List<String> l2) {

        for (int i = 0; i < l1.size(); i++) {
            if (!l1.get(i).equals(l2.get(i))) {
                return l1.get(i).compareTo(l2.get(i));
            }
        }
        return 0;
    }

    public List<String> toList() {

        var result = new ArrayList<String>();
        var keys = new ArrayList<List<String>>(map.keySet());

        keys.sort((k1, k2) -> {
            if (k1.size() != k2.size()) {
                return k2.size() - k1.size();
            }
            return compare(k1, k2);
        });

        for(var key : keys){
            var val = map.get(key);

            if(val ==0) continue;
            StringBuilder res = new StringBuilder();

            res.append(val);

            for(var k : key){
                res.append("*");
                res.append(k);
            }

            result.add(res.toString());
        }

        return result;
    }


}