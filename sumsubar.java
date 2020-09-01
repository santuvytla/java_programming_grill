import java.util.Arrays;

public class sumsubar {
    /*
    take all sum of subarrays in increasing order than compute sum from left to right.
     */
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int sums[]=new int[10];
        int num=4;
        int left=1,right=5,k=0;
        for(int i=0;i<arr.length;i++)
        {
            int s=0;
            for(int j=i;j<arr.length;j++)
            {
                s+=arr[j];
                sums[k++]=s;
            }
        }
        Arrays.sort(sums);
        left--;right--;
        int ans=0;
        for(int i=left;i<=right;i++ )
        {
            ans+=sums[i];
        }
        System.out.println(ans);
    }
}
