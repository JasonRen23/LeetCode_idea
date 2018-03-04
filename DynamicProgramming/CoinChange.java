package LeetCode_idea.DynamicProgramming;

public class CoinChange {
    public static int coinChange_1(int[] coins, int amount){
        if(amount < 1) return 0;
        int[] dp = new int[amount + 1];
        int sum = 0;

        while (++sum <= amount){
            int min = -1;
            for(int coin : coins){
                if(sum >= coin && dp[sum - coin] != - 1){
                    int temp = dp[sum - coin] + 1;
                    min = min < 0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }


    public static int coinChange_2(int[] coins, int amount){
        if(amount < 1) return 0;
        int n = coins.length;
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];

        for(int j = 1; j <= amount; j++){
            dp[j] = max;
            if(j - coins[0] >= 0 && dp[j - coins[0]] != max){
                dp[j] = dp[j - coins[0]] + 1;
            }
        }

        int left;
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= amount; j++){
                left = max;
                if(j - coins[i] >= 0 && dp[j - coins[i]] != max){
                    left = dp[j - coins[i]] + 1;
                }
                dp[j] = Math.min(left, dp[j]);
            }
        }
        return dp[amount] != max ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        int coins1[] = {5, 2, 3};
        int coins2[] = {3, 5};
        int coins3[] = {1, 2, 5};

        System.out.println(coinChange_1(coins1, 20));
        System.out.println(coinChange_1(coins1, 0));
        System.out.println(coinChange_1(coins2, 2));
        System.out.println(coinChange_1(coins3, 11));

        System.out.println();

        System.out.println(coinChange_2(coins1, 20));
        System.out.println(coinChange_2(coins1, 0));
        System.out.println(coinChange_2(coins2, 2));
        System.out.println(coinChange_2(coins3, 11));    }
}
