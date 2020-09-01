import java.util.Scanner;
import java.util.TreeSet;

public class f {
        /*
        There are n concert tickets available, each with a certain price. Then, m customers arrive, one after another.
Each customer announces the maximum price he or she is willing to pay for a ticket, and after this, they will get a ticket with the nearest possible price such that it does not exceed the maximum price.
Input
The first input line contains integers n and m: the number of tickets and the number of customers.
The next line contains n integers h1,h2,…,hn: the price of each ticket.
The last line contains m integers t1,t2,…,tm: the maximum price for each customer.

Output
Print, for each customer, the price that they will pay for their ticket. After this, the ticket cannot be purchased again.
If a customer cannot get any ticket, print −1.
Constraints
1≤n,m≤2⋅105
1≤hi,ti≤109
Example
Input:
5 3
5 3 7 8 5
4 8 3
Output:
3
8
-1
         */
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k1[]=new int[m];
            TreeSet<Integer> a = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                int k=sc.nextInt();
                a.add(k);
            }
            for(int i=0;i<m;i++)
            {
                k1[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++)
            {
                if(a.contains(k1[i]))
                {
                    System.out.println(k1[i]);
                    a.remove(k1[i]);
                }
                else
                {
                    System.out.println(a.lower(k1[i]));
                  try {
                      a.remove(a.lower(k1[i]));
                  }
                  catch(NullPointerException e)
                  {
                      System.out.print("");
                  }
                }
            }

        }

}
