package LeetCode_idea.DynamicProgramming;

public class PalindromePartitioningII {
    /*

    首先设置dp变量 cuts[len+1]。cuts[i]表示从第i位置到第len位置（包含，即[i, len])的切割数（第len位置为空）。

    初始时，是len-i。比如给的例子aab，cuts[0]=3，就是最坏情况每一个字符都得切割：a|a|b|' '。cuts[1] = 2, 即从i=1位置开始，a|b|' '。

    cuts[2] = 1 b|' '。cuts[3]=0,即第len位置，为空字符，不需要切割。



    上面的这个cuts数组是用来帮助算最小cuts的。



    还需要一个dp二维数组matrixs[i][j]表示字符串[i,j]从第i个位置（包含）到第j个位置（包含） 是否是回文。

    如何判断字符串[i,j]是不是回文？

            1. matrixs[i+1][j-1]是回文且 s.charAt(i) == s.charAt(j)。

            2. i==j（i，j是用一个字符）

            3. j=i+1（i，j相邻）且s.charAt(i) == s.charAt(j)



    当字符串[i,j]是回文后，说明从第i个位置到字符串第len位置的最小cut数可以被更新了，

    那么就是从j+1位置开始到第len位置的最小cut数加上[i,j]|[j+1,len - 1]中间的这一cut。

    即，Math.min(cuts[i], cuts[j+1]+1)

    最后返回cuts[0]-1。把多余加的那个对于第len位置的切割去掉，即为最终结果。*/


    public static int minCut(String s){
        if(s == null || s.length() == 0) return 0;

        final int n = s.length();
        int[] cuts = new int[n + 1];
//        f[n] = Integer.MIN_VALUE;
        boolean[][] p = new boolean[n][n];

        for (int i = 0; i < n; ++i){
            cuts[i] = n - i - 1;  //cut nums from i to len [i,len]
        }

        for(int i = n - 1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j)
                        && (j - i < 2 || p[i + 1][j - 1])){
                    p[i][j] = true;
                    cuts[i] = Math.min(cuts[i], cuts[j + 1] + 1);
                }
            }
        }
        return cuts[0];
    }

    public static void main(String[] args) {
        String s1 = "aab";
        System.out.println(minCut(s1));

        String s2 = "ababc";
        System.out.println(minCut(s2));

        String s3 = "bb";
        System.out.println(minCut(s3));
    }
}
