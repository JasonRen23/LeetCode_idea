package LeetCode_idea.Arrays;

public class ClimbingStairs {
    // brute force
    public static int climbingStairs(int n){
        if(n == 0) return 1;
        if(n == 1) return 1;
        return climbingStairs(n - 1) + climbingStairs(n - 2);
    }

    //dp
    public static int climbingStairs_2(int n){
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; ++i){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //fibonacci
    public static int climbingStairs_3(int n){
        if(n < 3) return n;
        int first = 1;
        int second = 2;
        for(int i = 3; i <= n; ++i){
            int third = first + second;
            first = second;
            second = third;
        }
        return second;

    }



    public static void main(String[] args) {
        System.out.println("The num of ways is " + climbingStairs(6));
        System.out.println("The num of ways is " + climbingStairs_2(6));
        System.out.println("The num of ways is " + climbingStairs_3(6));
    }
}
