import java.util.Scanner;

public class ssssa {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String ss=sc.nextLine();
        int c[]=new int[26];
        int c1 = 0;
        char cc[]=ss.toCharArray();
        char a=' ';

        String output="";
        for(char b:cc)
        {
            ++c[b-'A'];
        }
        for(int i=0;i<26;++i)
        {
            c1=c[i]&1;
        }
        if(c1>1)
        {
            System.out.println("NO POSSIBLE");
            System.exit(0);
        }
        else {
            for(int i=0;i<26;++i)
            {
             if(c[i]%2==0)
             {
                 int k=c[i]/2;
                 while(c[i]>k)
                 {
                     output+=(char)('A'+i);
                     c[i]--;
                 }

             }
             else{
                 a=(char)('A'+i);
             }
            }

            StringBuilder input1 = new StringBuilder();
            input1.append(output);
            StringBuilder sss=new StringBuilder();
            sss.append(input1);
            sss.reverse();
            input1.append(a);
          //  System.out.println(sss.toString());
        //    input1.append(a);
        //   System.out.println(input1.toString());
            String im=input1.toString();
            String ssa=sss.toString();
            String out=im.concat(ssa);
          System.out.println(out);
        }
    }
}
