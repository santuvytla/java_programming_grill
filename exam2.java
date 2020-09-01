
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class exam2 {
    /*
1
5
abcab
     */
    public static final long MOD=(long)1e9+7;
    public static final char arr[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static void main(String[] args) {
        out=new PrintWriter (new BufferedOutputStream(System.out));
        FastReader sc=new FastReader();
        long count=0;
        int t=sc.nextInt();
        while(t-->0) {
            int k=sc.nextInt();
            String s=sc.next();
            StringBuilder s1=new StringBuilder();
            s1.append(s);
            for(char c:arr)
            {
                if(s1.length()==0)
                {
                    break;
                }
                String ss=s1.toString();
                while(ss.indexOf(c)!=-1) {
                     int n=ss.indexOf(c);
                    count +=n+1;
                    s1.deleteCharAt(n);
                    ss=s1.toString();
                }
            }
            out.print(count);
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

