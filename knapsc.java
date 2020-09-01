import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class knapsc {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        double k=sc.nextInt();
        double knap[][]=new double[n][3];
        double ans = 0;

        for(int i=0;i<n;i++)
        {
            knap[i][1]=sc.nextDouble();
        }
        for(int i=0;i<n;i++)
        {
            knap[i][2]=sc.nextDouble();
        }
        for(int i=0;i<n;i++)
        {
            knap[i][0]=knap[i][2]/knap[i][1];
        }
        Arrays.sort(knap, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[0] < o2[0])
                    return 1;
                else
                    return -1;
            }
        });
        //calculating ans
        for(int i=0;i<n;i++)
        {
            // if space in bag is greater than
            // item weight we will fully take that item
            if(k > knap[i][1] )
            {
                ans+=knap[i][1]*knap[i][0];
                // since we took the item , remaining weight will be W = W-weights[i]
                k =k-knap[i][1];
            }

            // else we will pick maximum fraction(W) that is possible
            // since after that W will be zero so we can break the loop
            else
            {
                ans+=k*knap[i][0];
                break ;
            }
        }
        System.out.println(ans);

    }

}
