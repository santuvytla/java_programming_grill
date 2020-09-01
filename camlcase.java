package com.company;
import java.lang.StringBuilder;

public class camlcase {

        static String toCamelCase(String s){
            StringBuffer sb=new StringBuffer(s);
            int count=0;
            for(int i=0;i<sb.length();i++){
                if(Character.isAlphabetic(sb.charAt(i)))
                {
                    if(count>0)
                    {
                        Character.toUpperCase(sb.charAt(i));
                        count=0;
                    }
                    else{
                        continue;
                    }
                }
                else
                {
                    sb.deleteCharAt(i);
                    count++;
                }
            }
            String sc=sb.toString();
            return sc;
        }

    }

