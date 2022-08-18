package MoNi;

import java.util.HashMap;

public class leetcode03 {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("a","aaa");
        objectObjectHashMap.put("a","test");
        System.out.println(objectObjectHashMap.get("a"));
        int i = objectObjectHashMap.hashCode();
        Object o = new Object();
    }
}
