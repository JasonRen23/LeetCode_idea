package LeetCode_idea.Greedy;

public class CouplesHoldingHands {
    public static int miniSwapArray(int[] row){
        int res = 0, N = row.length;

        for(int i = 0; i < N; i++){
            for(int j = row[i]; i != j; j = row[i]){
                swap(row, i, j);
                res++;
            }
        }

        return res;
    }



    public static int minSwapCouples(int[] row){
        int res = 0, N = row.length;
        int[] ptn = new int[N];
        int[] pos = new int[N];

        for(int i = 0; i < N; i++){
            ptn[i] = (i % 2 == 0 ? i + 1 : i - 1);
            pos[row[i]] = i;
        }

        for(int i = 0; i < N; i++){
            for(int j = ptn[pos[ptn[row[i]]]]; i != j; j = ptn[pos[ptn[row[i]]]]){
                swap(row, i, j);
                swap(pos, row[i], row[j]);
                res++;
            }
        }

        return res;
    }

    private static void swap(int[] arr, int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int arr1[] = {2, 3, 1, 0, 5, 4};
        System.out.println(miniSwapArray(arr1));


        int[] row1 = {0, 2, 1, 3};
        System.out.println(minSwapCouples(row1));//1
        int[] row2 = {3, 2, 0, 1};
        System.out.println(minSwapCouples(row2));//0
    }
}
