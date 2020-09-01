
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class exam1 {
    /*
    6 3 4
2 4 3 2 4 5
2 4 3
2 4 5 3 3
2 1 2 3 3
1 1 3
1 4 6
     */
    public static final long MOD=(long)1e9+7;

    public static void main(String[] args) {
        out=new PrintWriter (new BufferedOutputStream(System.out));
        FastReader sc=new FastReader();
        int n=sc.nextInt();
        int m=sc.nextInt();
        int t=sc.nextInt();
       StringBuilder s=new StringBuilder();
       StringBuilder s1=new StringBuilder();
        for(int i=0;i<n;i++)
        {
            s.append(sc.next());
        }
        for(int j=0;j<m;j++)
        {
            s1.append(sc.next());
        }
        String ss=s1.toString();
        String s2=s.toString();
        while(t-->0) {
            int k=sc.nextInt();
            StringBuilder ans=new StringBuilder();
            while (k-->0)
            {
                int d=sc.nextInt();
                int d1=sc.nextInt();
                d--;
                d1--;
                ans.append(s2.substring(d,d1+1));
            }
            String ss1=ans.toString();

                out.print(ss1.equals(ss)?1:0);
                out.print(" ");
        }
        out.close();
    }


    public static PrintWriter out;


    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        //it reads the data about the specified point and divide the data about it ,it is quite fast
        //than using direct

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            //InputStream reads the data and decodes in character stream
            //It acts as bridge between byte stream and character stream
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());//converts string to integer
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}

