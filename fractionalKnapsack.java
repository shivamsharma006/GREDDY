import java.util.Arrays;
import java.util.Comparator;

public class fractionalKnapsack {

    private static double findMaxProfit(ItemValue[]arr,int capacity){
        Arrays.sort(arr, new Comparator<ItemValue>(){
            @Override
            public int compare(ItemValue item1,ItemValue item2){
                double cmp1 = Double.valueOf(item1.profit/item1.weight);
                double cmp2 = Double.valueOf(item2.profit/item2.weight);

                if(cmp1<cmp2){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });

        double totalValue =0;
        for(ItemValue i : arr){
            int currWt = (int)i.weight;
            int curProfit = (int)i.profit;

            if(capacity-currWt>=0){
                capacity = capacity - currWt;
                totalValue = totalValue + curProfit;
            }
            else{
                double fraction = ((double) capacity/(double)currWt);
                totalValue += curProfit * fraction;
                capacity = (int)(capacity - (currWt * fraction));
                break;
            }
        }
        return totalValue;
    }

    static class ItemValue{
        int weight;
        int profit;

        public ItemValue(int profit,int wt){
            this.profit = profit;
            this.weight = wt;
        }
    }
    
    public static void main(String[] args) {
        ItemValue[] arr = { new ItemValue(25, 5),
            new ItemValue(75, 10),
            new ItemValue(100, 12),
            new ItemValue(50, 4),
            new ItemValue(45, 7),
            new ItemValue(90, 9),
            new ItemValue(30, 3)
        };

        int capacity =37;
        double maxProfit  = findMaxProfit(arr,capacity);
        System.out.println("THE MAX PROFIT IS : " + maxProfit);
    }
}
