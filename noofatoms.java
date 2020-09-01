package com.company;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class noofatoms {
    /*
    Given a chemical formula (given as a string), return the count of each atom.

An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.

Example 1:
Input:
formula = "H2O"
Output: "H2O"
Explanation:
The count of elements are {'H': 2, 'O': 1}.
Example 2:
Input:
formula = "Mg(OH)2"
Output: "H2MgO2"
Explanation:
The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
     */
    public static void main(String[] args) {
        String formula="Mg(OH)2";
        String ans=atomnumb(formula);
        System.out.print(ans);
    }

    private static String atomnumb(String formula) {
        Map<String, Integer> temp = new TreeMap<>();
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(temp);

        for (int i = 0; i < formula.length(); ) {
            if (Character.isUpperCase(formula.charAt(i))) {
                String str = "" + formula.charAt(i);
                Map<String, Integer> map = stack.peek();

                for (i = i + 1; i < formula.length(); i++) {
                    char c = formula.charAt(i);
                    if (Character.isLowerCase(c)) {
                        str+=c;
                    }
                    else
                    {
                        break;
                    }
                }
                int existCount = map.getOrDefault(str,0);
                if (i >= formula.length() || !Character.isDigit(formula.charAt(i))){
                    map.put(str, existCount+1);
                } else {
                    int count = 0;
                    while (i < formula.length() && Character.isDigit(formula.charAt(i))){
                        count = count * 10 + formula.charAt(i) - '0';
                        i++;
                    }
                    map.put(str, existCount+count);
                }

            }
            else if (formula.charAt(i) == '('){
                temp = new TreeMap<>();
                stack.push(temp);
                i++;
            }
            else {
                Map<String, Integer> temp2 = stack.pop();
                i=i+1;
                int count = 0;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))){
                    count = count * 10 + formula.charAt(i) - '0';
                    i++;
                }
                Map<String, Integer> pre = stack.peek();
                for (String key: temp2.keySet()) {
                    int preCount = pre.getOrDefault(key, 0);
                    preCount += temp2.get(key) * count;
                    pre.put(key, preCount);
                }

            }

        }
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> res = stack.peek();
        for (String str: res.keySet()){
            int resCount = res.get(str);
            sb.append(str);
            if (resCount > 1){
                sb.append(resCount);
            }
        }
        return sb.toString();


    }
}
