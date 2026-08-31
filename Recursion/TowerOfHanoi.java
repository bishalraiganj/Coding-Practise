public class TowerOfHanoi {

	static int moveCount=0;

	public static void main(String... args) {


		System.out.println("-----TowerOfHanoi-----");

		toh(3,'A','B','C');
	}

	//in this recursive function a is source b is auxiliary and c is the destination for the first call :-)
	public static void toh(int n , char a, char b, char c)
	{


		if( n == 0 ) return;

		 toh(n-1,a,c,b);
		 moveCount++;
		 System.out.printf(" Disk %d moved from %c to %c  move no: %d \n",n,a,c,moveCount);
		 toh(n-1,b,a,c);

	}

	//This one's base case is more obvious because we are thinking in terms of the very first one at the top , whereas in my above
	//version i was thinking in terms of recursive calls depth wise and in the last one (recursive call )  n becomes 0 and should not print so simply returned when n ==0
	//  then in the second last call n becomes the first one that moves :-)
	public static void toh2(int n, char a, char b, char c)
	{
		if( n == 1 ){
			System.out.printf("%d'th moved from %c to %c \n",n,a,c);
			return;
		}

		toh2(n-1,a,c,b);
		System.out.printf("%d'th moved from %c  to %c \n",n,a,c);
		toh2(n-1,b,a,c);
	}


}
