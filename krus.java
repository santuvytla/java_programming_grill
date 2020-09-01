import java.util.*;

public class krus {
    // storing parent of vertex
  static   int par[]=new int[10000];
    // also storing size of MST
   static int size[]=new int[1000];
  static   int n=0;
   static ArrayList<int[]> MST=new ArrayList<int[]>();
  static   Boolean visited[]=new Boolean[1000];
    // function for initializing
   static void UnionFind(int siz) {
        n = siz;
        for (int i = 0; i <= n; i++) {
            par[i] = i;
            size[i] = 1;
            visited[i]=false;

        }
    }

    public static int find(int p) {
        int root = p;
        while (root != par[root]) {
            root = par[root];
        }
        //Using Path-Compression for much better time-complexity
        //refer our previous article for this
        while (p != root) {
            int next = par[p];
            par[p] = root;
            p = next;
        }
        return root;
    }
    static boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // unifying(merging) the MST graph
  static void unify(int p, int q) {
        if (connected(p, q)) return;

        int root1 = find(p);
        int root2 = find(q);

        if (size[root1] < size[root2]) {
            size[root2] += size[root1];
            par[root1] = root2;
        }
        else {
            size[root1] += size[root2];
            par[root2] = root1;
        }

    }

  static  int sum = 0;

    // used for visiting the graph and calculating the sums of its weighted edges.
   static int dfs(int u) {
        visited[u] = true;
        for (int i = 1; i <=3; i++) {
            if (!visited[MST.get(i)[1]]) {
                sum += MST.get(i)[0];
                visited[i]=true;
             //  dfs(MST.get(u)[1]);
            }
        }
        return sum;
    }


    public static void main(String[] args) {
       /*
       input
       3 3
       5 1 2
       6 2 3
       7 3 1
       output
       11
        */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        // initializing everything.
        UnionFind(p);
        int arr[][]=new int[n][3];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
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
        for(int i=0;i<=n;i++)
        {
            MST.add(i, new int[]{0, 0});
        }
        int start = -1;
        for ( int i = 0; i < n; i++) {
            if (!connected(arr[i][1], arr[i][2])) {
                start = arr[i][1];
                int a1[]={arr[i][0],arr[i][2]};
                int a2[]={arr[i][0],arr[i][1]};

                MST.add(arr[i][1],a1);
                MST.add(arr[i][2],a2);
                unify(arr[i][1], arr[i][2]);
            }
        }
        // just calculating the cost of MST using dfs.
       int k= dfs(start);
        System.out.println(k);
    }
}
