package LeetCode_idea.Arrays;

public class Candy {
    public static int candy(int[] ratings){
        final int N = ratings.length;
        final int[] arrays = new int[N];
        int i, sum;

        for(i = 1; i < N; ++i){
            if(ratings[i] > ratings[i - 1])
                arrays[i] = arrays[i - 1] + 1;
        }


        for(i = N - 2; i >= 0; --i){
            if(ratings[i] > ratings[i + 1] && arrays[i] <= arrays[i + 1])
                arrays[i] = arrays[i + 1] + 1;

        }

        sum = N;

        for(int array : arrays){
            sum += array;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] ratings1 = {0, 1, 3, 2, 4, 0};
        System.out.println("The number of candy is " + candy(ratings1));

        int[] ratings2 = {12, 4, 3, 11, 34, 34, 1, 67};
        System.out.println("The number of candy is " + candy(ratings2));
    }
}
