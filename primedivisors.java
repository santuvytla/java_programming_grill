import java.util.Scanner;
import java.util.stream.IntStream;

public class primedivisors {
    private static boolean isPrime(int a) {
        return IntStream.rangeClosed(2, a / 2).noneMatch(i -> a % i == 0);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=0;
        for(int i=2;i<=n;i++) {
            ans+=solve(i);
        }
        System.out.println(ans);
    }

    private static int solve(int n) {
        int a[]=new int[n];
        int j=0;
        for(int i=2;i<=n;i++)
        {
            if (isPrime(i)) {
                a[j++]=i;
            }
        }
        int o=a.length;
        int sum=0;
        for(int i=0;i<o;i++) {
            if (a[i] != 0) {
                while (n % a[i] == 0 && n != 0) {
                    n /= a[i];
                    sum++;
                }
            }
        }
        return sum;
    }

}
