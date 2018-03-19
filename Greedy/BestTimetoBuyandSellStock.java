package LeetCode_idea.Greedy;

public class BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1) return 0;
        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else {
                int curProfit = prices[i] - minPrice;
                maxProfit = maxProfit < curProfit ? curProfit : maxProfit;
            }
        }

        return maxProfit;

    }

    public static void main(String[] args) {
        int[] arr1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr1)); //5

        int[] arr2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr2)); //0
    }
}
