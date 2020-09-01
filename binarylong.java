package com.company;

public class binarylong {
    public static void main(String[] args) {
        String a="babababsbaabd";
        String ans=longpalin(a);
        System.out.print(ans);
    }

    private static String longpalin(String a) {
        int best_len=0;
        String best="";
        int n=a.length();
        int arr[]={0,1};
        for(int parity:arr)
        {
            //let string be abba
            int low=1,high=n;
            if(low%2!=parity)low++; //low=2
            if(high%2!=parity)high--; //high=4
            while(low<=high)
            {
                int mid=(low+high)/2; //mid=3
                if(mid%2!=parity) //no mid is still 3
                {
                    mid++;
                }
                if(mid>high)
                {
                    break;
                }
                int temp=good(mid,a);
                if(temp!=-1)
                {
                    if(mid>best_len)
                    {
                        best_len=mid;
                        best=a.substring(temp,mid);
                    }
                    low=mid+2;
                }
                else
                {
                    high=mid-2;
                }

            }
        }
        return best;
    }

    private static int good(int mid,String a) {
        for(int l=0;l+mid<=a.length();l++)
        {
            if(is_palin(a.substring(l,mid)))
            {
                return l;
            }

        }
        return -1;
    }

    private static boolean is_palin(String substring) {
        StringBuilder s=new StringBuilder();
        s.append(substring);
        String p=s.reverse().toString();
        return substring.contentEquals(p);
    }

}
