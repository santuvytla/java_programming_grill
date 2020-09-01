package com.company;

public class shortest {
    public static void main(String[] args) {
        String s="aacecaaa";
        String ans=shortestPalindrome(s);
        System.out.println(ans);
    }
    public static String shortestPalindrome(String s) {
        if(s == null || s.length() < 2)
            return s;
        else{
            char[] characters = s.toCharArray();
            int N = characters.length;
            int maxIndex = 0;
            int i;
            for(i = N - 1; i >= 0; i--){
                if(characters[i] == characters[0]){
                    if(isPalindrome(characters, 0, i)){
                        maxIndex = i;
                        break;
                    }
                }
            }

            String result = s;
            for(i = maxIndex + 1; i < N; i++){
                result = characters[i] + result;
            }

            return result;
        }
    }

    private static boolean isPalindrome(char[] characters, int start, int end){
        if(start == end)
            return true;
        else{
            int first = start, last = end;
            while(first < last){
                if(characters[first] != characters[last])
                    return false;
                else{
                    ++first;
                    --last;
                }
            }

            return true;
        }
    }
}
