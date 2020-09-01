import java.util.Scanner;
import java.util.Vector;

public class nonzeroes {
/*
round formation i.e only leftmost should be digit others should be zeroes..find no of numbers possible for given number
example:
1212
4 possbile
1000
200
10
2
 */
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Vector<Integer> ans=new Vector<>();
    int p=1;
    while(n!=0)
    {
        if(n%10!=0)
        {
            ans.add(n%10*p);
        }
        n/=10;
        p*=10;
    }
    System.out.println(ans.size());
    for(int a:ans)
    {
        System.out.println(a);
    }
}
}

