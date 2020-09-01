package com.company;

public class trafficlig {

    public static String trafficJam(final String road, final String[] sides) {

        int X = road.indexOf("X"); // lets know the position of x to cut short

        StringBuilder sb  = new StringBuilder(road.substring(0,X+1)),
                tmp = null;

        for (int i=Math.min(sides.length,X)-1 ; i>=0 ; i--) {
            if (sides[i].isEmpty()) continue;

            tmp = new StringBuilder();
            int delta = 1;
            for (int j=sides[i].length()-1 ; j>=0 ; j--) {
                if (i+delta < sb.length()) {
                    tmp.append(sides[i].charAt(j));
                    tmp.append(sb.charAt(i+delta++));
                } else break;
            }
            sb = sb.replace(i+1, i+delta, tmp.toString());

        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String arr[]={"","","AB"};
        String road="abcdeX";
        String ss=trafficJam(road,arr);
        System.out.print(ss);
    }
}
