import java.util.Scanner;

public class notdivisibleknumber {
    /*
    kth number which is not divisible n in natural numbers
    3 not divisible 7th term
    1 2 4 5 7 8 10
    so 10 is answer
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int lb=1;
        int rb=2*k; //14
        while (lb<rb)
        {
            int mb=(lb+rb)/2; //7 11
            if(mb-mb/n>=k)
            {
                rb=mb; //11
            }
            else
            {
                lb=mb+1; //8
            }
        }
        System.out.println(lb);
    }
}
