package LeetCode_idea.Arrays;

public class TrappingRainWater {
    //dynamic programming
    public static int trap(int[] height){
        if(height == null || height.length < 3) return 0;
        int ans = 0;
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = height[0];
        for(int i = 1; i < len; ++i){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[len - 1] = height[len - 1];
        for(int j = len - 2; j >= 0; --j){
            rightMax[j] = Math.max(height[j], rightMax[j + 1]);
        }
        for(int k = 1; k < len - 1; ++k){
            ans += Math.min(leftMax[k], rightMax[k]) - height[k];
        }
        return ans;
    }

    //two pointers
    public static int trap_2(int[] height){
        if(height == null || height.length < 3) return 0;
        int len = height.length;
        int left = 0, right = len - 1;
        int maxleft = 0, maxright = 0, ans = 0;

        while(left < right){
            if(height[left] < height[right]){
                maxleft = Math.max(maxleft, height[left]);
                ans += maxleft - height[left];
                left++;
            }else{
                maxright = Math.max(maxright, height[right]);
                ans += maxright - height[right];
                right--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The ret is " + trap(height1));
        System.out.println("The ret is " + trap_2(height1));
    }
}
