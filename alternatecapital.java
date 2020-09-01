import java.util.Scanner;

public class alternatecapital {
    /*
    Given a string, capitalize the letters that occupy even indexes and odd indexes separately, and return as shown below. Index 0 will be considered even.

For example, capitalize("abcdef") = ['AbCdEf', 'aBcDeF']. See test cases for more examples.

The input will be a lowercase string with no spaces.
     */
    public static void main(String[] args) {
        Scanner  sc=new Scanner(System.in);
        String s=sc.nextLine();
        String u = s.toUpperCase();
        String o = "";
        String t = "";
        for(int i=0;i<s.length();i++){
            if(i%2==0){
                o += u.charAt(i);
                t += s.charAt(i);
            }else{
                o += s.charAt(i);
                t += u.charAt(i);
            }
        }
        System.out.println(o+" "+t);
    }
}
