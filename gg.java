import java.util.Scanner;
//different sets
public class gg {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
         int sum=0,ans=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        for(int i=0;i<1<<n;i++)
        {
            int cs=0;
            for(int j=0;j<n;j++)
            {
                int b=i>>j&1;
                if(b>0)
                {
                    cs+=arr[j];
                }

            }
            if(cs<=sum/2)
            {
                ans=Math.max(cs,ans);
            }
        }
        System.out.println(sum-2*ans);

    }

}
