package com.company;

public class espghos {
    /*
    You are playing a simplified Pacman game. You start at the point (0, 0), and your destination is (target[0], target[1]). There are several ghosts on the map, the i-th ghost starts at (ghosts[i][0], ghosts[i][1]).

    Each turn, you and all ghosts simultaneously *may* move in one of 4 cardinal directions: north, east, west, or south, going from the previous point to a new point 1 unit of distance away.

    You escape if and only if you can reach the target before any ghost reaches you (for any given moves the ghosts may take.)  If you reach any square (including the target) at the same time as a ghost, it doesn't count as an escape.

    Return True if and only if it is possible to escape.

            Example 1:
    Input:
    ghosts = [[1, 0], [0, 3]]
    target = [0, 1]
    Output: true
    Explanation:
    You can directly reach the destination (0, 1) at time 1, while the ghosts located at (1, 0) or (0, 3) have no way to catch up with you.

     */
    public static void main(String[] args) {
        int ghosts[][]={{1,0},{0,3}};
        int target[]={0,1};
        boolean k=escape(ghosts,target);
        System.out.print(k);
    }

    private static boolean escape(int[][] ghosts, int[] target) {
        int tp=Math.abs(0-target[0])+Math.abs(0-target[1]);
        for(int i=0;i<ghosts.length;i++){
            int tg=Math.abs(ghosts[i][0]-target[0])+Math.abs(ghosts[i][1]-target[1]);
            if(tg<=tp){
                return false;
            }
        }
        return true;
    }
}
