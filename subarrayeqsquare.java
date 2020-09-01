import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class subarrayeqsquare {
    /*
        sum of subarray which is a square
        input: 30 30 9
        output: 1
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int s1=0,s2=0;
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            if(arr[i]<0)
            {
                s1-=arr[i];
            }
            else {
                s2+=arr[i];
            }
        }
        int ans=0;
        Map<Integer,Integer> s=new HashMap<Integer,Integer>();
        s.put(s1,1);
        int pref=0;
        for(int i=0;i<n;i++)
        {
            pref+=arr[i];
            for(int j=0;j*j<=s2;j++) {

                if(s1+(pref-j*j)>=0) {
                    if(s.containsKey(s1+(pref-j*j))) {
                        ans += s.get(s1+(pref-j*j));
                    }
                }
            }
            if(s.containsKey(pref+s1))
            {
                int a=s.get(pref+s1);
                s.put(pref+s1,a+1);
            }
            else
            {
                s.put(pref+s1,1);
            }
        }
        System.out.println(ans);
    }
}
