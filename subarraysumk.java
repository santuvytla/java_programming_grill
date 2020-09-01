import java.util.HashMap;
import java.util.Map;

public class subarraysumk {
    /*
    to have the consecutive subarray sum of 'k'.
    example input {1,1,1} and k=2 then output is 2.
     */
    public static void main(String[] args) {
        int pref=0;
        int arr[]={1,1,1};
        int n=arr.length;
        int req=0;
        int k=2;
        int ans=0;
        Map<Integer,Integer> s=new HashMap<Integer,Integer>();
        s.put(pref,1);
        for(int i=0;i<n;i++)
        {
            pref+=arr[i];
            req=pref-k;
            if(s.containsKey(req)) {
                ans += s.get(req);
            }
            if(s.containsKey(pref))
            {
                int a=s.get(pref);
                s.put(pref,a+1);
            }
            else
            {
             s.put(pref,1);
            }
        }
        System.out.println(ans);
    }
}
