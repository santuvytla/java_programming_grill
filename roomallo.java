import java.util.*;

public class roomallo {
/*
There is a large hotel, and n customers will arrive soon. Each customer wants to have a single room.

You know each customer's arrival and departure day. Two customers can stay in the same room if the departure day of the first customer is earlier than the arrival day of the second customer.

What is the minimum number of rooms that are needed to accommodate all customers? And how can the rooms be allocated?

Input

The first input line contains an integer n: the number of customers.

Then there are n lines, each of which describes one customer. Each line has two integers a and b: the arrival and departure day.

Output

Print first an integer k: the minimum number of rooms required.

After that, print a line that contains the room number of each customer in the same order as in the input. The rooms are numbered 1,2,…,k.

Constraints
1≤n≤2⋅105
1≤a≤b≤109
Example

Input:
3
1 2
2 4
4 4

Output:
2
1 2 1
 */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][1] = sc.nextInt();
            arr[i][0] = sc.nextInt();
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

        TreeMap<Integer, Integer> ss = new TreeMap<>();
        ss.put(0,0);
        int  k;
        int ans[] = new int[n];
        for (int i = 0; i < n; i++) {
            if (ss.containsKey(arr[i][1])) {
                k = ss.get(arr[i][1]);

            } else {
                try {
                    k = ss.higherKey(arr[i][1]);
                } catch (NullPointerException e) {
                    k = 0;
                }
            }
       //     try {
                if (k != ss.firstKey()) {
                    k = ss.lowerKey(arr[i][1]);
                    ans[i] = ss.get(k);
                    ss.remove(k);
                } else {
                    ans[i] = ss.size();
                    ss.put(arr[i][0], ans[i]);
                }
         /*   } catch (NoSuchElementException e) {
                ans[i] = ss.size();
                ss.put(arr[i][0], ans[i]);
            }
*/

        }
        System.out.println(ss.size());
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + 1 + " ");
        }

















        /*
        for(int i=0;i<n;i++)
        System.out.println(arr[i][0]+" "+arr[i][1]);

        int p=0;
        TreeSet<Integer> k =new TreeSet<>();
        Iterator s = k.iterator();
        for(int i=0;i<n;i++)
        {
            if(k.contains(arr[i][1])){
                 p=arr[i][1];
            }
            else
            {
                 p=k.higher(arr[i][1]);
            }
            if(p!=k.first())
            {
             //   int l=k.headSet(p).size();
              //  int m=l-1;
               // int a=k.
            }
            else
            {

            }
        }
    */


    }
}