package Daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode04 {
    public static void main(String[] args) {
        int []target=new int[]{3,7,9};
        int []arr=new int[]{3,7,11};
        System.out.println(canBeEqual(target, arr));

    }
    public static boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i : target) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i : arr) {
            Integer value = map.get(i);
            if(value==null){
                continue;
            }
            value=value-1;
            map.put(i,value);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if(value!=0){
                return false;
            }
        }
        return true;
    }
}
