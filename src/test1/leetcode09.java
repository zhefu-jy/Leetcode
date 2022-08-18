package test1;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode09 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);
       Object [] array = list.toArray();
        Arrays.sort(array);
        for (Object o : array) {
            System.out.println(o);
        }

    }
}
