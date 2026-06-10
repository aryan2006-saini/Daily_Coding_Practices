public class StockBuyAndSell {
    static int maxProfit(int[] arr){
        int n = arr.length;
        int mini = arr[0];
        int profit = Integer.MIN_VALUE;
        for (int i=1;i<n;i++){
            int cost = arr[i]-mini;    // check the profit
            profit = Math.max(profit,cost); // Update the profit
            mini = Math.min(mini,arr[i]);  // Update the mini element
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
