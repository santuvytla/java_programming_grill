import java.util.Scanner;

public class rotatingarray {
    /*
    make k rotations to the right.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        int arr[]=new int[4];
        for(int i=0;i<4;i++)
        {
            arr[i]=sc.nextInt();
        }
        int n=arr.length;
        if(k==0)
        {
            for(int i=0;i<n;i++)
            {
                System.out.print(arr[i]+" ");
            }
            System.exit(0);
        }
        for(int i=0;i<gcd(k,i);i++)
        {
            int prev=arr[i];
            for(int j=i;true;j=(j+k)%n)
            {
                int temp=arr[(j+k)%n];
                arr[(j+k)%n]=prev;
                prev=temp;
                if((j+k)%n==i)
                {
                    break;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a-b, b);
        return gcd(a, b-a);
    }
}
