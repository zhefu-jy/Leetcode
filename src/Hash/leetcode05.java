package Hash;

import java.util.HashMap;
import java.util.Map;
/**
 * @Date: 2022/6/15 21:47
 * @Author: ZheFu
 * 两数之和
 *
 */
public class leetcode05 {
    public static void main(String[] args) {
        int []nums={3,2,4};
        int target=6;
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            System.out.println(res);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                res[1] = i;
                res[0] = map.get(temp);
                System.out.println(res[0]+"--"+res[1]);
                return;
            }
            map.put(nums[i], i);
        }
    }
}
