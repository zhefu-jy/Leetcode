package Hash;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class leetcode04 {
    public static void main(String[] args) {
        int []arr={2,6,4,2,8,9,11};
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            set.add(arr[i]);
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        int[] array1 = set.stream().mapToInt(Integer::intValue).toArray();
        for (int i : array) {
            System.out.printf(i+" ");
        }
        for (int i : array1) {
            System.out.printf(i+" ");
        }
    }
}
