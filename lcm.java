import java.util.Scanner;

public class lcm {
    /*
    Ivan has number b. He is sorting through the numbers a from 1 to 1018, and for every a writes [a,b]a on blackboard. Here [a,b] stands for least common multiple of a and b. Ivan is very lazy, that's why this task bored him soon. But he is interested in how many different numbers he would write on the board if he would finish the task. Help him to find the quantity of different numbers he would write on the board.

Input
The only line contains one integer — b (1≤b≤1010).

Output
Print one number — answer for the problem.

Examples
inputCopy
1
outputCopy
1
inputCopy
2
outputCopy
2
Note
In the first example [a,1]=a, therefore [a,b]a is always equal to 1.

In the second example [a,2] can be equal to a or 2⋅a depending on parity of a. [a,b]a can be equal to 1 and 2.


We know that lcm(a, b) x gcd(a, b) = a x b. So lcm(a, b)/a = b/gcd(a, b).
 We need to find how many different values b/gcd(a, b) takes. For each different value of b/gcd(a, b) there is a corresponding different value for gcd(a, b),
 so its suffice to see how many different values gcd(a, b) will take. Since gcd(a, b) divides b for any a, gcd(a, b) will take values which are divisors of b.
 Also it can take the values of all the divisors of b.
 If j is a factor of b, then gcd(a, b) can take the value j when a = j, so gcd(a, b) can take all the values of divisors of b.
 Now the answer becomes no of divisors of b. To find this there is a standard technique which can be done in O(√b) time complexity given in the code below
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long b=sc.nextLong();
        long k=0,j,i;
        double y = Math.sqrt(b);
        double p = Math.floor(y);
        for(i=1;i<=p;i++)
        {
            j = b/i;
            if(i*j == b)
                k++;
        }
        if(y==p)
            System.out.print((2*k)-1);
        else
            System.out.print(2*k);
    }
}
