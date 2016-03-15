package com.mainul;

public class Problem16 {

	
	public int arr[];
	public void arrMultiply(int multiplier)
	{
		int len = arr.length;
		int overflow = 0;
		for (int i=0; i<len;i++)
		{
			int res = arr[i] * multiplier + overflow;
			overflow = 0;
			
			if (res > 9)
			{
				overflow = (int)(res / 10);
				arr[i] = res - (overflow * 10);
			}
			else
				arr[i] = res;
		}
		
		if(overflow > 0)
		{
			int []newArr = new int[len+1];
			int i=0;
			for (; i<len;i++)
			{
				newArr[i] = arr[i];
			}
			newArr[i] = overflow;
			arr = newArr;
			
		}
		
	}
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Problem16 p16 = new Problem16();
		p16.arr = new int[1];
		p16.arr[0] = 1;
		
		for (int i=1; i<1001; i++)
		{
			p16.arrMultiply(2);
		}
		
		int len = p16.arr.length;
		//System.out.println(len);
		int sum = 0;
		for (int i = len -1; i >=0; i--)
		{
			System.out.print(p16.arr[i]);
			sum += p16.arr[i];
		}
		System.out.print("\n"+sum);
		

	}

}
