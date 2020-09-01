package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class freedomtrailbfs {
    public static void main(String[] args) {
        //dfs+dp
        String ring="godding";
        String key="gd";
        int k=freedom(ring,key);
        System.out.print(k);
    }

    private static int freedom(String ring, String key) {
        Queue<Integer> list=new LinkedList<>();
        int sz=1;
        list.add(0);
        boolean chked[][]=new boolean[ring.length()][key.length()];
        int cnt=0;
        while(true){

            int sz0 = 0;

            for(int i=0; i<sz; i++){
                int n = list.poll();
                int r = n/1000;
                int k = n%1000;
                if(chked[r][k]) continue;
                chked[r][k]=true;
                if(ring.charAt(r)==key.charAt(k)){
                    if(k==key.length()-1) return cnt+1;
                    list.offer(r*1000+k+1); sz0++;
                }else{
                    list.offer((r+1)%ring.length()*1000+k); sz0++;
                    list.offer((r-1<0?ring.length()-1:r-1)*1000+k); sz0++;
                }
            }

            cnt++;
            sz = sz0;

        }
    }
}
