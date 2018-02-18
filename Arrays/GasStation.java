package LeetCode_idea.Arrays;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost){
        int tank = 0;
        int start = 0;
        int total = 0;
        for(int i = 0; i < gas.length; ++i){
            tank = tank + gas[i] - cost[i];
            if(tank < 0){
                start = i + 1;
                total = total + tank;
                tank = 0;
            }
        }
        return (total + tank < 0) ? -1 : start;
    }

    public static void main(String[] args) {
        int[] gas = {4, 6};
        int[] cost = {5, 5};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
