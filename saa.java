import java.util.*;
import java.util.function.BinaryOperator;

public class saa {
    public static HashMap<Integer, Boolean> sortByValue(HashMap<Integer, Boolean> hm)
    {
        List<Map.Entry<Integer, Boolean> > list =
                new LinkedList<Map.Entry<Integer, Boolean> >(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Boolean> >() {
            public int compare(Map.Entry<Integer, Boolean> o1,
                               Map.Entry<Integer, Boolean> o2)
            {
                return (o1.getKey()).compareTo(o2.getKey());
            }
        });
        HashMap<Integer, Boolean> temp = new LinkedHashMap<Integer, Boolean>();
        for (Map.Entry<Integer, Boolean> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Boolean> s = new HashMap<>();
        for (int i = 0; i < n; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            s.put(a, true);
            s.put(b,false);

        }
        HashMap<Integer,Boolean> ss=sortByValue(s);
        int max_people = 0, curr_people = 0;
        for(Map.Entry<Integer,Boolean> k:s.entrySet())
        {
            System.out.println(k.getKey()+" "+k.getValue());
            curr_people += k.getValue() ? 1 : -1;
          //  System.out.println(curr_people);

            max_people = Math.max(max_people, curr_people);
        }
        System.out.println(max_people);

    }
}
