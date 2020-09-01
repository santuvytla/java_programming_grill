package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class keysandrooms {
    /*
    There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0).

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
     */
    public static void main(String[] args) {
        List<List<Integer>> s=new ArrayList<>();
        List<Integer> a=new ArrayList<>();
        a.add(0,1);
        List<Integer> b=new ArrayList<>();
        b.add(0,2);
        List<Integer> c=new ArrayList<>();
        c.add(0,3);
        s.add(0,a);
        s.add(1,b);
        s.add(2,c);
        s.add(3,new ArrayList<>());
        boolean k=keysgame(s);
        System.out.print(k);

    }

    private static boolean keysgame(List<List<Integer>> rooms) {
        Set<Integer> keys = new HashSet<>();
        keys.add(0); // We always have key 0
        for(int i = 0; i < rooms.size(); i++){
            if(keys.contains(i)) visit(keys, rooms, i);
        }
        return keys.size() == rooms.size();

    }

    private static void visit(Set<Integer> s, List<List<Integer>> rooms, int idx) {

        List<Integer> curr = rooms.get(idx);
        for(int i = 0; i < curr.size(); i++){
            // For each key in the unlocked room
            int key = curr.get(i);

            // If we have not unlocked the room
            if(!s.contains(key)){

                // Add the key to the set and visit the room recursively
                s.add(key);
                visit(s, rooms, key);
            }
        }
    }

}
