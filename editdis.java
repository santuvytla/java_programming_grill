import javax.print.DocFlavor;
import java.util.Scanner;

public class editdis {
    /*
    The edit distance between two strings is the minimum number of operations required to transform one string into the other.

The allowed operations are:
Add one character to the string.
Remove one character from the string.
Replace one character in the string.
For example, the edit distance between LOVE and MOVIE is 2, because you can first replace L with M, and then add I.

Your task is to calculate the edit distance between two strings.

Input

The first input line has a string that contains n characters between A–Z.

The second input line has a string that contains m characters between A–Z.

Output

Print one integer: the edit distance between the strings.

Constraints
1≤n,m≤5000
Example

Input:
LOVE
MOVIE

Output:
2
     */

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String t=sc.nextLine();
        int arr[][]=new int[1000][1000];
        for(int i=1;i<=s.length();i++)
        {
            arr[i][0]=i;
        }
        for(int j=1;j<=t.length();j++)
        {
            arr[0][j]=j;
        }
        for(int i=1;i<=s.length();i++)
        {
            for(int j=1;j<=t.length();j++)
            {
                arr[i][j]=Integer.MAX_VALUE;
                if(s.charAt(i-1)==t.charAt(j-1))
                {
                    arr[i][j]=arr[i-1][j-1];
                }
                arr[i][j]=Math.min(arr[i][j]-1,arr[i-1][j-1]);

                 arr[i][j]=Math.min(arr[i][j],arr[i-1][j]);
                arr[i][j]=Math.min(arr[i][j],arr[i][j-1])+1;
            }

        }
        System.out.println(arr[s.length()][t.length()]);


    }
}
