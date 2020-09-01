package com.company;

import java.util.Stack;

public class sounthnorth {


    public static String[] dirReduc(String[] arr) {
        final Stack<String> stack = new Stack<>();

        for (final String direction : arr) {
            final String lastElement = stack.size() > 0 ? stack.lastElement() : null;

            switch (direction) {
                case "NORTH":
                    if ("SOUTH".equals(lastElement)) {
                        stack.pop();
                    } else {
                        stack.push(direction);
                    }
                    break;
                case "SOUTH":
                    if ("NORTH".equals(lastElement)) {
                        stack.pop();
                    } else {
                        stack.push(direction);
                    }
                    break;
                case "EAST":
                    if ("WEST".equals(lastElement)) {
                        stack.pop();
                    } else {
                        stack.push(direction);
                    }
                    break;
                case "WEST":
                    if ("EAST".equals(lastElement)) {
                        stack.pop();
                    } else {
                        stack.push(direction);
                    }
                    break;
            }
        }
        return stack.stream().toArray(String[]::new);
    }


    public static void main(String[] args) {
        String arr[] = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
        String arr1[] = dirReduc(arr);
        for(int i=0;i<arr1.length;i++)
        {
            System.out.print(arr1[i]);
        }

    }
}
