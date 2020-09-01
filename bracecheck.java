package com.company;

import java.util.Scanner;
import java.util.Stack;

public class bracecheck {
    public static void main(String[] args) {
        String s;
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        boolean ans=isValid(s);
        System.out.print(ans?"yes":"no");
    }

        public static boolean isValid(String braces) {
            Stack<Character> s = new Stack<>();
            for (char c : braces.toCharArray())
                if (s.size() > 0 && isClosing(s.peek(), c)) s.pop();
                else s.push(c);
            return s.size() == 0;
        }

        public static boolean isClosing(char x, char c) {
            return (x == '{' && c == '}') || (x == '(' && c == ')') || (x == '[' && c == ']');
        }

    }

