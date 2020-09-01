import java.util.Scanner;

public class binarysarappli {

    public static int singleNonDuplicate(int[] a)
    {
        int low=0,high=a.length-1;
        int item=-1;
        while(low<=high)
        {
            int mid=(high+low)/2;
            // simply checking the overflow condition
            if(mid+1<a.length)
            {
                // checking if element next to mid is same or not
                if(a[mid]!=a[mid+1])
                {
                    // checking  if element before mid exists or not
                    if(mid-1>=0)
                    {
                        //Since element after and before the are not same the mid is answer itself
                    }
                    if(a[mid]!=a[mid-1]) return a[mid];
                    else
                    {
                        return a[mid];
                    }
                }
            }
            else{
                if(mid-1>=0)
                {
                    if(a[mid]!=a[mid-1]) return a[mid];
                }

            }
            // when mid position is odd therefore it should be follower
            if(mid%2==1)
            {
                // Since mid is follower and  if leader is found next to it  then the we change the value of
                //low to mid +1 as we go in  second half
                if(a[mid]==a[mid-1])
                {
                    low=mid+1;
                }
                // if leader is not found  next then we go for first half and change the
                //value of high for first half to mid-1
                else
                {
                    high=mid-1;
                }
            }
            // when position of mid is even therefore it should be a leader
            else
            {
                // Since  mid is a leader then then we check if it has a follower or not
                if(a[mid]==a[mid+1])
                {
                    low=mid+1;
                }
                // if follower does not exists
                else
                {
                    high=mid-1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        int ans=singleNonDuplicate(arr);
        System.out.println(ans);
    }
}
