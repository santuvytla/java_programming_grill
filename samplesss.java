package com.company;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class samplesss
{



    public static void main(String[] args)
    {

        String regex = ".@.";

        samplesss.compare("Hacker@Earth.com", regex);
        samplesss.compare("a@N", regex);
        samplesss.compare("Java@Program", regex);

    }

    public static void compare(String str, String regex)
    {
        if (str.matches(regex))
        {
            System.out.println(str + " matches");
        }
        else
        {
            System.out.println(str + " does not match");
        }
    }

}