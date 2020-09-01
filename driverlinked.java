import java.util.LinkedList;
import java.util.Scanner;

public class driverlinked {
    public static void main(String[] args) {

                        Scanner sc=new Scanner(System.in);
                         int n=sc.nextInt();
                         LinkedList<Integer> ss=new LinkedList<Integer>();
                         for(int i=0;i<n;i++)
                             {
                                 int s=sc.nextInt();
                                 ss.add(s);
                    }
                         Object[] arr =ss.toArray();

                         StringBuilder s = new StringBuilder();
        for(Object a:arr)
        {
            s.append(a);

        }
        String d=s.toString();

        String e=s.reverse().toString();


                         
                         boolean a = false;
                         a=d.contentEquals(e);
                         if(a==true)
                         {
                             System.out.println("1");
                         }
                         else
                         {
                             System.out.println("0");
                         }
                    }
    }


