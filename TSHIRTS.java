
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class TSHIRTS {
    public static final long MOD=(long)1e9+7;

    public static void main(String[] args) {
        out=new PrintWriter (new BufferedOutputStream(System.out));
        FastReader s=new FastReader();
        int t=s.nextInt();
        while(t-->0) {
            int n=s.nextInt();

            int adj[][]=new int[11][101];
            for(int i=0;i<n;i++) {
                String str=s.nextLine();
                String[] splited=str.split(" ");
                for(int j=0;j<splited.length;j++){
                    int tid=Integer.parseInt(splited[j].trim());
                    adj[i][tid]=1;
                }
            }
            long dp[][]=new long [1025][101];
            for(int i=0;i<1025;i++){
                Arrays.fill(dp[i],-1L);
            }
            int allsetmask=(1<<n) -1;
            out.println(recur(0,1,dp,adj,allsetmask,n));
        }
        out.close();
    }

    private static long recur(int mask, int tid, long[][] dp, int[][] adj, int allsetmask,int n) {

        if(mask==allsetmask)
        {
            return 1;
        }
        if(tid==101){
            return 0;
        }

        if(dp[mask][tid]!=-1)
            return dp[mask][tid];

        long ans=recur(mask,tid+1,dp,adj,allsetmask,n)%MOD;
        for(int i=0;i<n;i++){
            if((mask&(1<<i))==0&&adj[i][tid]==1){
                ans=(ans+recur(mask^(1<<i),tid+1,dp,adj,allsetmask,n))%MOD;
            }
        }
        dp[mask][tid]=ans%MOD;
        return dp[mask][tid];
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

