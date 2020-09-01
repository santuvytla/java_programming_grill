package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class openlock {
    /*
    You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
    The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.



Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
     */
    public static int dir[]={1,-1};
    public static void main(String[] args) {
        //bfs
        String deadends[]={"0201","0101","0102","1212","2002"};
        String target="0202";
        int k=openit(deadends,target);
        System.out.print(k);

    }

    private static int openit(String[] ends, String target) {
        Set<String> deadends = new HashSet<>();
        for (String dead: ends) {
            deadends.add(dead);
            if (dead.equals("0000") || dead.equals(target)) {
                return -1;
            }
        }
        Queue<String> combination = new LinkedList<>();
        combination.add("0000");
        int ans = 0;
        deadends.add("0000");
        while(!combination.isEmpty()) {
            int size = combination.size();
            while(--size >= 0) {
                String lock = combination.poll();
                char[] lockArray = lock.toCharArray();
                if (lock.equals(target)) {
                    return ans;
                }
                for (int i = 0; i < 4; i++) {
                    char ch = lockArray[i];
                    for (int d: dir) {
                        rotate(lockArray, i, d);
                        String newLock = new String(lockArray);
                        if (!deadends.contains(newLock)) {
                            deadends.add(newLock);
                            combination.add(newLock);
                        }
                        lockArray[i] = ch;
                    }
                }
            }
            ans++;
        }
        return -1;
    }

    private static void rotate(char[] lock, int i, int d) {
        int n = lock[i] - '0';
        n = (n + d + 10) % 10;
        lock[i] = (char)(n + '0');
    }
}
