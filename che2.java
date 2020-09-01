package com.company;

    import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

    public class che2 {


            public static int farthestprime(int num)
            {
                boolean[] flag = new boolean[251];
                for (int i = 2; i <= num; ++i)
                {
                    if (num % i == 0)
                    {
                        flag[i] = true;
                        for (int j = 2; j * i <= 250; ++j)
                        {
                            flag[i * j] = true;
                        }
                    }
                }
                int front = 2;
                while(front<=250&&flag[front]==true){
                    front++;
                }
                int back=250;
                while(back>=0&&flag[back]==true){
                    back--;
                }
                return (num-front)>(back-num)?front:back;
            }

        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.print("arr:");
            int arr[]=new int[3];
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }

            for(int i=0;i<arr.length;i++) {


                int num = farthestprime(arr[i]);
                System.out.print(num+" ");
            }
        }



        }

