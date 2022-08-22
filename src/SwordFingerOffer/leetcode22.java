package SwordFingerOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 剑指 Offer II 035. 最小时间差
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * 示例 1：
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * 示例 2：
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 *
 */
public class leetcode22 {
    public static void main(String[] args) {
        List<String>  timePoints=new ArrayList<>(Arrays.asList("05:31","22:08","00:35"));
        System.out.println(findMinDifference(timePoints));
        System.out.println(findMinDifference2(timePoints));

    }
    public static int findMinDifference(List<String> timePoints) {
        int []times=new int[timePoints.size()+1];
        int h=0;
        int minutes=0;
        int res=Integer.MAX_VALUE;
        for (int i=0;i<timePoints.size();i++) {
            if(timePoints.get(i).equals("00:00")){
                times[i]=24*60;
                continue;
            }
            String hour = timePoints.get(i).substring(0, 2);
            String min =  timePoints.get(i).substring(3, 5);

            h=Integer.valueOf(hour);
            minutes=Integer.valueOf(min);
            times[i]=h*60+minutes;
        }
        //数组最后添加一个元素  用于判断最小值 与最大值之间差值  比如00:35  和23：59
        times[timePoints.size()]=Integer.MAX_VALUE;
        Arrays.sort(times);
        times[timePoints.size()]=times[0]+24*60;
        for (int i = 1; i < times.length ; i++) {
            res=Math.min(res,times[i]-times[i-1]);
        }
        return res;

    }

    public  static  int findMinDifference2(List<String> timePoints) {
        if (timePoints.size() > 24 * 60) {
            return 0;
        }
        List<Integer> mins = new ArrayList<>();
        for (String t : timePoints) {
            String[] time = t.split(":");
            mins.add(Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]));
        }
        Collections.sort(mins);
        mins.add(mins.get(0) + 24 * 60);
        int res = 24 * 60;
        for (int i = 1; i < mins.size(); ++i) {
            res = Math.min(res, mins.get(i) - mins.get(i - 1));
        }
        return res;
    }
}
