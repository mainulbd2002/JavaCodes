package com.mainul;

public class Problem20 
{
	
	public int[] arrayAdd(int[] a, int[] b)
	{
		int[] sum;
		int lenA = a.length;
		int lenB = b.length;
		
		if(lenA < lenB)
		{
			sum = b;
			b = a;
			a = sum;
		}
		lenA = a.length;
		lenB = b.length;
		
		sum = new int[lenA + 1];
		
		int carryOver = 0;
		int i =0;
		for (; i < lenB; i++)
		{
			int add = a[i] + b[i] + carryOver;
			carryOver = 0;
			if (add > 9)
			{
				carryOver = (int)(add/10);
				sum[i] = add - carryOver * 10;
			}
			else
			{
				sum[i] = add;
			}
		}
		
		for(; i < lenA; i++)
		{
			int add = a[i] + carryOver;
			carryOver = 0;
			if (add > 9)
			{
				carryOver = (int)(add/10);
				sum[i] = add - carryOver * 10;
			}
			else
			{
				sum[i] = add;
			}
		}
		sum[i] = carryOver;
		
		
		return sum;
	}
	
	public int[] arrayMultiplier(int[] a, int[] b)
	{
		int multiplied[] = new int[1];
		
		int lenA = a.length;
		int lenB = b.length;
		
		if(lenA < lenB)
		{
			multiplied = b;
			b = a;
			a = multiplied;
		}
		lenA = a.length;
		lenB = b.length;
		
		if ((a[lenA -1] * b[lenB -1]) + 8 > 10)
			multiplied = new int[lenA+lenB+2];
		else
			multiplied = new int[lenA+lenB+1];
		int i = 0;
		for (; i < lenB; i++)
		{
			int []tempMult = new int[lenA+2+i];
			int carryOver = 0;
			int j=0;
			for(; j < lenA; j++)
			{
				int res = a[j] * b[i] + carryOver;
				carryOver = 0;
				if(res > 9)
				{
					carryOver = (int)(res/10);
					tempMult[j+i] = res - (carryOver * 10);
				}
				else
				{
					tempMult[j+i] = res;
				}
			}
			//System.out.println(i+" "+j);
			tempMult[j+i] = carryOver;
			
			multiplied = arrayAdd(multiplied,tempMult);
		}
		
		return multiplied;
	}
	
	public int[] discardZero(int[] a)
	{
		int res[] = new int[1];
		
		int lenA = a.length;
		boolean flag = false;
		for (int i = lenA - 1; i >= 0; i--)
		{
			if (a[i] != 0 && !flag)
			{
				res = new int[i+1];
				flag = true;
			}
			if(flag)
			{
				res[i] = a[i];
			}
		}
		
		return res;
	}
	
	
	int []CreateIntArray(int a)
	{
		int []res = new int[1000];
		
		int carryOver = 0, i = 0;
		while (true)
		{
			if(a == 0) break;
			carryOver = (int)(a/10);
			res[i++] = a - (carryOver * 10);
			a = carryOver;
		}
		
		res = discardZero(res);
		
		return res;
	}
	
	public static void main(String[] args) 
	{
		Problem20 p20 = new Problem20();
		
		
		
		int []sum = p20.CreateIntArray(1000980);
		int []factor = {1};
		
		for (int i = 1; i < 101; i++)
		{
			factor = p20.arrayMultiplier(factor, p20.CreateIntArray(i));
			factor = p20.discardZero(factor);
		}
		
		
		int sumLen = factor.length;
		int sumNum = 0;
		for (int i = sumLen - 1; i >= 0; i--)
		{
			System.out.print(factor[i]);
			sumNum += factor[i]; 
		}
		System.out.print("\n"+sumNum);
		
		
		
	}

}
