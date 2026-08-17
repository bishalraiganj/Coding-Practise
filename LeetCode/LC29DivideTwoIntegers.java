public class LC29DivideTwoIntegers {

	public static void main(String... args)
	{
		divide(43,3);
	}

	public static void divide(int dividend, int divisor)
	{
		int quotient = 0;

		int shift =  Integer.numberOfLeadingZeros(divisor)
				- Integer.numberOfLeadingZeros(dividend);

		int shiftedValue = divisor << shift;

		while( shiftedValue > dividend)
		{
			shift--;
			shiftedValue  = divisor <<  shift;
		}


		System.out.println(shiftedValue);

		do{

			System.out.println("shifted value: "+ shiftedValue + " dividend: " + (dividend )+ " shift: " + shift );
			quotient +=  1 << shift;
			shift--;
			dividend -= shiftedValue;
			if(shift>=0)  shiftedValue = divisor << shift;

		}
		while ( (dividend) >= divisor  );


		System.out.println(quotient);
	}


}
