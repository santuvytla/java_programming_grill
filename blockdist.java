package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class blockdist {
    /*
    Assume you're looking to move, and have a set of amenities that you want to have easy access to from your new home. You have found a neighborhood you like, each block of which has zero or more amenities. How would you pick the block to live in such that the farthest distance to any amenity in your list is minimized?

Example:
Say your list contains {school, grocery}, and the blocks are as follows:
1: restaurant, grocery
2: movie theater
3: school
4:
5: school

The ideal choice would be block 2, such that the distances to the grocery and the nearest school are 1 each. Living on block 1 or 3 would make one of the distances zero, but the other one 2.
     */
    public static void main(String[] args) {


    }
    public int pickBlock(Set<String> amenities, List<Set<String>> blocks) {
        int block = 0;
        int minLen = Integer.MAX_VALUE;
        Map<String, Integer> window = new HashMap<>();
        for (int lo = 0, hi = 0; hi < blocks.size(); hi++) {
            addBlockToWindow(blocks.get(hi), amenities, window);
            for (; window.size() == amenities.size(); lo++) {
                int len = hi - lo;
                if (len < minLen) {
                    minLen = len;
                    block = (lo + hi) >>> 1;
                }
                removeBlockFromWindow(blocks.get(lo), amenities, window);
            }
        }
        return block;
    }

    private void removeBlockFromWindow(Set<String> block, Set<String> amenities, Map<String, Integer> window) {
        for (String amenity : block) {
            if (amenities.contains(amenity)) {
                window.put(amenity, window.get(amenity) - 1);
                window.remove(amenity, 0);
            }
        }
    }

    private void addBlockToWindow(Set<String> block, Set<String> amenities, Map<String, Integer> window) {
        for (String amenity : block) {
            if (amenities.contains(amenity)) {
                window.put(amenity, window.getOrDefault(amenity, 0) + 1);
            }
        }
    }
}
