import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class maxfreqsubstr {
    /*
    Given an array nums of positive integers, return the longest possible length of an array prefix of nums, such that it is possible to remove exactly one element from this prefix so that every number that has appeared in it will have the same number of occurrences.

If after removing one element there are no remaining elements, it's still considered that every appeared number has the same number of ocurrences (0).



Example 1:

Input: nums = [2,2,1,1,5,3,3,5]
Output: 7
Explanation: For the subarray [2,2,1,1,5,3,3] of length 7, if we remove nums[4]=5, we will get [2,2,1,1,3,3], so that each number will appear exactly twice.
Example 2:

Input: nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
Output: 13
     */
    public static void main(String[] args) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        HashMap<Integer, HashSet<Integer>> freqMap = new HashMap<Integer, HashSet<Integer>>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = 0;
        int i;
        HashSet<Integer> set = null;

        // compute frequency of each element
        for (i = 0; i < n; i++) {
            count.put(arr[i], 1 + count.getOrDefault(arr[i], 0));
        }

        // club the elements with same frequency
        for (int key : count.keySet()) {
            i = count.get(key);
            set = freqMap.getOrDefault(i, new HashSet<Integer>());
            set.add(key);
            freqMap.put(i, set);
        }

        for (i = n - 1; i >= 0; i--) {
            if (checkMap(freqMap))
                break;

            deleteFromMaps(count, freqMap, arr[i]);
        }

        System.out.println((i+1));
    }



    // Checks whether the condition that deleting exactly one element makes all frequencies equal is satisfied or not
    private static boolean checkMap(HashMap<Integer, HashSet<Integer>> freqMap) {
        if (freqMap.keySet().size() == 1) {
            int key = freqMap.keySet().iterator().next();
            int s = freqMap.get(key).size();
            if (key == 1) {
                return s > 1;
            } else {
                return s == 1;
            }
        } else if (freqMap.keySet().size() == 2) {
            int x, y;
            Iterator<Integer> it = freqMap.keySet().iterator();
            x = it.next();
            y = it.next();
            int sizeOfX = freqMap.get(x).size();
            int sizeOfY = freqMap.get(y).size();
            return (x == 1 && sizeOfX == 1)
                    || (y == 1 && sizeOfY == 1)
                    || (y + 1 == x && sizeOfX == 1)
                    || (x + 1 == y && sizeOfY == 1);
        } else
            return false;
    }


    // Deletes an element from the maps
    private static void deleteFromMaps(HashMap<Integer, Integer> count, HashMap<Integer, HashSet<Integer>> freqMap, int itemToDelete) {
        int x = count.get(itemToDelete);
        HashSet<Integer> set = null;

        if (x == 1) {
            count.remove(itemToDelete);
            set = freqMap.get(x);
            set.remove(itemToDelete);
            if (set.size() == 0) {
                freqMap.remove(x);
            } else {
                freqMap.put(x, set);
            }
        } else {
            count.put(itemToDelete, x - 1);
            set = freqMap.get(x);
            HashSet<Integer> set2 = freqMap.getOrDefault(x - 1, new HashSet<Integer>());
            set.remove(itemToDelete);
            set2.add(itemToDelete);

            if (set.size() == 0) {
                freqMap.remove(x);
            } else {
                freqMap.put(x, set);
            }

            freqMap.put(x - 1, set2);
        }
    }
}