package SwordFingerOffer;

/**
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 */
public class leetcode03 {
    public static int res=0;
    public static void main(String[] args) {
        int m=3,n=1,k=0;
      System.out.println(movingCount(m, n, k));

    }
    public static int movingCount(int m, int n, int k) {
        int  [][]nums=new int[m][n];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums[0].length ; j++) {
                dfs(i,j,m,n,k,nums);
            }

        }
        return res;


    }

    private static void dfs(int i,int j,int m, int n, int k,int  [][]nums) {
        if(i<0 || i>=m || j<0 || j>=n ||  !canWalk(i,j,k) || nums[i][j]==-1){
            return;
        }
        res++;
        nums[i][j]=-1;
        dfs(i+1,j,m,n,k,nums);
        dfs(i-1,j,m,n,k,nums);
        dfs(i,j-1,m,n,k,nums);
        dfs(i,j+1,m,n,k,nums);


    }

    private static boolean canWalk(int i, int j,int k) {
        String s = String.valueOf(i);
        String s1 = String.valueOf(j);
        StringBuilder builder=new StringBuilder();
        builder.append(s);
        builder.append(s1);
        int res=0;
        String temp=builder.toString();
        for (int l = 0; l <temp.length() ; l++) {
            res+=temp.charAt(l)-'0';
            if(res>k){
                return false;
            }
        }
        return true;
    }
}
