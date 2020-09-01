import java.util.Scanner;

public class factory {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        long ll=1,rb=Long.MAX_VALUE;
        while(ll<rb){
            long mb=(ll+rb)/2,s=0;
            for(int i=0;i<n;i++)
            {
                s+=Math.min(mb/arr[i],Long.MAX_VALUE);

            }
            if(s>=k)
            {
                rb=mb;
            }
            else {
                ll=mb+1;
            }
        }
        System.out.println(ll);
    }
}
