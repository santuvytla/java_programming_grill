import java.util.Arrays;

public class threoperatiions {
    /*
    given 3 operations to change any number with any number in the array such that minimum (max-min) is achieved.
     */
    public static void main(String[] args) {
        int arr[]={6,6,0,1,1,4,6};
        if(arr.length<=4)
        {
            System.out.print("0");
            System.exit(0);
        }
        Arrays.sort(arr);
        int ans=Integer.MAX_VALUE;
        for(int i=3,j=arr.length-1;i>=0;--i,--j)
        {
            ans=Math.min(arr[j]-arr[i],ans);
        }
        System.out.println(ans);
    }
}
