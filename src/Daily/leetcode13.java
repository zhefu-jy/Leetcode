package Daily;

/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 *
 * 示例 1 :
 *
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 *
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 */
public class leetcode13 {
    public static void main(String[] args) {
        int num=2736;
        System.out.println(maximumSwap(num));


    }
    public static int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int []index=new int[10];
        for (int i = 0; i < chars.length; i++) {
            index[chars[i]-'0']=i;
        }

        for (int i = 0; i < chars.length-1 ; i++) {
            for (int j = 9; j >=0 ; j--) {
                if(index[j]>i){
                    swap(chars,i,index[j]);
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;

    }


    private  static  void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}
