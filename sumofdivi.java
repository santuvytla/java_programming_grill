import java.util.Scanner;

public class sumofdivi {
    /*
    Let σ(n) denote the sum of divisors of an integer n. For example, σ(12)=1+2+3+4+6+12=28.

Your task is to calculate the sum ∑ni=1σ(i) modulo 109+7.

Input

The only input line has an integer n.

Output

Print ∑ni=1σ(i) modulo 109+7.

Constraints
1≤n≤1012
Example

Input:
5

Output:
21
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            int r=n/(n/i);
            ans+=n/i*(r*(r+1)/2-i*(i-1)/2);
            i=r;
        }
        System.out.println(ans);
    }
}
