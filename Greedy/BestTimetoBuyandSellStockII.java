package LeetCode_idea.Greedy;

public class BestTimetoBuyandSellStockII {
    public static int maxProfit(int[] prices){
        if(prices == null || prices.length < 2) return 0;
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(arr1));

        int[] arr2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(arr2));
    }
}
