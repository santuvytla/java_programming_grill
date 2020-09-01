package com.company;

public class zumagame {
    /*
Think about Zuma Game. You have a row of balls on the table, colored red(R), yellow(Y), blue(B), green(G), and white(W). You also have several balls in your hand.

Each time, you may choose a ball in your hand, and insert it into the row (including the leftmost place and rightmost place). Then, if there is a group of 3 or more balls in the same color touching, remove these balls. Keep doing this until no more balls can be removed.

Find the minimal balls you have to insert to remove all the balls on the table. If you cannot remove all the balls, output -1.



Example 1:

Input: board = "WRRBBW", hand = "RB"
Output: -1
Explanation: WRRBBW -> WRR[R]BBW -> WBBW -> WBB[B]W -> WW
     */
    public static void main(String[] args) {
        String board="WWRRBBWW";
        String hand="WRBRW";
        int k=minsteps(board,hand);
        System.out.print(k);
    }
    private static int minsteps(String board, String hand) {
        if(board==null || board.length()==0)
        {
            return -1;
        }
        int h[]=new int[26];
        for(char a:hand.toCharArray())
        {
            h[a-'A']++;
        }
        return dfs(board,h);
    }
    private static int dfs(String board, int[] h) {
        board=updateboard(board);
        if(board.length()==0)
        {
            return 0;
        }
        if(isemptyhand(h))
            return -1;
        int curstep=Integer.MAX_VALUE; //cant solve
        for (int i = 0; i < board.length(); i++) {
            char cur = board.charAt(i);
            // check how many balls we need at hand
            int missing=((i+1)<board.length()&&board.charAt(i)==board.charAt(i+1))?1:2;
            if(h[cur-'A']>=missing) {
                h[cur - 'A'] -= missing;
                int furthersteps = dfs(board.substring(0, i) + board.substring(i + 3 - missing), h);
                if (furthersteps != -1) {
                    curstep = Math.min(curstep, furthersteps + missing);
                }
                h[cur - 'A'] += missing;
            }
        }
        if (curstep == Integer.MAX_VALUE) return -1;
        return curstep;
    }

    private static String updateboard(String board) {
        boolean isupdate=false;
        StringBuilder sb=new StringBuilder();
        int j=0;
        while(j<board.length())
        {
            if(j+2<board.length()&&board.charAt(j)==board.charAt(j+1)&&board.charAt(j)==board.charAt(j+2))
            {
                isupdate=true;
                int k=j+3;
                while(k<board.length()&&board.charAt(k)==board.charAt(j))
                {
                    k++;
                }
                j=k;
            }
            else
            {
                sb.append(board.charAt(j));
                j++;
            }
        }
        return isupdate?updateboard(sb.toString()):sb.toString();
    }
    public static boolean isemptyhand(int hand[])
    {
        for (int i : hand) {
            if (i != 0) return false;
        }
        return true;
    }
}
