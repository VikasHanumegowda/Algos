/**
 * Created by sridharyadav on 12/22/15.
 */
import java.util.*;
public class occur {
    public static void main(String[] args) {

        String[] array = {"he","he","fu","fu","me","la","da","ka","ka","ka","ka"};
        //create the map like this: <Element,Count>
        Map<String, Integer> unsortMap = new HashMap<>();

        for (String i : array) {
            if (unsortMap.get(i) == null) {
                unsortMap.put(i, 1);
            } else {
                unsortMap.put(i, unsortMap.get(i) + 1);
            }
        }

        System.out.println("Before sorting......");
        printMap(unsortMap);

        System.out.println("After sorting ascending order......");
        Map<String, Integer> sortedMapAsc = sortByComparator(unsortMap, true);
        printMap(sortedMapAsc);


        System.out.println("After sorting descindeng order......");
        Map<String, Integer> sortedMapDesc = sortByComparator(unsortMap, false);
        printMap(sortedMapDesc);

    }

    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void printMap(Map<String, Integer> map)
    {
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }
}