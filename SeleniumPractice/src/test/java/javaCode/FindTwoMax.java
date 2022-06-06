package javaCode;

public class FindTwoMax {
		public void GetTwoMaxValues(int nums[]) {

			int maxOne = Integer.MIN_VALUE;
			int maxTwo = Integer.MIN_VALUE;
			for (int n : nums) {
				if (maxOne < n) {
					maxTwo = maxOne;
					maxOne = n;
				} else if (maxTwo < n) {
					maxTwo = n;
				}

			}

			System.out.println("Max1 - " + maxOne);
			System.out.println("Max2 - " + maxTwo);
		}

		public static void main(String[] args) {

			int list[] = { 15, 24, 48, 21, 43, 11, 79, 93 };

			FindTwoMax max = new FindTwoMax();
			max.GetTwoMaxValues(list);
		}
	}
