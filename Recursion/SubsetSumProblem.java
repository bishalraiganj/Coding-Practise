public class SubsetSumProblem {

	public static void main(String... args)
	{

		int[] arr = {10,5,2,3,6};
		System.out.println(ss(arr,8,-1,8));

		System.out.println(ss2(arr,5,8));
	}


	// {10,5,2,3,6}
	public static int ss(int[] nums, int  sum, int index,int target) {
		if (index == nums.length - 1) {
			if (sum == 0) return 1;
			if (sum > target) return 0;
			return 0;
		}

		return ss(nums,sum,index+1,target) + ss(nums,sum-nums[index+1],index+1,target);
	}

	public static int ss2(int[] nums,int n, int sum)
	{
		if(n == 0) {
			return sum==0?1:0;
		}

		return ss2(nums,n-1,sum) + ss2(nums,n-1,sum-nums[n-1]);
	}
}
