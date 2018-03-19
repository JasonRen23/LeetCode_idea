package LeetCode_idea.DynamicProgramming;

public class BestTimetoBuyandSellStockIII {
    public static int maxProfit_1(int[] prices){
        if(prices == null || prices.length < 2) return 0;

        final int n = prices.length;
        int[] f = new int[n];
        int[] g = new int[n];

        for(int i = 1, valley = prices[0]; i < n; i++){
            valley = Math.min(valley, prices[i]);
            f[i] = Math.max(f[i - 1], prices[i] - valley);
        }

        for(int i = n - 2, peak = prices[n - 1]; i >= 0; i--){
            peak = Math.max(peak, prices[i]);
            g[i] = Math.max(g[i + 1], peak - prices[i]);
        }

        int maxProfit = 0;
        for(int i = 0; i < n; i++){
            maxProfit = Math.max(maxProfit, f[i] + g[i]);
        }

        return maxProfit;

    }

    public static int maxProfit_2(int[] prices){
        int afterFirstSell = 0, afterSecondSell = 0;
        int firstBuy = Integer.MIN_VALUE, afterSecondBuy = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            firstBuy = Math.max(firstBuy, -prices[i]);  //for first buy price ,the lower,the better
            afterFirstSell = Math.max(afterFirstSell, firstBuy+prices[i]);// the profit after first sell ,the higher,the better
            afterSecondBuy = Math.max(afterSecondBuy, afterFirstSell - prices[i]);//the profit left after second buy,the higher,the better
            afterSecondSell = Math.max(afterSecondSell,afterSecondBuy + prices[i]);// the profit left after second sell ,the higher,the better
        }
        return afterSecondSell;// afterSecondSell will be the max profit ultimately
    }

    //Expand to k transactions
    public static int maxProfit(int[] prices, int k){
        final int len = prices.length;
        if(len < 2) return 0;

        int[][] local = new int[len][k + 1]; // local[i][j]: max profit till i day, j transactions, where there is transaction happening on i day
        int[][] global = new int[len][k + 1];// global[i][j]: max profit across i days, j transactions

        for(int i = 1; i < len; i++){
            int diff = prices[i] - prices[i - 1];
            for(int j = 1; j <=k; j++){
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[len - 1][k];
    }


    public static void main(String[] args) {
        int[] arr1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit_1(arr1)); //7

        int[] arr2 = {2,1,2,0,1};
        System.out.println(maxProfit_1(arr2)); //2
        System.out.println(maxProfit_2(arr2)); //2
        System.out.println(maxProfit(arr2, 2));
    }
}
