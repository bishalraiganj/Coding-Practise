public class GenerateSubsets {


	public static void main(String... args)
	{
		generateSubsets("ABC","",-1);
	}



	// ABC
	public static void generateSubsets(String s,String curr, int index ){

		if(index == s.length()-1){
			System.out.println(curr);
			return;
		}

		generateSubsets(s,curr,index+1);
		generateSubsets(s,curr+s.charAt(index+1),index+1);

	}

}
