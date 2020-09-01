import java.util.*;
     public class linkedoccur
    {
        public static LinkedList<Integer> deleteAllOccurences(LinkedList<Integer> ss,int k )
             {
                     ss.removeAll(Collections.singleton(k));
                     return ss;
             }
             public static void main (String[] args) {
                 Scanner sc=new Scanner(System.in);
                 int n=sc.nextInt();
                 LinkedList<Integer> ss=new LinkedList<Integer>();
                 for(int i=0;i<n;i++) {
                     int c=sc.nextInt();
                     ss.add(c);
                 }
                 int k=sc.nextInt();
                 LinkedList<Integer> sss=new LinkedList<Integer>();
                 sss=deleteAllOccurences(ss,k);
                 System.out.print("The list after deletion: ");
                 for(int p:sss)
                 {
                     System.out.print(p+" ");
                 }
             }
         }