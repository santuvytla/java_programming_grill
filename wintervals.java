import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class wintervals {
    /*
   queens that attack the king
   Input: queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
Output: [[0,1],[1,0],[3,3]]
     */
    public static void main(String[] args) {
        Vector<Integer> queens[]=new Vector[2];
        Vector<Integer> kings[]=new Vector[2];
        for(int i=0;i<2;i++)
        {
            queens[i]=new Vector<>();
            kings[i]=new Vector<>();
        }
            queens[0].add(0,0);
            queens[1].add(0,1);
            queens[0].add(1,1);
            queens[1].add(1,0);
            queens[0].add(2,4);
            queens[1].add(2,0);
            queens[0].add(3,0);
            queens[1].add(3,4);
            queens[0].add(4,3);
            queens[1].add(4,3);
            queens[0].add(5,2);
             queens[1].add(5,4);
             kings[0].add(0,0);
             kings[1].add(0,0);
             boolean taken[][]=new boolean[8][8];
             for(Vector<Integer> ar :queens)
             {
                 taken[ar.get(0)][ar.get(1)]=true;
             }
             Map<Integer,Integer> ans=new HashMap<>();
             for(int d1=-1;d1<=1;d1++) //in rows
             {
                 for(int d2=-1;d2<=1;d2++) //in columns
                 {
                     if(d1==0&&d2==0)
                     {
                         continue;
                     }
                     int row=kings[0].get(0);
                     int col=kings[1].get(0);
                     do{
                         row+=d1;
                         col+=d2;
                     }while(inside(row,col)&&!taken[row][col]);
                    if(inside(row,col))
                    {
                        ans.put(row,col);
                    }
                 }
             }
             for(Map.Entry<Integer,Integer> ss:ans.entrySet())
             {
                 System.out.print("{"+ss.getKey()+","+ss.getValue()+"}");
             }

    }
// is it inside the chess board
    private static boolean inside(int row, int col) {
        return 0<=row && row<8 && 0<=col && col<8;
    }
}
