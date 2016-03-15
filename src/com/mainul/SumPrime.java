package com.mainul;

public class SumPrime {

	
	public double getNextPrime(double n)
	{
		double prime = n + ((n==2)?1:2);
		
		while (true)
		{
			if (isPrime(prime))
			{
				break;
			}
			prime +=2;
		}
		
		return prime;
	}
	
	public boolean isPrime(double n)
	{
		boolean flag = true;
		
		for (double i = 2; i < (n/2); i++)
		{
			if (n % i == 0)
			{
				flag = false;
				break;
			}
		}
		
		return flag;
	}
	
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		SumPrime sp = new SumPrime();
		double sum = 2;
		
		for (double i = 2; i < 2000000; )
		{
			i = sp.getNextPrime(i);
			System.out.println(i);
			sum +=i;
		}
		
		System.out.println(sum);

	}

}
