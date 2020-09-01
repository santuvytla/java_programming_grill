package com.company;

import java.util.*;

public class railroad {


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        long[] p = new long[n];
        long[] res = new long[n+1];
        Arrays.fill(res, Long.MAX_VALUE);
        for(int i=0; i<n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        int pow = 1;
        for(int i=0; i<n; i++) {
            pow *= 3;
        }

        long[][] xmin = new long[n][1<<n];
        long[][] ymin = new long[n][1<<n];

        for(int i=0; i<(1<<n); i++) {
            for(int j=0; j<n; j++) {
                xmin[j][i] = Math.abs(x[j]) * p[j];
                ymin[j][i] = Math.abs(y[j]) * p[j];
                for(int k=0; k<n; k++) {
                    if((i>>k)%2==1) {
                        xmin[j][i] = Math.min(xmin[j][i], Math.abs(x[j]-x[k])*p[j]);
                        ymin[j][i] = Math.min(ymin[j][i], Math.abs(y[j]-y[k])*p[j]);
                    }
                }
            }
        }

        for(int i=0; i<pow; i++) {
            long sum = 0;
            int[] nums = new int[n];
            int ii = i;
            int xi = 0;
            int yi = 0;
            int bits = 0;
            for(int j=0; j<n; j++) {
                int num = ii%3;
                if(num == 1) {
                    xi += (1<<j);
                    bits++;
                } else if (num == 2) {
                    yi += (1<<j);
                    bits++;
                }
                ii/=3;
            }
            for(int j=0; j<n; j++) {
                sum += Math.min(xmin[j][xi], ymin[j][yi]);
            }
            res[bits] = Math.min(res[bits], sum );
        }

        for(int i=0; i<=n; i++) {
            System.out.println(res[i]);
        }


    }
}