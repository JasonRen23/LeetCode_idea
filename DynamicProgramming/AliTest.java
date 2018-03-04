package LeetCode_idea.DynamicProgramming;

import java.util.*;

public class AliTest {
    public static void main(String[] args) {

        List<Integer> order = new ArrayList<Integer>();
        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        Integer n = Integer.parseInt(line.split(",")[0]);
        Integer m = Integer.parseInt(line.split(",")[1]);

        line = in.nextLine();
        String[] itemCnt = line.split(",");
        for(int i = 0; i < n ; i++){
            order.add(Integer.parseInt(itemCnt[i]));
        }

        for(int i = 0; i < m; i++){
            line = in.nextLine();
            String[] bomInput = line.split(",");
            List<Integer> bomDetail = new ArrayList<Integer>();

            for(int j = 1; j <= n; j++ ){
                bomDetail.add(Integer.parseInt(bomInput[j]));
            }
            boms.put(bomInput[0], bomDetail);
        }
        in.close();

        Map<String, Integer> res = resolve(order, boms);

        System.out.println("match result:");
        for(String key : res.keySet()){
            System.out.println(key+"*"+res.get(key));
        }
    }

    // write your code here
    public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {

        return helper(order, boms, 1);
    }

    private static Map<String, Integer> helper(List<Integer> order, Map<String, List<Integer>> boms, int pos){
        Map<String, Integer> map = new HashMap<>();
        for(int i = pos; i <= boms.size(); ++i){
            String s = "bom"+i;
            List<Integer> bom = boms.get(s);
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < order.size(); j++){
                if(order.get(j) < bom.get(j)){
                    temp = null;
                    break;
                }
                temp.add(order.get(j) - bom.get(j));
                map.put(s, map.getOrDefault(s,0) + 1);
            }

            if(temp != null){
                map = helper(order, boms, i);
            }
        }

        return map;
    }
}
