import java.util.Scanner;

public class Evenpicture {
    /*
Leo Jr. draws pictures in his notebook with checkered sheets (that is, each sheet has a regular square grid printed on it). We can assume that the sheets are infinitely large in any direction.

To draw a picture, Leo Jr. colors some of the cells on a sheet gray. He considers the resulting picture beautiful if the following conditions are satisfied:

The picture is connected, that is, it is possible to get from any gray cell to any other by following a chain of gray cells, with each pair of adjacent cells in the path being neighbours (that is, sharing a side).
Each gray cell has an even number of gray neighbours.
There are exactly n gray cells with all gray neighbours. The number of other gray cells can be arbitrary (but reasonable, so that they can all be listed).
Leo Jr. is now struggling to draw a beautiful picture with a particular choice of n. Help him, and provide any example of a beautiful picture.

To output cell coordinates in your answer, assume that the sheet is provided with a Cartesian coordinate system such that one of the cells is chosen to be the origin (0,0), axes 0x and 0y are orthogonal and parallel to grid lines, and a unit step along any axis in any direction takes you to a neighbouring cell.

Input
The only line contains a single integer n (1≤n≤500) — the number of gray cells with all gray neighbours in a beautiful picture.

Output
In the first line, print a single integer k — the number of gray cells in your picture. For technical reasons, k should not exceed 5⋅105.

Each of the following k lines should contain two integers — coordinates of a gray cell in your picture. All listed cells should be distinct, and the picture should satisdfy all the properties listed above. All coordinates should not exceed 109 by absolute value.

One can show that there exists an answer satisfying all requirements with a small enough k.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int totalitems=1+7*(k+1);
        boolean grid[][]=new boolean[15][15];
        System.out.println(totalitems);
        System.out.println("0 0");
        int x=0;
        for(int i=0;i<=k;i++)
        {
            System.out.println((x+1)+" "+(x));
            System.out.println((x)+" "+(x+1));
            System.out.println((x+2)+" "+(x));
            System.out.println((x)+" "+(x+2));
            System.out.println((x+2)+" "+(x+1));
            System.out.println((x+1)+" "+(x+2));
            System.out.println((x+2)+" "+(x+2));
            x+=2;
        }

    }
}
