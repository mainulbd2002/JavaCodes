package com.mainul;

public class Problem12 {

	
	public long genarateTriangleNumber(int n)
	{
		long sum = 0;
		
		for (int i = 1; i < n + 1; i++)
			sum += i;
		
		return sum;
	}
	
	public int getDivisorCount (long n)
	{
		int count = 1;
		int sqrt = (int)Math.sqrt(n);
		
		for (int i = 1; i <= sqrt; i++)
			if (n % i == 0)
				count+=2;
		
		if ((sqrt * sqrt) == n)
			count --;
		
		
		return count;
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Problem12 p12 = new Problem12();
		long trinagleNumber = 0;
		for (int i = 1; ; i++)
		{
			//long trinagleNumber = p12.genarateTriangleNumber(i);
			trinagleNumber += i;
			int divisorCount = p12.getDivisorCount(trinagleNumber);
			
			System.out.println("Triangle::"+ trinagleNumber+" Div count:: "+divisorCount);
			
			if (divisorCount > 500)
				break;
		}

	}

}
