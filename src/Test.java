import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
      /*  HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,3);
        map.put(2,5);
        map.put(3,6);
        map.put(6,6);
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).collect(Collectors.toList());
        System.out.println(collect);*/

      StringBuilder str=new StringBuilder();
      str.append("apple");
      str.append("phe");
      str.delete(str.length()-3,str.length());
    }
}
