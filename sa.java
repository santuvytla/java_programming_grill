import java.util.Scanner;

public class sa {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
         int n,s=1;
         n=sc.nextInt();
        /* for(int i=0;i<n;i++)
         {
            s=s*2%((int)1e9+7);


         }

         */
        s= (int) Math.pow(2,n);

         System.out.println(s);

    }

}

