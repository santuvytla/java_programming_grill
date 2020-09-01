import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class operofarr {
    /*
    You are given an array of  elements and an integer . You must perform the following types of operations on the array:

Find the index of the  occurrence of  in the range  to  (both inclusive). If there are no indexes that satisfy the condition, then print .
Update the value that is present at the given index.
For each query of type 1, print the index of the  occurrence of .

Input format

The first line contains two integers  and  denoting the number of elements and an integer whose index is required respectively.
The second line contains  integers  denoting the elements of the array
The third line contains an integer  denoting the number of queries
Next q lines contain the following type of queries:
If type is equal to 1, then , , and  (refer to the first point of the problem statement)
If type is equal to 2, then index and value (refer to the second point of the problem statement)
Output format

Print  integers as the answer to type 1 queries. If there are no indexes that satisfy the condition, then print -1
input:
7 1
2 1 3 1 1 4 5
5
1 1 2 1
1 2 3 1
1 4 5 1
2 2 2
1 1 2 3
     */
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        }

    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        int x=sc.nextInt();
        int arr[]=new int[n+1];
        List<Integer> s=new LinkedList<>();
        for(int i=1;i<n+1;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]==x)
            {
                s.add(i);
            }
        }
        Collections.sort(s);
        int t=sc.nextInt();
        while(t!=0)
        {
            int type=sc.nextInt();
            if(type==1)
            {
                int l=sc.nextInt();
                int r=sc.nextInt();
                int k=sc.nextInt();
                Object ar[]=s.toArray();
                int aa[]=new int[ar.length];
                int ar1[]=new int[ar.length];
                for(int i=0;i<ar.length;i++)
                {
                    aa[i]=(int)ar[i];
                }
                int j=0;
                for(int i=0;i<ar.length;i++)
                {
                    if(aa[i]>=l&&aa[i]<=r)
                    {
                        ar1[j++]=aa[i];
                    }
                }
                if(k<ar1.length) {
                    System.out.println(ar1[k-1]);
                }
                else
                {
                    System.out.println("-1");
                }


            }
            else
            {
                int id=sc.nextInt();
                int val=sc.nextInt();
                if(arr[id]==x)
                {
                    s.remove(id);
                }
                if(val==x)
                {
                    s.add(id);
                }
                arr[id]=val;
            }
            t--;
        }


    }
}
