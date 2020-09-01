import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class birthday {
    /*
    Cowboy Vlad has a birthday today! There are n children who came to the celebration. In order to greet Vlad, the children decided to form a circle around him. Among the children who came, there are both tall and low, so if they stand in a circle arbitrarily, it may turn out, that there is a tall and low child standing next to each other, and it will be difficult for them to hold hands. Therefore, children want to stand in a circle so that the maximum difference between the growth of two neighboring children would be minimal possible.

Formally, let's number children from 1 to n in a circle order, that is, for every i child with number i will stand next to the child with number i+1,
also the child with number 1 stands next to the child with number n.
Then we will call the discomfort of the circle the maximum absolute difference of heights of the children, who stand next to each other.

Please help children to find out how they should reorder themselves, so that the resulting discomfort is smallest possible.

Input
The first line contains a single integer n (2≤n≤100) — the number of the children who came to the cowboy Vlad's birthday.

The second line contains integers a1,a2,…,an (1≤ai≤109) denoting heights of every child.

Output
Print exactly n integers — heights of the children in the order in which they should stand in a circle. You can start printing a circle with any child.

If there are multiple possible answers, print any of them.

Examples
inputCopy
5
2 1 1 3 2
outputCopy
1 2 3 2 1
inputCopy
3
30 10 20
outputCopy
10 20 30
Note
In the first example, the discomfort of the circle is equal to 1, since the corresponding absolute differences are 1, 1, 1 and 0. Note, that sequences [2,3,2,1,1] and [3,2,1,1,2] form the same circles and differ only by the selection of the starting point.

In the second example, the discomfort of the circle is equal to 20, since the absolute difference of 10 and 30 is equal to 20.


This is a greedy problem, we first sort the given heights and after that we make some simple observations: Suppose sorted order was : 1,2,3,4,5,6--here the min value is 5 (between 1 and 6).
We can move 2 to the back to make it look like: 1.....2 to bring down this difference of 5 to 1. Next we keep 3 as it is and move 4 before 2. This is done because we have to also take care of the difference between 2 and its previous adjacent element. So our sequence now looks like : 1 3...4 2. Next we keep 5 as it is and move 6 before 4 for the same greedy reasons as above. So our final sequence is 1 3 5 6 4 2 with the maximimum difference being brought down from 5 to 2. Observe that we are keeping the odd positions intact and picking out the even positions, reversing them and appending them at the end.
     */
    public static void main(String[] args) {
        int n,i,j,k;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int a[]=new int[n];
        for(i=0;i<n;i++)
            a[i]=sc.nextInt();
        Arrays.sort(a);
        Stack<Integer> s=new Stack<>();
        for(i=0;i<n;i++){
            if(i%2!=0)
                s.push(a[i]);
        }
        for(i=n-1;i>=0;--i){
            if(i%2==0)
                s.push(a[i]);
        }
        while(!s.empty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }

}
