package com.company;

public class waterbottle {
    /*
    Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.

The operation of drinking a full water bottle turns it into an empty bottle.

Return the maximum number of water bottles you can drink.
Input: numBottles = 9, numExchange = 3
Output: 13
Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 9 + 3 + 1 = 13.
     */
    public static void main(String[] args) {
        /*
        int b=15; int e=3;
            int res = b;  // drink all available
            while (b >= e) {
                int add = b / e;  // exchanged with empty bottles
                b %= e;
                b += add;  // current empty bottles
                res += add;
            }
            System.out.println(res);
        }

         */
        int numBottles = 15;
        int numExchange = 3;
        int initial = numBottles;
        while (numBottles >= numExchange) {

            initial += (numBottles / numExchange);
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);

        }
        System.out.println(initial);
    }
}

