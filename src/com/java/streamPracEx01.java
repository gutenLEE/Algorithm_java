import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class streamPracEx01{

    private static HashMap<Number, Number> SORT_MAP;
    public static void main(String[] args) {
        
        List<HashMap<String, Number>> cnList = new ArrayList<>();

        HashMap<String, Number> map = new HashMap<>();
        map.put("key", 123);
        map.put("rank", 1);
        HashMap<String, Number> map2 = new HashMap<>();
        map2.put("key", 456);
        map2.put("rank", 2);

        HashMap<String, Number> map3 = new HashMap<>();
        map3.put("key", 789);
        map3.put("rank", 3);


        cnList.add(map);
        cnList.add(map2);
        cnList.add(map3);

        SORT_MAP = cnList.parallelStream()
                        .collect(HashMap::new, (m, cn) -> m.put(cn.get("key"), cn.get("rank")), HashMap::putAll);

        System.out.println(SORT_MAP);
        
    }
}