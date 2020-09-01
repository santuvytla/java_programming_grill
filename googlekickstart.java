import java.util.Scanner;

public class googlekickstart {
    /*
    n days,each has visitors a..count the special day where special day is when it greater than any other before day 2.or when it is greater than next day or it is last day.
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int ans=0;
        int mx=-1;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++)
        {

            ans+=(arr[i]>mx&&(i==n-1||arr[i]>arr[i+1]))?1:0;
            mx=Math.max(mx,arr[i]);
        }
        System.out.println(ans);
    }
}
