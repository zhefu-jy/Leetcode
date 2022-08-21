package SwordFingerOffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class leetcode14 {
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple",3);
        mapSum.insert("app",2);
        System.out.println(mapSum.sum("ap"));

    }
}

class MapSum {
    private Map map;

    /** Initialize your data structure here. */
    public MapSum() {
       this.map=new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key,val);
    }

    public int sum(String prefix) {
        Set keySet = map.keySet();
        int len=prefix.length();
        int res=0;
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            String  next = (String) iterator.next();
            if(next.length()<prefix.length()){
                continue;
            }
            String substring = next.substring(0, len);
            if(substring.equals(prefix)) {
                res = res + (int) map.get(next);
            }
        }
        return  res;
    }
}
