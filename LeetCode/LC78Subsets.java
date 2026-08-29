import java.util.ArrayList;
import java.util.List;

public class LC78Subsets {




		public List<List<Integer>> subsets(int[] nums) {


			List<List<Integer>> list  = new ArrayList<>();
			generateSubsets(list, nums,new ArrayList<Integer>(),  -1);
			return list;


		}

		public static void generateSubsets(List<List<Integer>> list,int[] nums,List<Integer> curr , int index)
		{
			if(index == nums.length - 1)
			{
				list.add(curr);
				return;
			}


			List<Integer> newList = new ArrayList<>(curr);
			newList.add(nums[index + 1]);
			generateSubsets(list,nums,curr,index+1);
			generateSubsets(list,nums,newList,index+1);
		}
	}

