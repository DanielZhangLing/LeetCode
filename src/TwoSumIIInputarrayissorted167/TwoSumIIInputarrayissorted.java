package TwoSumIIInputarrayissorted167;

public class TwoSumIIInputarrayissorted {

	public int[] twoSum(int[] numbers, int target) {

		int[] output = new int[2];
		int left = 0;
		int right = numbers.length-1;
		while(left<right){
			int sum = numbers[left] +numbers[right];
			if(sum == target){
				output[0] = left + 1;
				output[1] = right + 1;
				break;
			}
			else if(sum>target){
				right--;
			}
			else{
				left++;
			}
		}
		return output;

	}

	public static void main(String[] args) {
		TwoSumIIInputarrayissorted test = new TwoSumIIInputarrayissorted();
		int[] data = {2,7,11,15};
		System.out.println(test.twoSum(data, 9));
	}
}
