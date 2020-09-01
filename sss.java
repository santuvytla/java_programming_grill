import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class sss {

    public static void main(String[] args) {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        // 4                8
        //1,2,3,4           1,2,3,4,5,6,7,8
        //1,4 // 2,3         //1,4,5,8 //3,2,7,6
        //5
        //1,2,3,4,5
        //print no
        //7
        //1,2,3,4,5,6,7
        //3,5,6
        //1,2,4,7
        Vector<Integer> s1= new Vector<>();
        Vector<Integer> s2= new Vector<>();
        if((n*(n+1)/2)%2==0)
        {
            System.out.println("Yes");
            int j=0;
            if(n%4==0)
            {
                 j=4;
            }
                else
            {
                 j=3;
            }
            for(int i=0;i<(n-1)/4;i++)
            {
                s1.add(4*i+1+j);
                s1.add(4*i+4+j);
                s2.add(4*i+2+j);
                s2.add(4*i+3+j);
            }
            if(n%4==0)
            {
                s1.add(1);
                s1.add(4);
                s2.add(2);
                s2.add(3);
            }
            else
            {
                s1.add(1);
                s1.add(2);
                s2.add(3);
            }
        }
        else{
            System.out.println("NO");
        }
        System.out.println(s1.size());
        Collections.sort(s1);
        for(int i: s1)
        {
            System.out.print(i+" ");
        }
        System.out.println("");
        System.out.println(s2.size());
        Collections.sort(s2);
        for(int i: s2)
        {
            System.out.print(i+" ");
        }
    }
}
