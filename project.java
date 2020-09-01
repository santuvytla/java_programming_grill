import java.util.*;

public class project {
    /*
There are n projects you can attend. For each project, you know its starting and ending days and the amount of money you would get as reward. You can only attend one project during a day.

What is the maximum amount of money you can earn?

Input

The first input line contains an integer n: the number of projects.

After this, there are n lines. Each such line has three integers ai, bi, and pi: the starting day, the ending day, and the reward.

Output

Print one integer: the maximum amount of money you can earn.

Constraints
1≤n≤2⋅105
1≤ai≤bi≤109
1≤pi≤109
Example

Input:
4
2 4 4
3 6 6
6 8 2
5 7 3

Output:
7
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][3];
        for(int i=0;i<n;i++)
        {
            arr[i][1]=sc.nextInt();
            arr[i][0]=sc.nextInt();
            arr[i][2]=sc.nextInt();
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

        TreeMap<Integer,Integer> ss=new TreeMap<>();
        ss.put(0,0);
        int sum=0,k;
        for(int i=0;i<n;i++)
        {
        /*   if(ss.containsKey(arr[i][1])){
               k=ss.get(arr[i][1]);

           }
           else
           {
           }
         */
               k=ss.lowerKey(arr[i][1]);

           sum=Math.max(sum,k+arr[i][2]);
           ss.put(arr[i][0],sum);

        }
        System.out.println(sum);




    }
}
