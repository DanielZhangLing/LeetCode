package ContainerWithMostWater11;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0,right = height.length-1;
        int max = 0;
        while(left<right){
            max = Math.max(max, Math.min(height[left],height[right])*(right-left));
            if(height[right]>height[left])
                left++;
            else
                right--;
            
        }
        return max;
    }
}
