import java.util.Scanner;

public class encrypt {
    /*
    Encrypt this!

You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:

Your message is a string containing space separated words.
You need to encrypt each word in the message using the following rules:
The first letter needs to be converted to its ASCII code.
The second letter needs to be switched with the last letter
Keepin' it simple: There are no special characters in input.
encryptThis "Hello" == "72olle"
encryptThis "good" == "103doo"
encryptThis "hello world" == "104olle 119drlo"
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String text=sc.nextLine();
        StringBuilder enc = new StringBuilder();
        for (String word : text.split(" ")) {
            StringBuilder sb = new StringBuilder(word);
            int lastIdx = sb.length() - 1;
            if (lastIdx > 0) {
                char lastCh = sb.charAt(lastIdx);
                sb.setCharAt(lastIdx, sb.charAt(1));
                sb.setCharAt(1, lastCh);
            }
            enc.append(lastIdx < 0 ? "" : (byte)sb.charAt(0) + sb.substring(1)).append(" ");
        }
        String s= enc.toString().trim();
      //  String s=enc.toString().replaceFirst("\\s++$", ""); // trim tail only
        System.out.println(s);
    }
    }

