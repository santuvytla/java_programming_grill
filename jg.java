import java.util.*;

public class jg {
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm)
    {
        List<Map.Entry<Integer, Integer> > list =
                new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getKey()).compareTo(o2.getKey());
            }
        });
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,Integer> s=new HashMap<>();
        for(int i=0;i<n;i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            s.put(a,b);
        }
        int end=0,count=0;
        HashMap<Integer,Integer> ss=sortByValue(s);
        for(Map.Entry<Integer,Integer> k:ss.entrySet())
        {
         if(k.getKey()>end){
             count++;
             end=k.getValue();
         }
        }
        System.out.println(count);


    }
}
