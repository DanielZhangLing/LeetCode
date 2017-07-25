package DataStreamMedian;

import java.util.Comparator;
import java.util.PriorityQueue;

class NewComparator implements Comparator<Integer> {
	public int compare(Integer a, Integer b) {
		return b - a;
	}
}

public class DataStreamMedian {
	PriorityQueue<Integer> maxHeap, minHeap;
	int numOfElements = 0;

	/**
	 * @param nums:
	 *            A list of integers.
	 * @return: the median of numbers
	 */
	public int[] medianII(int[] nums) {
		// Comparator<Integer> revCmp = new Comparator<Integer>() {
		// @Override
		// public int compare(Integer left, Integer right) {
		// return right.compareTo(left);
		// }
		// };

		// write your code here
		int len = nums.length;
		int res[] = new int[len];
		maxHeap = new PriorityQueue<Integer>(len, new NewComparator());
		minHeap = new PriorityQueue<Integer>(len);
		for (int i = 0; i < len; ++i) {
			addNum(nums[i]);
			res[i] = getMedian();
		}
		return res;
	}

	public void addNum(int num) {
		maxHeap.offer(num);
		if (numOfElements % 2 == 0) {
			if (minHeap.isEmpty()) {
				numOfElements++;
				return;
			} else if (maxHeap.peek() > minHeap.peek()) {
				int temp1 = maxHeap.poll();
				int temp2 = minHeap.poll();
				minHeap.offer(temp1);
				maxHeap.offer(temp2);
			}
		} else {
			minHeap.offer(maxHeap.poll());
		}
		numOfElements++;

	}

	public int getMedian() {
		return maxHeap.peek();
	}
}