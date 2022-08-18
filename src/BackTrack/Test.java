package BackTrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Date: 2022/7/10 9:31
 * @Author: ZheFu
 *
 * 测试专用
 */
public class Test {
    public static void main(String[] args) {
        List<List<Integer>>  res=new ArrayList<>();
        Deque<Integer> path=new LinkedList<>();
        path.add(1);
        path.add(2);
        res.add(new ArrayList<>(path));
        path.removeLast();
        path.removeLast();
        path.add(1);
        path.add(2);
        System.out.println(res.contains(path));

    }
}
