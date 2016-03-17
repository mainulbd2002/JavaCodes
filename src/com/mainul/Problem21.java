package com.mainul;

public class Problem21 {

	
	public int getSumDiv(int n)
	{
		int sumDiv = 1;
		for (int i = 2; i <= n/2; i++)
		{
			if (n % i == 0)
			{
				sumDiv += i;
			}
		}
		return sumDiv;
	}
	
	public int isAmicable (int n)
	{
		int partner = 0;
		
		int divSum = getSumDiv(n);
		
		if (n == getSumDiv(divSum) && n != divSum)
			partner = divSum;
		
		
		return partner;
	}
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int []amicableNumber = new int[10000];
		
		Problem21 p21 = new Problem21();
		
		for (int i = 0; i < 10000; i++)
		{
			amicableNumber[i] = 0;
		}
		
		for (int i = 200; i < 10000; i++)
		{
			if(amicableNumber[i] == 0)
			{
				int partner = p21.isAmicable(i);
				if (partner != 0)
				{
					amicableNumber[i] = partner;
					amicableNumber[partner] = i;
					System.out.println(i+" "+partner);
				}
			}
		}
		
		int totSum = 0;
		for(int i=0; i < 10000;i++)
			totSum += amicableNumber[i];
		
		System.out.println(totSum);
		
		

	}

}
