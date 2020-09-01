import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class exam {
    /*
    A session has begun at Beland State University. Many students are taking exams.

Polygraph Poligrafovich is going to examine a group of n students. Students will take the exam one-by-one in order from 1-th to n-th. Rules of the exam are following:

The i-th student randomly chooses a ticket.
if this ticket is too hard to the student, he doesn't answer and goes home immediately (this process is so fast that it's considered no time elapses). This student fails the exam.
if the student finds the ticket easy, he spends exactly ti minutes to pass the exam. After it, he immediately gets a mark and goes home.
Students take the exam in the fixed order, one-by-one, without any interruption. At any moment of time, Polygraph Poligrafovich takes the answer from one student.

The duration of the whole exam for all students is M minutes (maxti≤M), so students at the end of the list have a greater possibility to run out of time to pass the exam.

For each student i, you should count the minimum possible number of students who need to fail the exam so the i-th student has enough time to pass the exam.

For each student i, find the answer independently. That is, if when finding the answer for the student i1 some student j should leave, then while finding the answer for i2 (i2>i1) the student j student does not have to go home.

Input
The first line of the input contains two integers n and M (1≤n≤100, 1≤M≤100) — the number of students and the total duration of the exam in minutes, respectively.

The second line of the input contains n integers ti (1≤ti≤100) — time in minutes that i-th student spends to answer to a ticket.

It's guaranteed that all values of ti are not greater than M.

Output
Print n numbers: the i-th number must be equal to the minimum number of students who have to leave the exam in order to i-th student has enough time to pass the exam.

Examples
inputCopy
7 15
1 2 3 4 5 6 7
outputCopy
0 0 0 0 0 2 3
inputCopy
5 100
80 40 40 40 60
outputCopy
0 1 1 2 3
Note
The explanation for the example 1.

Please note that the sum of the first five exam times does not exceed M=15 (the sum is 1+2+3+4+5=15). Thus, the first five students can pass the exam even if all the students before them also pass the exam. In other words, the first five numbers in the answer are 0.

In order for the 6-th student to pass the exam, it is necessary that at least 2 students must fail it before (for example, the 3-rd and 4-th, then the 6-th will finish its exam in 1+2+5+6=14 minutes, which does not exceed M).

In order for the 7-th student to pass the exam, it is necessary that at least 3 students must fail it before (for example, the 2-nd, 5-th and 6-th, then the 7-th will finish its exam in 1+3+4+7=15 minutes, which does not exceed M).


     */
    public static void main(String[] args) {
        PriorityQueue<Integer > pq = new PriorityQueue<Integer >(10, Collections.reverseOrder());
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int s=0,ans=0;
        int t[]=new int[n];
        for(int i=0;i<n;i++)
        {
            t[i]=sc.nextInt();
            while(s+t[i]>m)
            {
                s-=pq.poll();
                ++ans;
            }
            System.out.print(ans+" ");
            pq.add(t[i]);
            s+=t[i];
        }
    }
}
