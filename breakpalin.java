import java.util.Scanner;

public class breakpalin {
    /*
    Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the string becomes the lexicographically smallest possible string that isn't a palindrome.

After doing so, return the final string.  If there is no way to do so, return the empty string.



Example 1:

Input: palindrome = "abccba"
Output: "aaccba"
Example 2:

Input: palindrome = "a"
Output: ""
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        char c[]=s.toCharArray();
        int n=s.length();
        if(n==1)
        {
            System.out.println("");
            System.exit(0);
        }
        for(int i=0;i<n;i++)
        {
            int j=n-1-i;
            if(i==j)
            {
                continue;
            }
            if(c[i]!='a')
            {
                c[i]='a';
                String ans=String.valueOf(c);
                System.out.println(ans);
                System.exit(0);
            }
        }
        c[n-1]='b';
        String ans=String.valueOf(c);
        System.out.println(ans);


    }
}
