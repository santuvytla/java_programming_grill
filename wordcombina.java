import java.util.Scanner;

public class wordcombina {
    /*
    You are given a string of length n and a dictionary containing k words. In how many ways can you create the string using the words?

Input

The first input line has a string containing m characters between a–z.

The second line has an integer k: the number of words in the dictionary.

Finally there are k lines describing the words. Each word is unique and consists of characters a–z.

Output

Print the number of ways modulo 109+7.

Constraints
1≤n≤5000
1≤k≤105
the total length of the words is at most 106
Example

Input:
ababc
4
ab
abab
c
cb

Output:
2

Explanation: The possible ways are ab+ab+c and abab+c
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String t=sc.nextLine();
        int k=sc.nextInt();
        int n=t.length();
        int dp[]=new int[100];
        dp[0]=1;
        String s[]=new String[100];
        for(int i=0;i<k;i++)
        {
            s[i]=sc.next();
        }
        for(int i=1;i<=n;i++) //keeping track of string length
        {
            for(int j=0;j<k;j++) //keeping track of dictionary provided
            {
                boolean ok=i>=s[j].length();
                for(int l=0;l<s[j].length()&&ok;l++) //keeping track of all the words in dict length
                {
                    ok&=t.charAt(i-s[j].length()+l)==s[j].charAt(l);
                }
                if(ok)
                {
                    dp[i]=dp[i]+dp[i-s[j].length()];
                }
            }
        }
        System.out.println(dp[n]);
    }
}
