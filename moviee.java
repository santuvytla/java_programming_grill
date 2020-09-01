import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class moviee {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][1]=sc.nextInt();
            arr[i][0]=sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0])
                    return 1;
                else
                    return -1;
            }
        });

        int ans=0,lt=0;
        for(int  i=0;i<n;i++)
        {
            if(arr[i][1]>=lt)
            {
                ans++;
                lt=arr[i][0];
            }
        }
        System.out.println(ans);
    }
}
