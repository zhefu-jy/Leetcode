package test1;

/**
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 *
 * 输入为三个整数：day、month 和year，分别表示日、月、年。
 *
 * 您返回的结果必须是这几个值中的一个{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/day-of-the-week
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class leecode03 {
    public static void main(String[] args) {

        int day=1;
        int month=1;
        int year=1972;
        int days=0;
        String []seven=new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (int j = 1971; j <year ; j++) {
            for (int i = 1; i <=12; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                    days += 31;
                } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                    days += 30;
                } else if (i == 2 && isLeapYear(j)) {
                    days += 29;
                } else {
                    days += 28;
                }

            }
        }
            for (int i = 1; i <month; i++) {
                if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                    days += 31;
                } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                    days += 30;
                } else if (i == 2 && isLeapYear(year)) {
                    days += 29;
                } else {
                    days += 28;
                }
        }
            days+=day;
             days--;
        System.out.println(days);
           days%=7;

        System.out.println(seven[(5+days)%7]);

    }
    public static boolean isLeapYear(int year){
        if(year%4==0&&year%100!=0||year%400==0){
            return true;
        }else{
            return false;
        }
    }
}
