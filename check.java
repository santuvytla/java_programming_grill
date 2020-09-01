public class check {

    public static void main(String[] args) {
        int arr[]={1,2,3};
        int sum=add(arr);
        System.out.println(sum);
    }

    private static int add(int[] arr) {
        int sum=0;
        if(arr.length>0)
        {
            for(int i=0;i<arr.length;i++)
            {
                sum+=arr[i];
                return sum;

            }
            return sum;
        }
        return -1;
    }
}
