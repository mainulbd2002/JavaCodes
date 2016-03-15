package com.mainul;

public class Problem10 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int c = 0;
		for (int a = 0; a < 500; a++)
		{
			for (int b = a + 1; b < 500; b++)
			{
				int sum = a * a + b * b;
				c = 1000 - (a + b);
				if (sum == (c * c))
				{
					System.out.println(a+" "+b+" "+c);
					System.out.println(a*b*c);
				}
			}
		}
	

	}

}
