import java.io.*;

import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
public class ParenSequence {


		public static int[] getMinOperations(String sequence)
		{
			// Write your code here

			char[] cArr = sequence.toCharArray();

			int[] countArr = new int[cArr.length];


			int oC = 0;
			int cC =0;

			if(sequence=="")
			{
				return null;
			}

			int index=0;

			for(int i = 0 ; i < cArr.length ; i++)
			{
				if(cArr[i]=='('&&cC==0)
				{
					oC++;
					if(i==cArr.length-1)
					{
						countArr[index++]=oC;
					}
				}
				else if(oC!=0 && cArr[i]==')' )
				{

					countArr[index++] = oC;
					oC = 0;
					cC++;
					if(i==cArr.length-1)
					{
						countArr[index++]=cC;
					}




				}


				else if(cArr[i]==')' && oC==0)
				{
					cC++;
					if(i==cArr.length-1)
					{
						countArr[index++]=cC;
					}

				}
				else if (cC!=0 && cArr[i]=='('){

					countArr[index++] = cC;
					cC = 0;
					oC++;

					if(i==cArr.length-1)
					{
						countArr[index++]=oC;
					}



				}

			}


			int odd;
			int even;
			int imBalance=0;
			for(int i=0;i<countArr.length ; i++)
			{
				if(i==0)
				{
					odd=countArr[i];
				}
				else if((i+1)% 2 == 0 && countArr[i-1]!=countArr[i])
				{
					imBalance++;
				}
			}


			return countArr;

		}


		public static void main(String... args)
		{
			System.out.println(Arrays.toString(getMinOperations("(()))(())(")));
		}

	}









