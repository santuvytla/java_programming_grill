import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class slidmdi {
    private static int median(int[] arr) {


        Arrays.sort(arr);
        int l=arr.length;
        int m=arr[l/2];
        return m;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<n-2;i++)
        {
            int a=i;
            int arr1[]=new int[p];
            for(int o=0;o<p;o++)
            {
                arr1[o]=arr[a];
                a++;
            }
            int k=median(arr1);
            System.out.print(k+" ");

        }




    }


}
