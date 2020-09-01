import java.util.Arrays;
import java.util.Scanner;

public class stik {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int s=sc.nextInt();
        int sum=0;
        int arr[]=new int[s];
        for(int i=0;i<s;i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int k=arr[s/2];
        for(int i=0;i<s;i++)
        {
            sum+=Math.abs(arr[i]-k);
        }
        System.out.println(sum);
    }
}
