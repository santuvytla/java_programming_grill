public class arrayrotatee {
    /*
    rotate the giveen array
     */
    public static void main(String[] args) {
        int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

        int n=arr.length;

        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
        for(int i=0;i<n/2;i++)
        {
            for(int j=0;j<(n+1)/2;j++)
            {
                int prev=arr[i][j];
                for(int rep=0;rep<4;rep++)
                {
                    int newx=j;
                    int newy=n-1-i;
                    int tmp=arr[newx][newy];
                    arr[newx][newy]=prev;
                    i=newx;
                    j=newy;
                    prev=tmp;
                }
            }
        }
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
