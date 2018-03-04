package LeetCode_idea.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingOffers {
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        return helper(price, special, needs, 0);
    }
    private static int helper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int pos){
        int local_min = directPurchase(price, needs);
        for(int i = pos; i < special.size(); i++){
            List<Integer> offer = special.get(i);
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < needs.size(); j++){
                if(needs.get(j) < offer.get(j)){
                    temp = null;
                    break;
                }
                temp.add(needs.get(j) - offer.get(j));
            }

            if(temp != null){
                local_min = Math.min(local_min, offer.get(offer.size() - 1) + helper(price, special, temp, i));
            }

        }
        return local_min;
    }

    private static int directPurchase(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += price.get(i) * needs.get(i);
        }

        return total;
    }
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();
        String[] priceInput = line.split(",");
        for(int i = 0; i < priceInput.length; ++i){
            price.add(Integer.parseInt(priceInput[i]));
        }


        List<List<Integer>> special = new ArrayList<>();
        for(int i = 0; i < 2; ++i){
            line = in.nextLine();
            String[] specialInput = line.split(",");
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < specialInput.length; j++){
                list.add(Integer.parseInt(specialInput[j]));
            }
            special.add(list);
        }

        List<Integer> needs = new ArrayList<>();
        line = in.nextLine();
        String[] needsInput = line.split(",");
        for(int i =0; i < needsInput.length; ++i){
            needs.add(Integer.parseInt(needsInput[i]));
        }

        System.out.println(shoppingOffers(price, special, needs));
    }
}
