import java.util.Map;
import java.util.Scanner;

public class dicecom {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m= (int) 1e6;
        long arr[]=new long[m];
      /*
        for(int i=-10;i<10;i++)
        {
            arr[i]=0;
        }
       */
        arr[0]=1;
        arr[50]=0;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=Math.min(i,6);j++)
            {
                int k=i-j;
                /*
                if(k<0)
                {
                    k=50;
                }

                 */
                arr[i]=arr[i]+arr[k];
            }
        }
        System.out.println(arr[n]);

    }
}

